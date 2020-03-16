
package com.portfolio.frontend.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "login",
    "password",
    "name",
    "surname",
    "phoneNumber",
    "phoneNumberConfirmed",
    "createDate",
    "lastLogin",
    "usersMailDto",
    "admin",
    "block"
})
public class UsersDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("phoneNumber")
    private Object phoneNumber;
    @JsonProperty("phoneNumberConfirmed")
    private Boolean phoneNumberConfirmed;
    @JsonProperty("createDate")
    private String createDate;
    @JsonProperty("lastLogin")
    private Object lastLogin;
    @JsonProperty("usersMailDto")
    private UsersMailDto usersMailDto;
    @JsonProperty("admin")
    private Boolean admin;
    @JsonProperty("block")
    private Boolean block;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonProperty("phoneNumber")
    public Object getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("phoneNumberConfirmed")
    public Boolean getPhoneNumberConfirmed() {
        return phoneNumberConfirmed;
    }

    @JsonProperty("phoneNumberConfirmed")
    public void setPhoneNumberConfirmed(Boolean phoneNumberConfirmed) {
        this.phoneNumberConfirmed = phoneNumberConfirmed;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("lastLogin")
    public Object getLastLogin() {
        return lastLogin;
    }

    @JsonProperty("lastLogin")
    public void setLastLogin(Object lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonProperty("usersMailDto")
    public UsersMailDto getUsersMailDto() {
        return usersMailDto;
    }

    @JsonProperty("usersMailDto")
    public void setUsersMailDto(UsersMailDto usersMailDto) {
        this.usersMailDto = usersMailDto;
    }

    @JsonProperty("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @JsonProperty("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @JsonProperty("block")
    public Boolean getBlock() {
        return block;
    }

    @JsonProperty("block")
    public void setBlock(Boolean block) {
        this.block = block;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
