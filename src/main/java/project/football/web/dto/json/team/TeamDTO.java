package project.football.web.dto.json.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO id;

    private String name;

    private String shortName;

    private String squadMarketValue;

    @JsonProperty(value = "crestUrl")
    private String coatOfArms;

    public LinkIDSelfDTO getId() {
        return id;
    }

    public void setId(LinkIDSelfDTO id) {
        this.id = id;
    }

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
