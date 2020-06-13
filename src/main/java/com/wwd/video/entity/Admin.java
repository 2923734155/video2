package com.wwd.video.entity;

public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Integer roles;
    private String imgPath;

    public Admin() {
    }

    public Admin(Integer id, String username, String password, int roles, String imgPath) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}