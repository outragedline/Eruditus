package com.eruditus.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.eruditus.api.model.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, String> {

	Iterable<Administrator> findByAdministrator(Administrator administrator);

	Administrator findById(long id);

	List<Administrator> findByName(String name);

	public void delete(Administrator student);

}
