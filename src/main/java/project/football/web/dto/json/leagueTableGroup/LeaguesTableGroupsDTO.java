package project.football.web.dto.json.leagueTableGroup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkSelfDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguesTableGroupsDTO {

    @JsonProperty(value = "leagueCaption")
    private String name;

    private int matchday;

    private GroupS standings;

    @JsonProperty(value = "_links")
    private LinkSelfDTO linkSelfDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public GroupS getStandings() {
        return standings;
    }

    public void setStandings(GroupS standings) {
        this.standings = standings;
    }

    public LinkSelfDTO getLinkSelfDTO() {
        return linkSelfDTO;
    }

    public void setLinkSelfDTO(LinkSelfDTO linkSelfDTO) {
        this.linkSelfDTO = linkSelfDTO;
    }
}
