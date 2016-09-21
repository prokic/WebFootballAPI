package project.football.web.dto.json.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDTeamDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayersDTO {

    @JsonProperty(value = "_links")
    private LinkIDTeamDTO linkIDTeamDTO;

    @JsonProperty(value = "players")
    private List<PlayerDTO> listOfPlayers;

    public LinkIDTeamDTO getLinkIDTeamDTO() {
        return linkIDTeamDTO;
    }

    public void setLinkIDTeamDTO(LinkIDTeamDTO linkIDTeamDTO) {
        this.linkIDTeamDTO = linkIDTeamDTO;
    }

    public List<PlayerDTO> getListOfPlayers() {
        return listOfPlayers;
    }

    public void setListOfPlayers(List<PlayerDTO> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }
}
