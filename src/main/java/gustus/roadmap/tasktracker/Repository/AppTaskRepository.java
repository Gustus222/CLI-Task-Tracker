package gustus.roadmap.tasktracker.Repository;

import gustus.roadmap.tasktracker.Entity.AppTask;
import gustus.roadmap.tasktracker.Enum.AppTaskStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppTaskRepository extends CrudRepository<AppTask, Long> {
    List<AppTask> findAllByStatusContaining(AppTaskStatus status);
}
