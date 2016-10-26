package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkSelfDTO {

    @JsonProperty(value = "self")
    private LinksIDDTO linksIDDTOself;

    @JsonProperty(value = "competition")
    private LinksIDDTO linksIDDTOCompetiton;

    public LinksIDDTO getLinksIDDTOself() {
        return linksIDDTOself;
    }

    public void setLinksIDDTOself(LinksIDDTO linksIDDTOself) {
        this.linksIDDTOself = linksIDDTOself;
    }

    public LinksIDDTO getLinksIDDTOCompetiton() {
        return linksIDDTOCompetiton;
    }

    public void setLinksIDDTOCompetiton(LinksIDDTO linksIDDTOCompetiton) {
        this.linksIDDTOCompetiton = linksIDDTOCompetiton;
    }
}
