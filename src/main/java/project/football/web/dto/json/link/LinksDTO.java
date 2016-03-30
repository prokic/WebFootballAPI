package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinksDTO {

    @JsonProperty("self")
    private LinksIDDTO ownLink;

    private LinksIDDTO teams;

    private LinksIDDTO fixtures;

    private LinksIDDTO leagueTable;

    public LinksIDDTO getOwnLink() {
        return ownLink;
    }

    public void setOwnLink(LinksIDDTO ownLink) {
        this.ownLink = ownLink;
    }

    public LinksIDDTO getTeams() {
        return teams;
    }

    public void setTeams(LinksIDDTO teams) {
        this.teams = teams;
    }

    public LinksIDDTO getFixtures() {
        return fixtures;
    }

    public void setFixtures(LinksIDDTO fixtures) {
        this.fixtures = fixtures;
    }

    public LinksIDDTO getLeagueTable() {
        return leagueTable;
    }

    public void setLeagueTable(LinksIDDTO leagueTable) {
        this.leagueTable = leagueTable;
    }
}
