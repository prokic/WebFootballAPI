package project.football.web.dto.json.link;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkIDTeamsDTO {

    @JsonProperty(value = "teams")
    private LinksIDDTO linksIDDTO;

    public LinksIDDTO getLinksIDDTO() {
        return linksIDDTO;
    }

    public void setLinksIDDTO(LinksIDDTO linksIDDTO) {
        this.linksIDDTO = linksIDDTO;
    }
}
