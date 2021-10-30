package DAO.imlp;

import DAO.IUserDao;
import JavaBean.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Util.JPAUtil;

import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public void save(User s) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(s);
        manager.getTransaction().commit();
        manager.close();

    }

    @Override
    public void update(User s) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(Long Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        User s = manager.find(User.class, Id);
        manager.remove(s);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public User getOne(Long Id) {
        EntityManager manager = JPAUtil.getEntityManager();
        User s = manager.find(User.class, Id);
        return s;
    }

    @Override
    public List<User> getAll() {
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select u from User u";
        Query query = manager.createQuery(sql);
        List list = query.getResultList();
        manager.close();
        return list;
    }

    public boolean login(String username,String password){
        EntityManager manager = JPAUtil.getEntityManager();
        String sql = "select u from User u where u.UserName=:username and User.Password=:password";
        Query query = manager.createQuery(sql);
        query.setParameter("username",username);
        query.setParameter("password",password);
        List list = query.getResultList();
        manager.close();
        return list.size()>=1;
    }
}
