package com.stackroute.repository;

import com.stackroute.domain.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* Add annotation to declare this class as a Repository class.
This interface should extend CRUD Repository
* */
@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer> {
}
