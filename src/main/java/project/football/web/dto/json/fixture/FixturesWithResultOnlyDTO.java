package project.football.web.dto.json.fixture;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinksFixtureHrefDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesWithResultOnlyDTO {

    @JsonProperty(value = "_links")
    private LinksFixtureHrefDTO linksFixtureHrefDTO;

    private int count;

    private List<FixtureWithResultOnlyDTO> fixtures;

    public LinksFixtureHrefDTO getLinksFixtureHrefDTO() {
        return linksFixtureHrefDTO;
    }

    public void setLinksFixtureHrefDTO(LinksFixtureHrefDTO linksFixtureHrefDTO) {
        this.linksFixtureHrefDTO = linksFixtureHrefDTO;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<FixtureWithResultOnlyDTO> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixtureWithResultOnlyDTO> fixtures) {
        this.fixtures = fixtures;
    }
}
