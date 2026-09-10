package gustus.roadmap.tasktracker.Repository;

import gustus.roadmap.tasktracker.Entity.AppTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppTaskRepository extends CrudRepository<AppTask, Long> {
}
