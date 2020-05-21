package com.example.appointment.entity;

public class UserBean {
    private String user_id;//用户ID
    private String user_account;//用户账户
    private String user_password;//用户密码
    private String user_name;//用户姓名
    private int user_age;//用户年龄
    private char user_sex;//用户性别
    private int user_position;//用户职位
    private int checked;//是否审核

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_age() {
        return user_age;
    }

    public void setUser_age(int user_age) {
        this.user_age = user_age;
    }

    public char getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(char user_sex) {
        this.user_sex = user_sex;
    }

    public int getUser_position() {
        return user_position;
    }

    public void setUser_position(int user_position) {
        this.user_position = user_position;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public UserBean(String user_id, String user_account, String user_password, String user_name, int user_age, char user_sex, int user_position, int checked) {
        this.user_id = user_id;
        this.user_account = user_account;
        this.user_password = user_password;
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_sex = user_sex;
        this.user_position = user_position;
        this.checked = checked;
    }

    public UserBean() {
    }
}
