package by.bsu.zenko.dao;

import by.bsu.zenko.model.Club;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by 123 on 14.10.2016.
 */
public class ClubDAOImpl implements ClubDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public ClubDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Transactional
    public int insert(Club club){
        Session session = sessionFactory.openSession();
        session.persist(club);
        session.flush();
        session.close();
        return club.getClubId();
    }
    @Transactional
    public void update(Club club){
        Session session = sessionFactory.openSession();
        session.update(club);
        session.close();
    }
    @Transactional
    public void delete(Club club){
        Session session = sessionFactory.openSession();
        session.delete(club);
        session.close();
    }
    @Transactional
    public Club getById(int id){
        Session session = sessionFactory.openSession();
        Club club = (Club) session.get(Club.class,id);
        session.close();
        return club;
    }
    @Transactional
    public List<Club> getAll(){
        Session session = sessionFactory.openSession();
        List<Club> list = session.createCriteria(Club.class).list();
        session.close();
        return list;
    }
}
