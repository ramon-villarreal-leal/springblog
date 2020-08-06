package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


//Post is the reference type of the entity to CRUD
// Long is the reference type for the primary key of Post

public interface PostRepository extends JpaRepository<Post, Long> {

    // Derived queries using the JPA builder
//    Post findByTitle(String title);
//    Post findFirstByOrderByTitleAsc();

    //custom example using the query Annotation
    //examples from using JPHQ / HQL

//    @Query("from Post p where id like ?1")
//    Post getPostById(long id);
//
//    @Query("DELETE FROM Post where p.id=:id")
//    void deletePostById(@Param("id") long id);









}
