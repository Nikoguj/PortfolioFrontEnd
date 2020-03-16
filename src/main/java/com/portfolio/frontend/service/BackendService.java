package com.portfolio.frontend.service;

import com.portfolio.frontend.client.BackendClient;
import com.portfolio.frontend.domain.LoggedInUser;
import com.portfolio.frontend.domain.Users;
import com.portfolio.frontend.domain.UsersDto;
import com.portfolio.frontend.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;


@Service
public class BackendService {

    @Autowired
    private BackendClient backendClient;

    public UsersDto registerUser(Users users, String mail) throws URISyntaxException {
        return backendClient.registerUser(users, mail);
    }

    public LoggedInUser loginUser(String login, String password) throws URISyntaxException {
        return backendClient.loginUser(login, password);
    }

    public Weather getWeather(String directions, String origin, int distance, int startTime, String userSessionKey, Long userId) throws URISyntaxException {
        return backendClient.getWeather(directions, origin, distance, startTime, userSessionKey, userId);
    }
}
