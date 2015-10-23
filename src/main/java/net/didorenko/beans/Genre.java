package net.didorenko.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * package: net.didorenko
 * project: Library_JSF
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 23.10.2015
 */

@SessionScoped
@ManagedBean(name = "genre")
public class Genre {

    private String name;
    private long id;

    public Genre() {
    }

    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
