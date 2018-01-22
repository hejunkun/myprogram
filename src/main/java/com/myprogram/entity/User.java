package com.myprogram.entity;

import javax.persistence.*;

/**
 * Created by hjk on 2017/11/8.
 */
@Entity
@Table(name = "tb_user")
public class User {
    public int uno;
    private String uname;//用户
    private String upwd;//用户密码

    public User() {
    }

    public User(int uno, String uname, String upwd) {
        this.uno = uno;
        this.uname = uname;
        this.upwd = upwd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
