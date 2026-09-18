package gustus.roadmap.tasktracker.Service;

import gustus.roadmap.tasktracker.Entity.AppTask;
import gustus.roadmap.tasktracker.Repository.AppTaskRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static gustus.roadmap.tasktracker.Enum.AppTaskStatus.*;

@Service
@RequiredArgsConstructor
public class AppTaskService {
    private final AppTaskRepository repository;

    public void createTask(String desc) {
        AppTask task = AppTask.builder()
                .status(TODO)
                .description(desc)
                .build();
        repository.save(task);
        System.out.println("Task Created: " + desc);
    }

    public void updateTask(Long id, String desc) {
        AppTask task = repository.findById(id).orElseThrow();
        task.setDescription(desc);
        repository.save(task);
        System.out.println("Task Updated: " + desc);
    }

    public void markInProgress(Long id) {
        AppTask task = repository.findById(id).orElseThrow();
        task.setStatus(IN_PROGRESS);
        repository.save(task);
    }

    public void markDone(Long id) {
        AppTask task = repository.findById(id).orElseThrow();
        task.setStatus(DONE);
        repository.save(task);
    }

    public List<AppTask> listTodo() {
        return repository.findAllByStatusContaining(TODO);
    }

    public List<AppTask> listInProgress() {
        return repository.findAllByStatusContaining(IN_PROGRESS);
    }

    public List<AppTask> listDone() {
        return repository.findAllByStatusContaining(DONE);
    }

    public void deleteTask(Long id) {
        AppTask task = repository.findById(id).orElseThrow();
        repository.delete(task);
    }
}
