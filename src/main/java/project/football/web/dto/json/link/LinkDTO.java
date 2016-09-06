package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkDTO {

    @JsonProperty("href")
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
