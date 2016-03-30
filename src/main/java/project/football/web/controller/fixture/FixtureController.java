package project.football.web.controller.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.football.value.XAuthToken;

@RestController
@RequestMapping("api/fixtures")
public class FixtureController {

    @Autowired
    private XAuthToken xAuthToken;


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<List<>> getFixtures(@PathVariable String id) {
//
//    }
}
