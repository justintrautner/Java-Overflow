package com.justin.overflow.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.overflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

	Optional<Tag> findBySubject(String subject);

}
