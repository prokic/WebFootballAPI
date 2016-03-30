package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkIDSelfDTO {

    @JsonProperty(value = "self")
    private LinksIDDTO linkDTO;

    public LinksIDDTO getLinkDTO() {
        return linkDTO;
    }

    public void setLinkDTO(LinksIDDTO linkDTO) {
        this.linkDTO = linkDTO;
    }
}
