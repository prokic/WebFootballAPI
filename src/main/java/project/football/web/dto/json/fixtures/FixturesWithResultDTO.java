package project.football.web.dto.json.fixtures;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturesWithResultDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO linkIDSelfDTO;

    private int count;

    private HashMap<Integer, List<FixtureWithResultDTO>> fixtures;

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

    public HashMap<Integer, List<FixtureWithResultDTO>> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<FixtureWithResultDTO> fixtures) {
        Collections.sort(fixtures);

        for (int i = 0; i < fixtures.size(); i++) {
            if (fixtures.get(i).getMatchday() <= 0) {
                fixtures.remove(i);
                i--;
            }
            else {
                break;
            }
        }

        HashMap<Integer, List<FixtureWithResultDTO>> mapa = new HashMap<>();

        for (int i = 0; i < fixtures.size(); i++) {
            int matchday = fixtures.get(i).getMatchday();
            ArrayList<FixtureWithResultDTO> listaWithMatchdays = new ArrayList<>();
            for (int j = i; j < fixtures.size(); j++) {
                FixtureWithResultDTO oneFixture = fixtures.get(j);
                if (matchday == oneFixture.getMatchday()) {
                    listaWithMatchdays.add(oneFixture);
                } else {
                    mapa.put(matchday, listaWithMatchdays);
                    i = j - 1;
                    break;
                }
            }
        }
        this.fixtures = mapa;
    }
}
