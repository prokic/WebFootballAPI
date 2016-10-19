package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkSelfDTO {

    @JsonProperty(value = "self")
    private LinkDTO linkDTO;

    @JsonProperty(value = "competition")
    private LinksIDDTO linksIDDTO;

    public LinkDTO getLinkDTO() {
        return linkDTO;
    }

    public void setLinkDTO(LinkDTO linkDTO) {
        this.linkDTO = linkDTO;
    }

    public LinksIDDTO getLinksIDDTO() {
        return linksIDDTO;
    }

    public void setLinksIDDTO(LinksIDDTO linksIDDTO) {
        this.linksIDDTO = linksIDDTO;
    }
}
