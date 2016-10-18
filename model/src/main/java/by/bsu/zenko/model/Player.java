package by.bsu.zenko.model;


import javax.persistence.*;

/**
 * Created by 123 on 14.10.2016.
 */
@Entity
@Table(name = "Players")
public class Player {
    private int playerId;
    private String name;
    private Club club;

    @Id
    @Column(name = "ID_PLAYER", nullable = false, unique = true)
    @SequenceGenerator(name= "seq",sequenceName = "PLAYER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Column(name = "name", length = 40, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToOne
    @JoinColumn(name = "ID_CLUB")
    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
