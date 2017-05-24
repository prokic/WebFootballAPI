package project.football.web.controller.fixture.league;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.fixtures.FixturesWithResultDTO;
import project.football.web.dto.json.team.fixture.FixturesWithResultAndETandPKDTO;

import java.util.List;

@RestController
@RequestMapping("api/league/fixtures")
public class LeagueFixtureController {

    private static final String Url_1st_Part = "http://api.football-data.org/v1/competitions/";
    private static final String Url_2nd_Part = "/fixtures";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<FixturesWithResultDTO> getLeagueFixtures (@PathVariable int id){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Auth-Token", xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference<FixturesWithResultDTO> responseType = new ParameterizedTypeReference<FixturesWithResultDTO>() {};

        try {
            ResponseEntity<FixturesWithResultDTO> restResult = restTemplate.exchange(Url_1st_Part + id + Url_2nd_Part, HttpMethod.GET, entity, responseType);
            FixturesWithResultDTO ResultEntity = restResult.getBody();

            return new ResponseEntity(ResultEntity, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }

    }

}
