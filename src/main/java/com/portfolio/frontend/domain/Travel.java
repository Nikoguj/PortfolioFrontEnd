package com.portfolio.frontend.domain;

import java.time.LocalDateTime;

public class Travel {
    private String destination;
    private String origin;
    private int distance;
    private String userSessionKey;
    private Long userId;
    private LocalDateTime startTime;

    public Travel(String destination, String origin, int distance, String userSessionKey, Long userId) {
        this.destination = destination;
        this.origin = origin;
        this.distance = distance;
        this.userSessionKey = userSessionKey;
        this.userId = userId;
        this.startTime = LocalDateTime.now();
    }

    public Travel() {
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getUserSessionKey() {
        return userSessionKey;
    }

    public void setUserSessionKey(String userSessionKey) {
        this.userSessionKey = userSessionKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
}
