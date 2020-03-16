package com.portfolio.frontend.domain;

public class LoggedInUser {

    private String status;
    private String sessionKey;
    private Long userID;

    public LoggedInUser(String status, String sessionKey, Long userID) {
        this.status = status;
        this.sessionKey = sessionKey;
        this.userID = userID;
    }

    public LoggedInUser() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
