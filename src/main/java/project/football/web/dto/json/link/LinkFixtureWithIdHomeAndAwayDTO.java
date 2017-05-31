package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkFixtureWithIdHomeAndAwayDTO extends LinkSelfDTO{

    private LinksIDDTO homeTeam;

    private LinksIDDTO awayTeam;

    public LinksIDDTO getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(LinksIDDTO homeTeam) {
        this.homeTeam = homeTeam;
    }

    public LinksIDDTO getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(LinksIDDTO awayTeam) {
        this.awayTeam = awayTeam;
    }
}
