package project.football.web.dto.json.team.fixture;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesWithResultAndETandPKDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO linkIDSelfDTO;

    private int count;

    private List<FixtureWithResultOnlyETandPKDTO> fixtures;

    public LinkIDSelfDTO getLinkIDSelfDTO() {
        return linkIDSelfDTO;
    }

    public void setLinkIDSelfDTO(LinkIDSelfDTO linkIDSelfDTO) {
        this.linkIDSelfDTO = linkIDSelfDTO;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<FixtureWithResultOnlyETandPKDTO> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixtureWithResultOnlyETandPKDTO> fixtures) {
        this.fixtures = fixtures;
    }
}
