package project.football.web.dto.json.fixtures.cup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkIDSelfDTO;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CupFixturesWithResultDTO {

    @JsonProperty(value = "_links")
    private LinkIDSelfDTO linkIDSelfDTO;

    private int count;

    private HashMap<Integer, HashMap<Integer, HashMap<Integer, CupFixtureWithResultDTO>>> fixtures;

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

    public HashMap<Integer, HashMap<Integer, HashMap<Integer, CupFixtureWithResultDTO>>> getFixtures() {
        return fixtures;
    }

    public void setFixtures(List<CupFixtureWithResultDTO> fixtures) {
        Collections.sort(fixtures);

        for (int i = 0; i < fixtures.size(); i++) {
            if (fixtures.get(i).getMatchday() <= 0) {
                fixtures.remove(i);
                i--;
            } else {
                break;
            }
        }

        HashMap<Integer, HashMap<Integer, List<CupFixtureWithResultDTO>>> mapa = new HashMap<>();
        HashMap<Integer, HashMap<Integer, HashMap<Integer, CupFixtureWithResultDTO>>> allMap = new HashMap<>();
        int homeId;
        int awayId;

        for (int i = 0; i < fixtures.size(); i++) {
            int matchday = fixtures.get(i).getMatchday();
//            ArrayList<CupFixtureWithResultDTO> listaWithMatchdays = new ArrayList<>();
            HashMap<Integer, CupFixtureWithResultDTO> home = new HashMap<>();
            HashMap<Integer, CupFixtureWithResultDTO> away = new HashMap<>();
//            HashMap<Integer, HashMap<Integer, CupFixtureWithResultDTO>> onlyAway = new HashMap<>();
            for (int j = i; j < fixtures.size(); j++) {
                CupFixtureWithResultDTO oneFixture = fixtures.get(j);
                homeId = Integer.parseInt(oneFixture.getLinkFixtureWithIdHomeAndAwayDTO().getHomeTeam().getLink());
                awayId = Integer.parseInt(oneFixture.getLinkFixtureWithIdHomeAndAwayDTO().getAwayTeam().getLink());
                if (matchday == oneFixture.getMatchday()) {
                    if (home.containsKey(awayId) || (home.containsKey(homeId))) {
                        away.put(homeId, oneFixture);
                    } else {
                        home.put(homeId, oneFixture);
                    }

                } else {
                    CupFixtureWithResultDTO firstObjekat;
//                    CupFixtureWithResultDTO secondObjekat;
                    HashMap<Integer, HashMap<Integer, CupFixtureWithResultDTO>> full = new HashMap<>();
                    full.put(1, home);

                    if ((home.size() != away.size()) && away.size() != 0) {
                        HashMap<Integer, CupFixtureWithResultDTO> listOfFixtures = new HashMap<>();

                        for (CupFixtureWithResultDTO key : away.values()) {
                            int homeIdFromObject = Integer.parseInt(key.getLinkFixtureWithIdHomeAndAwayDTO().getHomeTeam().getLink());
                            int awayIdFromObject = Integer.parseInt(key.getLinkFixtureWithIdHomeAndAwayDTO().getAwayTeam().getLink());
                            firstObjekat = home.get(homeIdFromObject) != null ? home.get(homeIdFromObject) : home.get(awayIdFromObject);
                            listOfFixtures.put(homeIdFromObject, firstObjekat);
                            listOfFixtures.put(awayIdFromObject, key);
//                            full.put(homeIdFromObject, listOfFixtures);

                        }
                        full.put(3, listOfFixtures);

                    } else if ((home.size() == away.size())) {
                        full.put(2, away);
                    }
                    allMap.put(matchday, full);
                    i = j - 1;
                    break;
                }
            }
        }
        this.fixtures = allMap;
    }

}
