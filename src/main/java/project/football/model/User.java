package project.football.model;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    private String [] s;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String vrati (){
        StringBuilder p = new StringBuilder();
        for (String uzim : this.s) {
            p.append(uzim+",");
        }
        p.deleteCharAt(p.length()-1);
       return  p.toString();
    }

    @Override
    public String toString() {
        return "dsjdjsadasdas" +vrati();
    }
}
