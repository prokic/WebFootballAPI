package project.football.web.dto.json.LeagueTable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDTeamDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueTableDTO {

    @JsonProperty(value = "_links")
    private LinkIDTeamDTO linkIDTeamDTO;

    private int position;

    private String teamName;

    @JsonProperty(value = "crestURI")
    private String picture;

    private int playedGames;

    private int points;

    private int goals;

    private int goalsAgainst;

    private int goalDifference;

    private int wins;

    private int draws;

    private int losses;

    private HomeAwayDTO home;

    private HomeAwayDTO away;

    public LinkIDTeamDTO getLinkIDTeamDTO() {
        return linkIDTeamDTO;
    }

    public void setLinkIDTeamDTO(LinkIDTeamDTO linkIDTeamDTO) {
        this.linkIDTeamDTO = linkIDTeamDTO;
    }

    public HomeAwayDTO getAway() {
        return away;
    }

    public void setAway(HomeAwayDTO away) {
        this.away = away;
    }

    public HomeAwayDTO getHome() {
        return home;
    }

    public void setHome(HomeAwayDTO home) {
        this.home = home;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getGoalDifference() {
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
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

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
