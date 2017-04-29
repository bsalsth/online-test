package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
