package project.football.web.dto.json.link;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LinksIDDTO {

    @JsonProperty("href")
    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {

        int index = link.lastIndexOf('/');

        this.link = link.substring(index+1,link.length());
    }
}
