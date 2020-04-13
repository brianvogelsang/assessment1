package com.assessment1.repo;

import java.util.Set;

public interface CrudRepository<T, I> {

  T save(T t);
  Set<T> findAll();
  T findById(I id);
  Boolean update(T t);
  T findByString(String s);
  Boolean deleteById(I id);

}
