package project.football.web.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.team.TeamDTO;
import project.football.web.dto.json.team.TeamsDTO;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    public static final String Url_Part_One = "http://api.football-data.org/v1/competitions/";
    public static final String Url_Part_Two = "/teams";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity <List<TeamDTO>> getTeams (@PathVariable String id){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token",xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<TeamsDTO> responseType = new ParameterizedTypeReference<TeamsDTO>() {};

        try {
            ResponseEntity<TeamsDTO> restResult =  restTemplate.exchange(Url_Part_One+id+Url_Part_Two, HttpMethod.GET, entity, responseType);
            TeamsDTO ResultEntity = restResult.getBody();



            return new ResponseEntity(ResultEntity.getTeamDTO(),HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }
}
