package project.football.web.dto.json.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTOJSON {

    @JsonProperty(value = "teams")
    private TeamsDTO teamsDTO;

    public TeamsDTO getTeamsDTO() {
        return teamsDTO;
    }

    public void setTeamsDTO(TeamsDTO teamsDTO) {
        this.teamsDTO = teamsDTO;
    }
}
