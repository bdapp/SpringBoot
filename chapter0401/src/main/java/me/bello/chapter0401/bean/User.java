package me.bello.chapter0401.bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id; //主键
    private String username;
    private String loginName;
    private char sex;
    private int age;

    public User() {
    }

    public User(String username, String loginName, char sex, int age) {
        this.username = username;
        this.loginName = loginName;
        this.sex = sex;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
