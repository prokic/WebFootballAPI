package project.football.web.controller.players;

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
import project.football.web.dto.json.players.PlayersDTO;


@RestController
@RequestMapping("api/team/players")
public class PlayersController {


    public static final String Url_1st_Part = "http://api.football-data.org/v1/teams/";
    public static final String Url_2nd_Part = "/players";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <PlayersDTO> getPlayers(@PathVariable int id){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token",xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<PlayersDTO> responseType = new ParameterizedTypeReference<PlayersDTO>() {};

        try {
            ResponseEntity<PlayersDTO> restResult =  restTemplate.exchange(Url_1st_Part+id+Url_2nd_Part, HttpMethod.GET, entity, responseType);
            PlayersDTO ResultEntity = restResult.getBody();

            return new ResponseEntity(ResultEntity, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }

    }
}
