package com.example.demo.articlemodels;

import com.example.demo.models.AppUsers;
import org.springframework.data.repository.CrudRepository;

public interface articleRepo extends CrudRepository<articledata,Integer> {
}