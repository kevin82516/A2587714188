package com.example.demo.models;

import com.example.demo.models.AppUsers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.servlet.ModelAndView;

public interface AppUserRepo extends CrudRepository<AppUsers,Integer> {


}
