package com.gaozhaoxi.entity;

import java.io.Serializable;

/**
 * @author Leon
 */
//1.属性为private，2有默认构造方法，3.有getter和sett方法，4.实现序列化接口
public class User implements Serializable{
    private String loginname;
    private String passwords;
    private String username;

    public User(){
        super();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
