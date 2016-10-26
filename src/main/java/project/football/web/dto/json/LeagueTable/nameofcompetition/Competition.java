package project.football.web.dto.json.LeagueTable.nameofcompetition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Competition {

    @JsonProperty(value = "caption")
    private String nameOfCompetition;

    public String getNameOfCompetition() {
        return nameOfCompetition;
    }

    public void setNameOfCompetition(String nameOfCompetition) {
        this.nameOfCompetition = nameOfCompetition;
    }
}
