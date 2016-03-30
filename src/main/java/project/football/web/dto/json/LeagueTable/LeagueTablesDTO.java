package project.football.web.dto.json.LeagueTable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueTablesDTO {

    @JsonProperty(value = "leagueCaption")
    private String name;

    private int matchday;

    //standing

    //linkovi
}
