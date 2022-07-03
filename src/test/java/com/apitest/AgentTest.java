package com.apitest;

import com.apitest.config.AppConfig;
import com.apitest.dataModel.Agents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AgentTest extends BaseTCAPITest {

    @Test
    @DisplayName("Get all agents")
    public void getAllAgents() {
        ResponseEntity<Agents> response = restService.getForObject(endpoints.getRootEndpoint(), headers, Agents.class, endpoints.getAgentsEndpoint("getAllAgents"));
        assertThat("There is wrong response status! ", response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat("Count of agents is not as expected", response.getBody().getCount(), equalTo(1));
    }
}
