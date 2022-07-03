package com.apitest;

import com.apitest.config.EndpointProperties;
import com.apitest.services.RestService;
import com.apitest.services.Tokenizer;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

abstract class BaseTCAPITest {

    HttpHeaders headers;

    @Autowired
    RestService restService;

    @Autowired
    Tokenizer tokenizer;

    @Autowired
    EndpointProperties endpoints;

    @BeforeEach
    public void prepareDefaultHeaders() {
        headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + tokenizer.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    public static String generateRandomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }
}
