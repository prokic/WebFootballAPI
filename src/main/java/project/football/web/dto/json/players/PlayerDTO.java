package project.football.web.dto.json.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.springframework.util.StringUtils;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {


    static {
        localDate = new LocalDate();
    }

    private static LocalDate localDate;

    private String name;

    private String position;

    private int jerseyNumber;

    private String dateOfBirth;

    private String nationality;

    private String contractUntil;

    private String marketValue;

    private int sortingByPosition;

    private int age;

    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int indeX = name.indexOf('\n');
        this.name = indeX == -1 ? name : name.substring(0,indeX);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(String contractUntil) {
        this.contractUntil = contractUntil;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        if (StringUtils.isEmpty(marketValue)){
            this.marketValue = "No market value";
        }
        else {
            this.marketValue = marketValue;
        }
    }

    public int getSortingByPosition() {

        int sort;

        switch (this.position){
            case "Keeper" : sort = 1;
                break;
            case "Centre Back" : sort = 2;
                break;
            case "Left-Back" : sort = 3;
                break;
            case "Right-Back" : sort = 4;
                break;
            case "Defensive Midfield" : sort = 5;
                break;
            case "Central Midfield" : sort = 6;
                break;
            case "Attacking Midfield" : sort = 7;
                break;
            case "Left Wing" : sort = 8;
                break;
            case "Right Wing" : sort = 9;
                break;
            case "Secondary Striker" : sort = 10;
                break;
            default : sort = 11;
                break;
        }

        return sort;
    }

    public void setSortingByPosition(int sortingByPosition) {
        this.sortingByPosition = sortingByPosition;
    }

    public int getAge() {

        LocalDate localDateFromDateOfBirth = new LocalDate(this.dateOfBirth);
        return Years.yearsBetween(localDateFromDateOfBirth,localDate).getYears();

    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getValue() {
        if (this.marketValue != "No market value"){
            String pomocna = this.marketValue;
            String str = pomocna.replaceAll(",", "").trim();
            int index = str.indexOf(" ");
            return Integer.parseInt(str.substring(0,index));
        }
        else {
            return 0;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }
}
