package com.mprog.springapp.model;

import org.hibernate.boot.model.naming.ImplicitNameSource;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @Column(name = "image")
    private String image;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "book_author",
//    joinColumns = @JoinColumn(name = "author_id"),
//    inverseJoinColumns = @JoinColumn(name = "book_id"))
//    private List<Book> bookList;
//

    public Author() {
    }


//    public void addBookToAuthor(Book book){
//        if (bookList == null) {
//            bookList = new ArrayList<>();
//        }
//        bookList.add(book);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//
//    public List<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                '}';
    }
}

