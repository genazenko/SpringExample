package by.bsu.zenko.dao;

import by.bsu.zenko.model.Player;

import java.util.List;

/**
 * Created by 123 on 14.10.2016.
 */
public interface PlayerDAO {
    public int insert(Player player);
    public void delete(Player player);
    public void update(Player player);
    public Player getById(int id);
    public List<Player> getAll();
}
