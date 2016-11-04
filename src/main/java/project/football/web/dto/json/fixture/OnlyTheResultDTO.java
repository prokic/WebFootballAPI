package project.football.web.dto.json.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OnlyTheResultDTO {

    private String goalsHomeTeam;

    private String goalsAwayTeam;

    @JsonProperty(value = "extraTime")
    private ResultForExtraOrPenalty extraTime;

    @JsonProperty(value = "penaltyShootout")
    private ResultForExtraOrPenalty penaltyShoot;

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public void setGoalsHomeTeam(String goalsHomeTeam) {
        this.goalsHomeTeam = goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public void setGoalsAwayTeam(String goalsAwayTeam) {
        this.goalsAwayTeam = goalsAwayTeam;
    }

    public ResultForExtraOrPenalty getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(ResultForExtraOrPenalty extraTime) {
        this.extraTime = extraTime;
    }

    public ResultForExtraOrPenalty getPenaltyShoot() {
        return penaltyShoot;
    }

    public void setPenaltyShoot(ResultForExtraOrPenalty penaltyShoot) {
        this.penaltyShoot = penaltyShoot;
    }
}
