package by.bsu.zenko.controller;

import by.bsu.zenko.dao.ClubDAO;
import by.bsu.zenko.dao.PlayerDAO;
import by.bsu.zenko.model.Club;
import by.bsu.zenko.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * Created by 123 on 14.10.2016.
 */
@RestController
public class Controller {
    @Autowired
    private PlayerDAO playerDAO;
    @Autowired
    private ClubDAO clubDAO;
    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable("id") int id){
        Player pl = playerDAO.getById(id);
        return pl;
    }
    @PostMapping("/players")
    public int setPlayer(@RequestBody Player player){
        if (player!=null){
            return playerDAO.insert(player);
        }
        return -1;
    }

    @GetMapping("/players")
    public List<Player> getPlayers(){
        return playerDAO.getAll();
    }

    @GetMapping("/clubs/{id}")
    public Club getClub(@PathVariable("id") int id){
        Club club = clubDAO.getById(id);
        return club;
    }
    @PostMapping("/clubs")
    public int setClub(@RequestBody Club club){
        if (club!=null){
            return clubDAO.insert(club);
        }
        return -1;
    }

    @GetMapping("/clubs")
    public List<Club> getClubs(){
        return clubDAO.getAll();
    }

}
