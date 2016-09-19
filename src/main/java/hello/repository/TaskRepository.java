package hello.repository;

import hello.model.persistence.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by техносила on 20.08.2016.
 */
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Integer> {

    @Query("FROM Task where isRequest=?1")
    List<Task> findByType(boolean isRequest);
}
