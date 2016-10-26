package project.football.web.controller.leagueTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.LeagueTable.LeagueTablesDTO;
import project.football.web.dto.json.LeagueTable.nameofcompetition.Competition;

@RestController
@RequestMapping("api/leaguetable")
public class LeagueTableController {

    private static final String Url_1st_Part = "http://api.football-data.org/v1/competitions/";
    private static final String Url_2nd_Part = "/leagueTable";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LeagueTablesDTO> getTable(@PathVariable int id,
                                                    @RequestParam(value = "competition", required = false) boolean competition) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token", xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        if (competition) {
            ParameterizedTypeReference<Competition> responseType = new ParameterizedTypeReference<Competition>() {
            };

            try {
                ResponseEntity<Competition> restResult = restTemplate.exchange(Url_1st_Part + id, HttpMethod.GET, entity, responseType);
                Competition ResultEntity = restResult.getBody();

                return new ResponseEntity(ResultEntity, HttpStatus.OK);
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(e.getStatusCode());
            }
        } else {

            ParameterizedTypeReference<LeagueTablesDTO> responseType = new ParameterizedTypeReference<LeagueTablesDTO>() {
            };

            try {
                ResponseEntity<LeagueTablesDTO> restResult = restTemplate.exchange(Url_1st_Part + id + Url_2nd_Part, HttpMethod.GET, entity, responseType);
                LeagueTablesDTO ResultEntity = restResult.getBody();

                return new ResponseEntity(ResultEntity, HttpStatus.OK);
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(e.getStatusCode());
            }

        }

    }
}
