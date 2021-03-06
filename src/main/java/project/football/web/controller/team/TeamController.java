package project.football.web.controller.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.team.TeamShowDTO;

@Controller
@RequestMapping("api/team")
public class TeamController {

    public static final String Url_Part_One = "http://api.football-data.org/v1/teams/";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<TeamShowDTO> getTeam (@PathVariable String id){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token",xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<TeamShowDTO> responseType = new ParameterizedTypeReference<TeamShowDTO>() {};

        try {
            ResponseEntity<TeamShowDTO> restResult =  restTemplate.exchange(Url_Part_One+id, HttpMethod.GET, entity, responseType);
            TeamShowDTO ResultEntity = restResult.getBody();

            return new ResponseEntity(ResultEntity, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }
}
