package com.eruditus.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.eruditus.api.model.Student;
import com.eruditus.api.model.Administrator;

public interface StudentRepository extends CrudRepository<Student, String>{
    
  Iterable<Student>findByAdministrator(Administrator administrator);
   
  Administrator findById(long id);
   
  List<Student>findByName(String name);

   public void delete(Administrator student);
    
}
