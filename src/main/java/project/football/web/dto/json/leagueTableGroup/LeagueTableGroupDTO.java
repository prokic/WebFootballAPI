package project.football.web.dto.json.leagueTableGroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueTableGroupDTO {

    private String group;

    private int rank;

    private String team;

    private int teamId;

    private int playedGames;

    @JsonProperty(value = "crestURI")
    private String LinkToCoatOfArms;

    private int points;

    private int goals;

    private int goalsAgaints;

    private int goalsDifference;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public String getLinkToCoatOfArms() {
        return LinkToCoatOfArms;
    }

    public void setLinkToCoatOfArms(String linkToCoatOfArms) {
        LinkToCoatOfArms = linkToCoatOfArms;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgaints() {
        return goalsAgaints;
    }

    public void setGoalsAgaints(int goalsAgaints) {
        this.goalsAgaints = goalsAgaints;
    }

    public int getGoalsDifference() {
        return goalsDifference;
    }

    public void setGoalsDifference(int goalsDifference) {
        this.goalsDifference = goalsDifference;
    }
}
