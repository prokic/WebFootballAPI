package project.football.web.controller.season;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.SeasonDTO;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/season")
public class SeasonController {

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{year}",method = RequestMethod.GET)
    public ResponseEntity<List<SeasonDTO>> getSeason (@PathVariable String year){

        RestTemplate rest = new RestTemplate();
        HttpHeaders httpHeader = new HttpHeaders();
        httpHeader.set("X-Auth-Token",""+xAuthToken.getAuth());
        SeasonDTO [] arraySes = rest.getForObject("http://api.football-data.org/v1/soccerseasons/?season="+year,SeasonDTO[].class,httpHeader);
        List<SeasonDTO> listSeasonDTO = Arrays.asList(arraySes);

        return new ResponseEntity(listSeasonDTO, HttpStatus.OK);
    }

}
