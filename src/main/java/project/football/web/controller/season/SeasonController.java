package project.football.web.controller.season;

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
import project.football.web.dto.json.SeasonDTO;

import java.util.List;

@RestController
@RequestMapping("api/season")
public class SeasonController {

    public static final String Url = "http://api.football-data.org/v1/competitions/?season=";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{year}",method = RequestMethod.GET)
    public ResponseEntity<SeasonDTO[]> getSeason (@PathVariable String year){

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token",xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<List<SeasonDTO>> responseType = new ParameterizedTypeReference<List<SeasonDTO>>() {};

        try {
            ResponseEntity<List<SeasonDTO>> restResult =  restTemplate.exchange(Url+year, HttpMethod.GET, entity, responseType);
            return new ResponseEntity(restResult.getBody(),HttpStatus.OK);
        } catch (HttpClientErrorException e) {
           return new ResponseEntity<>(e.getStatusCode());
        }
    }

}
