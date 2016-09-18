package project.football.web.dto.json.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamShowDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO linkIDSelfDTO;

    private String name;

    private String shortName;

    private String squadMarketValue;

    @JsonProperty(value = "crestUrl")
    private String linkToCoatOfArms;

    public LinkIDSelfDTO getLinkIDSelfDTO() {
        return linkIDSelfDTO;
    }

    public void setLinkIDSelfDTO(LinkIDSelfDTO linkIDSelfDTO) {
        this.linkIDSelfDTO = linkIDSelfDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSquadMarketValue() {
        return squadMarketValue;
    }

    public void setSquadMarketValue(String squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    public String getLinkToCoatOfArms() {
        return linkToCoatOfArms;
    }

    public void setLinkToCoatOfArms(String linkToCoatOfArms) {
        this.linkToCoatOfArms = linkToCoatOfArms;
    }
}
