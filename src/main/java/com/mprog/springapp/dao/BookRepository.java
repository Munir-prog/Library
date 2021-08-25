package com.mprog.springapp.dao;

import com.mprog.springapp.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book where user_id = ?1",
            countQuery = "SELECT count(*) FROM book WHERE user_id = ?1",
        nativeQuery = true)
    Page<Book> findByUserId(Long userId, Pageable pageable);

}
