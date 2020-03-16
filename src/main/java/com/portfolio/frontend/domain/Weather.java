
package com.portfolio.frontend.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listOfAllPoints"
})
public class Weather {

    @JsonProperty("listOfAllPoints")
    private List<ListOfAllPoint> listOfAllPoints = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("listOfAllPoints")
    public List<ListOfAllPoint> getListOfAllPoints() {
        return listOfAllPoints;
    }

    @JsonProperty("listOfAllPoints")
    public void setListOfAllPoints(List<ListOfAllPoint> listOfAllPoints) {
        this.listOfAllPoints = listOfAllPoints;
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
