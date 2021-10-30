import DAO.imlp.UserDao;
import JavaBean.User;
import org.junit.*;

import java.util.List;

public class UserDaoTest {
    UserDao udao = new UserDao();

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setId(1l);
        user.setPassword("12345");
        user.setAge(18);
        user.setSex(true);

        udao.save(user);
    }

    @Test
    public void textUpdateUser(){
        User us = new User();
        us.setId(1l);
        us.setUserName("小明");

        udao.update(us);
    }

    @Test
    public void testDeleteUser(){
        udao.delete(1l);
    }

    @Test
    public void testSelectOne(){
        User u = udao.getOne(1l);
        System.out.println(u.getUserName());
    }

    @Test
    public void textSelectAll(){
        List<User> list = udao.getAll();
        list.forEach(item->System.out.println(item.getUserName()));
    }

    @Test
    public void testLogin(){
        System.out.println(udao.login("小明","123456"));
    }
}
