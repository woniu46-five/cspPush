package com.project.bean;

import org.springframework.stereotype.Component;

public class User {
    private Integer id;

    private String name;

    private String pass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
    
}