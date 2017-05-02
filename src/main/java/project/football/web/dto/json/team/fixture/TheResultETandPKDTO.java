package project.football.web.dto.json.team.fixture;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TheResultETandPKDTO {

    private String goalsHomeTeam;

    private String goalsAwayTeam;

    @JsonProperty(value = "extraTime")
    private ResultForExtraAndPenalty extraTime;

    @JsonProperty(value = "penaltyShootout")
    private ResultForExtraAndPenalty penaltyShoot;

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

    public ResultForExtraAndPenalty getExtraTime() {
        return extraTime;
    }

    public void setExtraTime(ResultForExtraAndPenalty extraTime) {
        this.extraTime = extraTime;
    }

    public ResultForExtraAndPenalty getPenaltyShoot() {
        return penaltyShoot;
    }

    public void setPenaltyShoot(ResultForExtraAndPenalty penaltyShoot) {
        this.penaltyShoot = penaltyShoot;
    }
}
