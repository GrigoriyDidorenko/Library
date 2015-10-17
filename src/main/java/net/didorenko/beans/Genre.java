package net.didorenko.beans;

/**
 * package: net.didorenko.beans
 * project: Library
 * class:
 *
 * @author: Grigoriy Didorenko
 * @date: 15.10.2015
 */
public class Genre {

    private String name;
    private long id;

    public Genre() {
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
