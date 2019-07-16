package com.umfg.mitsubishi.persistence.repo;

import com.umfg.mitsubishi.persistence.entity.Comment;
import com.umfg.mitsubishi.persistence.entity.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

    List<Comment> getAllByQualifierOrderByCreationDateDesc(Qualifier qualifier);

    @Query("SELECT COUNT(id) FROM Comment")
    long getTotalComments();
}