package com.apitest.config;

import com.apitest.spring.MapPropertiesInject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
public class EndpointProperties {
    @Value("${endpoints.root}")
    private String rootEndpoint;

    @MapPropertiesInject("endpoints.agents")
    private Map<String, String> agentsEndpoints;

    @MapPropertiesInject("endpoints.project")
    private Map<String, String> projectEndpoints;

    public String getAgentsEndpoint(String key){
        return agentsEndpoints.get(key);
    }

    public String getProjectEndpoint(String key){
        return projectEndpoints.get(key);
    }

}
