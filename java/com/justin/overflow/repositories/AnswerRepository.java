package com.justin.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.overflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer,Long>{

}
