package com.ecnu.onion.knowledge;

import com.ecnu.onion.knowledge.dao.PropertyDao;
import com.ecnu.onion.knowledge.domain.Property;
import com.ecnu.onion.knowledge.domain.PropertyValue;
import com.ecnu.onion.knowledge.domain.Radar;
import com.ecnu.onion.knowledge.util.KeyUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class KnowledgeApplicationTests {

    @Autowired
    private PropertyDao propertyDao;

    @Test
    void deleteAll() {
        propertyDao.deleteAll();
    }
    @Test
    void contextLoads() throws IOException {
        File file = new File("/Users/root1/Desktop/radar_fusion_done.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        Map<String, Map<String, String>> map = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            String[] split = line.split(" ", 3);
            if ("...".equals(split[2])) {
                continue;
            }
            Map<String, String> propertyMap = map.computeIfAbsent(split[0], $ -> new HashMap<>());
            propertyMap.put(split[1], propertyMap.getOrDefault(split[1], "") + split[2] + " ");
        }
        List<Property> list = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
            Radar radar = new Radar();
            radar.setId(KeyUtil.getId());
            String key = entry.getKey();
            radar.setName(key);
            Set<Map.Entry<String, String>> entrySet = entry.getValue().entrySet();
            for (Map.Entry<String, String> e : entrySet) {
                Property property = new Property();
                property.setRadar(radar);
                property.setKey(e.getKey());
                PropertyValue propertyValue = new PropertyValue();
                propertyValue.setId(KeyUtil.getId());
                propertyValue.setValue(e.getValue());
                property.setValue(propertyValue);
                list.add(property);
            }
        }
        propertyDao.saveAll(list);
    }

}
