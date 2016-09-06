package project.football.web.dto.json.leagueTableGroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupS {

    @JsonProperty(value = "A")
    private List<LeagueTableGroupDTO> groupA;

    @JsonProperty(value = "B")
    private List<LeagueTableGroupDTO> groupB;

    @JsonProperty(value = "C")
    private List<LeagueTableGroupDTO> groupC;

    @JsonProperty(value = "D")
    private List<LeagueTableGroupDTO> groupD;

    @JsonProperty(value = "E")
    private List<LeagueTableGroupDTO> groupE;

    @JsonProperty(value = "F")
    private List<LeagueTableGroupDTO> groupF;

    @JsonProperty(value = "G")
    private List<LeagueTableGroupDTO> groupG;

    @JsonProperty(value = "H")
    private List<LeagueTableGroupDTO> groupH;

    @JsonProperty(value = "I")
    private List<LeagueTableGroupDTO> groupI;

    @JsonProperty(value = "J")
    private List<LeagueTableGroupDTO> groupJ;

    @JsonProperty(value = "K")
    private List<LeagueTableGroupDTO> groupK;

    @JsonProperty(value = "L")
    private List<LeagueTableGroupDTO> groupL;

    public List<LeagueTableGroupDTO> getGroupA() {
        return groupA;
    }

    public void setGroupA(List<LeagueTableGroupDTO> groupA) {
        this.groupA = groupA;
    }

    public List<LeagueTableGroupDTO> getGroupB() {
        return groupB;
    }

    public void setGroupB(List<LeagueTableGroupDTO> groupB) {
        this.groupB = groupB;
    }

    public List<LeagueTableGroupDTO> getGroupC() {
        return groupC;
    }

    public void setGroupC(List<LeagueTableGroupDTO> groupC) {
        this.groupC = groupC;
    }

    public List<LeagueTableGroupDTO> getGroupD() {
        return groupD;
    }

    public void setGroupD(List<LeagueTableGroupDTO> groupD) {
        this.groupD = groupD;
    }

    public List<LeagueTableGroupDTO> getGroupE() {
        return groupE;
    }

    public void setGroupE(List<LeagueTableGroupDTO> groupE) {
        this.groupE = groupE;
    }

    public List<LeagueTableGroupDTO> getGroupF() {
        return groupF;
    }

    public void setGroupF(List<LeagueTableGroupDTO> groupF) {
        this.groupF = groupF;
    }

    public List<LeagueTableGroupDTO> getGroupG() {
        return groupG;
    }

    public void setGroupG(List<LeagueTableGroupDTO> groupG) {
        this.groupG = groupG;
    }

    public List<LeagueTableGroupDTO> getGroupH() {
        return groupH;
    }

    public void setGroupH(List<LeagueTableGroupDTO> groupH) {
        this.groupH = groupH;
    }

    public List<LeagueTableGroupDTO> getGroupI() {
        return groupI;
    }

    public void setGroupI(List<LeagueTableGroupDTO> groupI) {
        this.groupI = groupI;
    }

    public List<LeagueTableGroupDTO> getGroupJ() {
        return groupJ;
    }

    public void setGroupJ(List<LeagueTableGroupDTO> groupJ) {
        this.groupJ = groupJ;
    }

    public List<LeagueTableGroupDTO> getGroupK() {
        return groupK;
    }

    public void setGroupK(List<LeagueTableGroupDTO> groupK) {
        this.groupK = groupK;
    }

    public List<LeagueTableGroupDTO> getGroupL() {
        return groupL;
    }

    public void setGroupL(List<LeagueTableGroupDTO> groupL) {
        this.groupL = groupL;
    }
}
