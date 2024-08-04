package com.microservice_user.persistence;

import com.microservice_user.entity.SecurityQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion, Integer> {
    @Query("SELECT sq FROM SecurityQuestion sq WHERE sq.user.userId = :userId")
    List<SecurityQuestion> findByUserId(@Param("userId") Integer userId);
}
