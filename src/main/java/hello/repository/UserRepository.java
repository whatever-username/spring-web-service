package hello.repository;

import hello.model.persistence.Task;
import hello.model.persistence.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by техносила on 20.08.2016.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

}
