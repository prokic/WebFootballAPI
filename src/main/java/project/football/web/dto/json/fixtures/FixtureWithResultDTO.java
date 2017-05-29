package project.football.web.dto.json.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import project.football.web.dto.json.link.LinkSelfDTO;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureWithResultDTO implements Comparable<FixtureWithResultDTO>{

    static{
        timeZone = DateTimeZone.forID("Europe/Belgrade");
    }

    private static DateTimeZone timeZone;

    @JsonProperty(value = "_links")
    private LinkSelfDTO linkSelfDTO;

    private Date date;

    private String status;

    private int matchday;

    private String homeTeamName;

    private String awayTeamName;

    @JsonProperty(value = "result")
    private TheResultDTO theResultDTO;

    public LinkSelfDTO getLinkSelfDTO() {
        return linkSelfDTO;
    }

    public void setLinkSelfDTO(LinkSelfDTO linkSelfDTO) {
        this.linkSelfDTO = linkSelfDTO;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateString) {

        DateTime dateTime = new DateTime( dateString, timeZone );
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

    public TheResultDTO getTheResultDTO() {
        return theResultDTO;
    }

    public void setTheResultDTO(TheResultDTO theResultDTO) {
        this.theResultDTO = theResultDTO;
    }

    @Override
    public int compareTo(FixtureWithResultDTO obj) {
        return this.matchday - obj.getMatchday();
    }
}
