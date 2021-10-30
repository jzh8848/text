package JavaBean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private long Id;
    private String UserName;
    private String Password;
    private boolean Sex;
    private int Age;
    private double height;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean sex) {
        Sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
