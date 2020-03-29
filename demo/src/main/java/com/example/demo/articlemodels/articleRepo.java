package com.example.demo.articlemodels;

import org.springframework.data.repository.CrudRepository;

public interface articleRepo extends CrudRepository<articledata,Integer> {
}