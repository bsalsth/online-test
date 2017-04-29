package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
