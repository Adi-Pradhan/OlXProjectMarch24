package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.bean.Category;

@Repository
public interface ICategoryRepo extends JpaRepository<Category, Integer>  {

}
