package project.football.web.dto.json.LeagueTable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkSelfDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueTablesDTO {

    @JsonProperty(value = "leagueCaption")
    private String name;

    private int matchday;

    @JsonProperty(value = "standing")
    private List<LeagueTableDTO> teams;

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

    public List<LeagueTableDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<LeagueTableDTO> teams) {
        this.teams = teams;
    }

    public LinkSelfDTO getLinkSelfDTO() {
        return linkSelfDTO;
    }

    public void setLinkSelfDTO(LinkSelfDTO linkSelfDTO) {
        this.linkSelfDTO = linkSelfDTO;
    }
}
