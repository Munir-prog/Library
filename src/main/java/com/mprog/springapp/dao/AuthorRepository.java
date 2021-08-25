package com.mprog.springapp.dao;

import com.mprog.springapp.model.Author;
import com.mprog.springapp.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "select * from author where user_id = ?1",
            countQuery = "SELECT count(*) FROM author WHERE user_id = ?1",
        nativeQuery = true)
    Page<Author> findByUserId(Long userId, Pageable pageable);

}
