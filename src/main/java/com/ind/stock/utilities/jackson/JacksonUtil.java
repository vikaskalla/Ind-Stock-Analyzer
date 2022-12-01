package com.ind.stock.utilities.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class JacksonUtil {

    public Mono<String> convertXmlToJson2(Mono<String> result) {
        XmlMapper xmlMapper = new XmlMapper();
        AtomicReference<JsonNode> jsonNode = new AtomicReference<>();
        return result.map(value->{
            try {
                value=value.trim();
                jsonNode.set(xmlMapper.readTree(value.getBytes()));
                ObjectMapper objMapper = new ObjectMapper();
                return objMapper.writeValueAsString(jsonNode);
            }catch (IOException ex) {
                ex.printStackTrace();
            }
            return value;
        });
    }
}
