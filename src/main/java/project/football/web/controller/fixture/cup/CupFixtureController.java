package project.football.web.controller.fixture.cup;

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
import project.football.web.dto.json.fixtures.cup.CupFixturesWithResultDTO;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/cup/fixtures")
public class CupFixtureController {

    private static final String Url_1st_Part = "http://api.football-data.org/v1/competitions/";
    private static final String Url_2nd_Part = "/fixtures";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<HashMap<Integer,List<CupFixturesWithResultDTO>>> getLeagueFixtures (@PathVariable int id){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Auth-Token", xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference<CupFixturesWithResultDTO> responseType = new ParameterizedTypeReference<CupFixturesWithResultDTO>() {};

        try {
            ResponseEntity<CupFixturesWithResultDTO> restResult = restTemplate.exchange(Url_1st_Part + id + Url_2nd_Part, HttpMethod.GET, entity, responseType);
            CupFixturesWithResultDTO ResultEntity = restResult.getBody();

            return new ResponseEntity(ResultEntity,HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }

    }
}
