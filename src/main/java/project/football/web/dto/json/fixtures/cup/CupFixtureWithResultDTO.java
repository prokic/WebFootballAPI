package project.football.web.dto.json.fixtures.cup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import project.football.web.dto.json.link.LinkFixtureWithIdHomeAndAwayDTO;
import project.football.web.dto.json.team.fixture.TheResultETandPKDTO;

import java.util.Comparator;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CupFixtureWithResultDTO implements Comparable<CupFixtureWithResultDTO>{

    static {
        timeZone = DateTimeZone.forID("Europe/Belgrade");
    }

    private static DateTimeZone timeZone;

    @JsonProperty(value = "_links")
    private LinkFixtureWithIdHomeAndAwayDTO LinkFixtureWithIdHomeAndAwayDTO;

    private Date date;

    private String status;

    private int matchday;

    private String homeTeamName;

    private String awayTeamName;

    @JsonProperty(value = "result")
    private TheResultETandPKDTO onlyTheResultDTO;

    public LinkFixtureWithIdHomeAndAwayDTO getLinkFixtureWithIdHomeAndAwayDTO() {
        return LinkFixtureWithIdHomeAndAwayDTO;
    }

    public void setLinkFixtureWithIdHomeAndAwayDTO(LinkFixtureWithIdHomeAndAwayDTO linkFixtureWithIdHomeAndAwayDTO) {
        LinkFixtureWithIdHomeAndAwayDTO = linkFixtureWithIdHomeAndAwayDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateString) {

        DateTime dateTime = new DateTime(dateString, timeZone);
        this.date = dateTime.toDate();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public void setAwayTeamName(String awayTeamName) {
        this.awayTeamName = awayTeamName;
    }

    public TheResultETandPKDTO getOnlyTheResultDTO() {
        return onlyTheResultDTO;
    }

    public void setOnlyTheResultDTO(TheResultETandPKDTO onlyTheResultDTO) {
        this.onlyTheResultDTO = onlyTheResultDTO;
    }

    @Override
    public int compareTo(CupFixtureWithResultDTO obj) {
        return this.matchday - obj.getMatchday();
    }

    static class FixtureDateComparator implements Comparator<CupFixtureWithResultDTO>
    {

        public int compare(CupFixtureWithResultDTO FirstFixture, CupFixtureWithResultDTO SecondFixture)
        {
            return FirstFixture.getDate().compareTo(SecondFixture.getDate());
        }
    }
}
