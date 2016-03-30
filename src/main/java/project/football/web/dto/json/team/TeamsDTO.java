package project.football.web.dto.json.team;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsDTO {

    @JsonProperty(value = "teams")
    private List<TeamDTO> teamDTO;

    public List<TeamDTO> getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(List<TeamDTO> teamDTO) {
        this.teamDTO = teamDTO;
    }
}
