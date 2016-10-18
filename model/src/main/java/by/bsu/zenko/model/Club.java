package by.bsu.zenko.model;

import javax.persistence.*;

/**
 * Created by 123 on 14.10.2016.
 */
@Entity
@Table(name = "FootballClubs")
public class Club {
    @Id
    @Column(name = "ID_CLUB", nullable = false, unique = true)
    @SequenceGenerator(name= "seqClub",sequenceName = "CLUB_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqClub")
    private int clubId;
    @Column(name = "name",length = 40, nullable = false)
    private String name;
    @Column(name = "country", length = 40)
    private String country;

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
