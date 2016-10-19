package project.football.web.controller.fixture.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.fixture.FixturesWithResultOnlyDTO;

@RestController
@RequestMapping("api/team/fixtures")
public class FixtureTeamController {

    public static final String Url_1st_Part = "http://api.football-data.org/v1/teams/";
    public static final String Url_2nd_Part = "/fixtures";

    @Autowired
    private XAuthToken xAuthToken;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FixturesWithResultOnlyDTO> getTeam(@PathVariable String id,
                                                             @RequestParam(value = "year") String year) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<FixturesWithResultOnlyDTO> responseType = new ParameterizedTypeReference<FixturesWithResultOnlyDTO>() {
        };

        try {
            ResponseEntity<FixturesWithResultOnlyDTO> restResult = restTemplate.exchange(Url_1st_Part + id + Url_2nd_Part + "?season=" + year, HttpMethod.GET, entity, responseType);
            FixturesWithResultOnlyDTO ResultEntity = restResult.getBody();

            return new ResponseEntity(ResultEntity, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }


}
