package by.bsu.zenko.dao;

import by.bsu.zenko.model.Club;

import java.util.List;

/**
 * Created by 123 on 14.10.2016.
 */
public interface ClubDAO {
    public int insert(Club club);
    public void delete(Club club);
    public void update(Club club);
    public Club getById(int id);
    public List<Club> getAll();
}
