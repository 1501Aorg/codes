package com.bwei.bean;

/**
 * Created by Administrator on 2017/3/24.
 */

public class UserBean {
    private String userName;
    private String passWord;

    public UserBean() {

    }

    public UserBean(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


}
