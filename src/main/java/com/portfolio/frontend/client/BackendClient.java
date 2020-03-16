package com.portfolio.frontend.client;

import com.portfolio.frontend.config.BackendConfig;
import com.portfolio.frontend.domain.LoggedInUser;
import com.portfolio.frontend.domain.Users;
import com.portfolio.frontend.domain.UsersDto;
import com.portfolio.frontend.domain.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class BackendClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackendClient.class);

    @Autowired
    private BackendConfig backendConfig;

    @Autowired
    private RestTemplate restTemplate;

    public UsersDto registerUser(Users users, String mail) throws URISyntaxException {

        String uri = "http://localhost:8081/v1/user/createUser/" + mail;
        URI uri1 = new URI(uri);

        ResponseEntity<UsersDto> responseEntity = restTemplate.postForEntity(uri1, users, UsersDto.class);

        return responseEntity.getBody();
    }

    public LoggedInUser loginUser(String login, String password) throws URISyntaxException {
        String uri = "http://localhost:8081/v1/user/login/" + login + "/" + password;
        URI uri1 = new URI(uri);

        LoggedInUser responseEntity = restTemplate.getForObject(uri1, LoggedInUser.class);

        System.out.println(responseEntity.getUserID());
        return responseEntity;
    }

    public Weather getWeather(String directions, String origin, int distance, int startTime, String userSessionKey, Long userId) throws URISyntaxException {
        System.out.println(userSessionKey);
        System.out.println(userId);
        URI uri1 = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/v1/weather/getPointsWeather/" + directions + "/" + origin + "/" + distance + "/" + startTime)
                .queryParam("userSessionKey",userSessionKey)
                .queryParam("userId", userId).build().encode().toUri();

        Weather responseEntity = restTemplate.getForObject(uri1, Weather.class);

        return responseEntity;
    }
}