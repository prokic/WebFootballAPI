package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinksFixtureDTO {

    @JsonProperty(value = "team")
    private LinksFixtureHrefDTO linksFixtureHrefDTO;

    public LinksFixtureHrefDTO getLinksFixtureHrefDTO() {
        return linksFixtureHrefDTO;
    }

    public void setLinksFixtureHrefDTO(LinksFixtureHrefDTO linksFixtureHrefDTO) {
        this.linksFixtureHrefDTO = linksFixtureHrefDTO;
    }
}
