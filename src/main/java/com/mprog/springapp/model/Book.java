package com.mprog.springapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "publishing_name")
    private String publishingName;
    @Column(name = "page")
    private int page;
    @Column(name = "image")
    private String image;
    @Column(name = "quantity")
    private int quantity;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "book_author",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id"))
//    private List<Author> authorList;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genre genre;


    public Book() {
    }


//    public void addAuthorToBook(Author author){
//        if (authorList == null){
//            authorList = new ArrayList<>();
//        }
//        authorList.add(author);
//    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

//    public List<Author> getAuthorList() {
//        return authorList;
//    }
//
//    public void setAuthorList(List<Author> authorList) {
//        this.authorList = authorList;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", publishingName='" + publishingName + '\'' +
                ", page=" + page +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
