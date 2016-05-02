package project.football.web.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.team.TeamDTO;
import project.football.web.dto.json.team.TeamsDTO;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity <List<TeamDTO>> getTeams (@PathVariable String id){

        RestTemplate rest = new RestTemplate();
        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.set("X-Auth-Token",""+xAuthToken.getAuth());
        TeamsDTO teamsDTOJSON = rest.getForObject("http://api.football-data.org/v1/soccerseasons/"+id+"/teams",TeamsDTO.class,httpHeader);
        List<TeamDTO> listOfTeams =  teamsDTOJSON.getTeamDTO();
        return new ResponseEntity<>(listOfTeams, HttpStatus.OK);
    }
}
