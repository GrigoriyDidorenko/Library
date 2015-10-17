package net.didorenko.beans;

/**
 * package: net.didorenko.beans
 * project: Library
 * class: Author
 *
 * @author: Grigoriy Didorenko
 * @date: 15.10.2015
 */
public class Author {

    private String name;
    private long id;

    public Author() {
    }

    public Author(long id, String name) {
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
