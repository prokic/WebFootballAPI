package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkSelfDTO {

    @JsonProperty(value = "self")
    private LinkDTO linkDTO;

    public LinkDTO getLinkDTO() {
        return linkDTO;
    }

    public void setLinkDTO(LinkDTO linkDTO) {
        this.linkDTO = linkDTO;
    }
}
