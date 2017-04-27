package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
