package com.eruditus.repositories;

import java.util.List;

public interface Repository<T, ID> {
	void save(T entity);

	T findById(ID id);

	List<T> findAll();

	void update(T entity);

	void delete(ID id);

}
