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

    public Author(){}

    public Author(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
