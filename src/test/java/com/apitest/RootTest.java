package com.apitest;

import com.apitest.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class RootTest extends BaseTCAPITest {

    @Test
    @DisplayName("Root API is available")
    public void apiIsAvailable() {
        ResponseEntity<String> response = restService.getForObject(endpoints.getRootEndpoint(), headers, String.class);
        assertThat("There is wrong response status! ", response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat("Response body doesn't have  proper message", response.getBody(), startsWith("This is a root of TeamCity REST API."));
    }
}
