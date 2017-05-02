package project.football.web.dto.json.fixtures;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesWithResultDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO linkIDSelfDTO;

    private int count;

    private List<FixtureWithResultDTO> fixtures;

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

    public List<FixtureWithResultDTO> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixtureWithResultDTO> fixtures) {
        this.fixtures = fixtures;
    }
}
