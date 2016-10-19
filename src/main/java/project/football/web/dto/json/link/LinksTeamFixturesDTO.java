package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinksTeamFixturesDTO {

    @JsonProperty(value = "self")
    private LinkDTO linkForHeadToHeadFixtures;

    private LinkDTO competition;

    private LinkDTO homeTeam;

    private LinkDTO awayTeam;

    public LinkDTO getLinkForHeadToHeadFixtures() {
        return linkForHeadToHeadFixtures;
    }

    public void setLinkForHeadToHeadFixtures(LinkDTO linkForHeadToHeadFixtures) {
        this.linkForHeadToHeadFixtures = linkForHeadToHeadFixtures;
    }

    public LinkDTO getCompetition() {
        return competition;
    }

    public void setCompetition(LinkDTO competition) {
        this.competition = competition;
    }

    public LinkDTO getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(LinkDTO homeTeam) {
        this.homeTeam = homeTeam;
    }

    public LinkDTO getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(LinkDTO awayTeam) {
        this.awayTeam = awayTeam;
    }
}
