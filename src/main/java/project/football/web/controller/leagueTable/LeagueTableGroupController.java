package project.football.web.controller.leagueTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import project.football.value.XAuthToken;
import project.football.web.dto.json.LeagueTable.LeagueTablesDTO;
import project.football.web.dto.json.leagueTableGroup.GroupS;
import project.football.web.dto.json.leagueTableGroup.LeagueTableGroupDTO;
import project.football.web.dto.json.leagueTableGroup.LeaguesTableGroupsDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("api/leaguetable/group")
public class LeagueTableGroupController {

    public static final String Url_1st_Part = "http://api.football-data.org/v1/competitions/";
    public static final String Url_2nd_Part = "/leagueTable";

    @Autowired
    private XAuthToken xAuthToken;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<LeagueTablesDTO> getTable (@PathVariable int id ){


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Auth-Token",xAuthToken.getAuth());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ParameterizedTypeReference<LeaguesTableGroupsDTO> responseType = new ParameterizedTypeReference<LeaguesTableGroupsDTO>() {};

        try {
            ResponseEntity<LeaguesTableGroupsDTO> restResult =  restTemplate.exchange(Url_1st_Part+id+Url_2nd_Part, HttpMethod.GET, entity, responseType);
            LeaguesTableGroupsDTO ResultEntity = restResult.getBody();

            GroupS cls = ResultEntity.getStandings();
            Class c = cls.getClass();

            try {
                Method m = c.getMethod("getGroupA");
                System.out.println("method = " + m.toString());
            }

            catch(NoSuchMethodException e) {
                System.out.println(e.toString());
            }


            return new ResponseEntity(ResultEntity, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }

    }


}
