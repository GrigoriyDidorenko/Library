package net.didorenko.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * package: net.didorenko.beans
 * project: Library_JSF
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 23.10.2015
 */

@SessionScoped
@ManagedBean(name = "user")
public class User implements Serializable {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
