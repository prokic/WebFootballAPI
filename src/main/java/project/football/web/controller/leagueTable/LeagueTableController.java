package project.football.web.controller.leagueTable;

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
import project.football.web.dto.json.LeagueTable.LeagueTablesDTO;

@RestController
@RequestMapping("api/leaguetable")
public class LeagueTableController {

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<LeagueTablesDTO> getTable (@PathVariable int id ){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-Auth-Token",""+xAuthToken.getAuth());
        RestTemplate rest = new RestTemplate();
        LeagueTablesDTO leagueTableDTO = rest.getForObject("http://api.football-data.org/v1/soccerseasons/"+id+"/leagueTable",LeagueTablesDTO.class,httpHeaders);
        return new ResponseEntity<>(leagueTableDTO, HttpStatus.OK);

    }
}
