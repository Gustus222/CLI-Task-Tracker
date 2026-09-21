package gustus.roadmap.tasktracker.Repository;

import gustus.roadmap.tasktracker.Entity.AppTask;
import gustus.roadmap.tasktracker.Enum.AppTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppTaskRepository extends JpaRepository<AppTask, Long> {
    List<AppTask> findAllByStatusContaining(AppTaskStatus status);
}
