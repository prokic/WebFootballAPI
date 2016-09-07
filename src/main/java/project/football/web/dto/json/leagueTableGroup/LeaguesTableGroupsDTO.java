package project.football.web.dto.json.leagueTableGroup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import project.football.web.dto.json.link.LinkSelfDTO;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaguesTableGroupsDTO {

    @JsonProperty(value = "leagueCaption")
    private String name;

    private int matchday;

    private ArrayList<List<LeagueTableGroupDTO>> standings;

    @JsonProperty(value = "_links")
    private LinkSelfDTO linkSelfDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchday() {
        return matchday;
    }

    public void setMatchday(int matchday) {
        this.matchday = matchday;
    }

    public ArrayList<List<LeagueTableGroupDTO>> getStandings() {
        return standings;
    }

    public void setStandings(GroupS standings) {

        Class c = standings.getClass();
        ArrayList<List<LeagueTableGroupDTO>> listOfListsOfObjects = new ArrayList<>();

        for (char i = 'A'; i <= 'L'; i++) {

            try {
                Method m = c.getMethod("getGroup"+i);
                List<LeagueTableGroupDTO> listOfGroupObjects = (List<LeagueTableGroupDTO>) m.invoke(standings);

                if (listOfGroupObjects != null){
                    listOfListsOfObjects.add(listOfGroupObjects);
                }
                else {
                    break;
                }

            } catch (NoSuchMethodException e) {
                System.out.println(e.toString());
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        this.standings = listOfListsOfObjects;
    }

    public LinkSelfDTO getLinkSelfDTO() {
        return linkSelfDTO;
    }

    public void setLinkSelfDTO(LinkSelfDTO linkSelfDTO) {
        this.linkSelfDTO = linkSelfDTO;
    }
}
