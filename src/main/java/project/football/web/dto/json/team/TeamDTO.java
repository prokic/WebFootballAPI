package project.football.web.dto.json.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.util.codec.binary.StringUtils;
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

    private int value;

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

        if (squadMarketValue != null){
            this.squadMarketValue = squadMarketValue;
        }
        else {
            this.squadMarketValue = "No market value";
        }
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

    public int getValue() {
        if (this.squadMarketValue != null){
            String pomocna = this.squadMarketValue;
            String str = pomocna.replaceAll(",", "").trim();
            int index = str.indexOf(" ");
            return Integer.parseInt(str.substring(0,index));
        }
        else {
            return 0;
        }
    }
}
