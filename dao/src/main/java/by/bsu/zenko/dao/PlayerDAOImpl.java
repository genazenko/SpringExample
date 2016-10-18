package by.bsu.zenko.dao;

import by.bsu.zenko.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by 123 on 14.10.2016.
 */

public class PlayerDAOImpl implements PlayerDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public PlayerDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public int insert(Player player){
        Session session = sessionFactory.openSession();
        session.persist(player);
        session.flush();
        session.close();
        return player.getPlayerId();
    }
    @Transactional
    public void update(Player player){
        Session session = sessionFactory.openSession();
        session.update(player);
        session.close();
    }
    @Transactional
    public void delete(Player player){
        Session session = sessionFactory.openSession();
        session.delete(player);
        session.close();
    }
    @Transactional
    public Player getById(int id){
        Session session = sessionFactory.openSession();
        Player player = (Player)session.get(Player.class,id);
        session.close();
        return player;
    }
    public List<Player> getAll(){
        Session session = sessionFactory.openSession();
        List<Player> list = session.createCriteria(Player.class).list();
        session.close();
        return list;
    }
}
