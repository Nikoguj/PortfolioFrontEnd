
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
    "mail",
    "mailConfirmed",
    "scheduledMail"
})
public class UsersMailDto {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("mailConfirmed")
    private Boolean mailConfirmed;
    @JsonProperty("scheduledMail")
    private Boolean scheduledMail;
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

    @JsonProperty("mail")
    public String getMail() {
        return mail;
    }

    @JsonProperty("mail")
    public void setMail(String mail) {
        this.mail = mail;
    }

    @JsonProperty("mailConfirmed")
    public Boolean getMailConfirmed() {
        return mailConfirmed;
    }

    @JsonProperty("mailConfirmed")
    public void setMailConfirmed(Boolean mailConfirmed) {
        this.mailConfirmed = mailConfirmed;
    }

    @JsonProperty("scheduledMail")
    public Boolean getScheduledMail() {
        return scheduledMail;
    }

    @JsonProperty("scheduledMail")
    public void setScheduledMail(Boolean scheduledMail) {
        this.scheduledMail = scheduledMail;
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
