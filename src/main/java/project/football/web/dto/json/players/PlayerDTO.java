package project.football.web.dto.json.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Calendar;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {


    static {

        Calendar now = Calendar.getInstance();
        year = now.get(Calendar.YEAR);
        month = now.get(Calendar.MONTH)+1;
        day = now.get(Calendar.DAY_OF_MONTH);
    }


    int Back(char charB){
        if (charB == 'L'){
            return 2;
        }
        else if (charB == 'C'){
            return 3;
        }
        else {
            return 4;
        }

    }

    int Midfield (char charM){

        if (charM == 'D'){
            return 5;
        }
        else if (charM == 'C'){
            return 6;
        }
        else {
            return 7;
        }
    }

    int Forward (char charF){
        if (charF == 'L'){
            return 8;
        }
        else if (charF == 'R'){
            return 9;
        }
        else if (charF == 'S'){
            return 10;
        }
        else {
            return 11;
        }
    }

    private static int year;

    private static int month;

    private static int day;

    private String name;

    private String position;

    private int jerseyNumber;

    private String dateOfBirth;

    private String nationality;

    private String contractUntil;

    private String marketValue;

    private int sortingByPosition;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        int indeX = name.indexOf('\n');
        this.name = name.substring(0,indeX);
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
        this.marketValue = marketValue;
    }

    public int getSortingByPosition() {

        String positionString = this.position;
        positionString = positionString.replace("-"," ");
        int indexX = positionString.indexOf(" ");
        char secondPartOfString = positionString.charAt(indexX+1);

        if (positionString.length() < 7){
            return 1;
        }
        else if (secondPartOfString == 'B'){
             return Back(positionString.charAt(0));
        }
        else if (secondPartOfString == 'M'){
            return Midfield(positionString.charAt(0));
        }else {
            return Forward(positionString.charAt(0));
        }

    }

    public void setSortingByPosition(int sortingByPosition) {
        this.sortingByPosition = sortingByPosition;
    }

    public int getAge() {

        int ageOfPlayer = year - (Integer.parseInt(this.dateOfBirth.substring(0,4)));
        int monthOfPlayersBirth = Integer.parseInt(this.dateOfBirth.substring(5,7));
        int dayOfPlayersBirth = Integer.parseInt(this.dateOfBirth.substring(8,10));

        if (month > monthOfPlayersBirth){
            return ageOfPlayer;
        }
        else if(month == monthOfPlayersBirth && day >= dayOfPlayersBirth) {
            return ageOfPlayer;
        }else {
            return (--ageOfPlayer);
        }

    }

    public void setAge(int age) {
        this.age = age;
    }
}
