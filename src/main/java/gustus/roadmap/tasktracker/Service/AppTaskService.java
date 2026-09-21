package gustus.roadmap.tasktracker.Service;

import gustus.roadmap.tasktracker.Entity.AppTask;
import gustus.roadmap.tasktracker.Repository.AppTaskRepository;
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
        System.out.println("Output: Task added successfully (ID: %s)".formatted(task.getId()));
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

    public String listTodo() {
        return repository.findAllByStatusContaining(TODO)
                .stream()
                .map(task -> "[%d] \"%s\"".formatted(task.getId(), task.getDescription()))
                .collect(Collectors.joining("\n"));
    }

    public String listInProgress() {
        return repository.findAllByStatusContaining(IN_PROGRESS)
                .stream()
                .map(task -> "[%d] \"%s\"".formatted(task.getId(), task.getDescription()))
                .collect(Collectors.joining("\n"));
    }

    public String listDone() {
        return repository.findAllByStatusContaining(DONE)
                .stream()
                .map(task -> "[%d] \"%s\"".formatted(task.getId(), task.getDescription()))
                .collect(Collectors.joining("\n"));
    }

    public String listAll() {
        return repository.findAll()
                .stream()
                .map(task -> "[%d] \"%s\" Status: %s".formatted(task.getId(), task.getDescription(), task.getStatus()))
                .collect(Collectors.joining("\n"));
    }

    public void deleteTask(Long id) {
        AppTask task = repository.findById(id).orElseThrow();
        repository.delete(task);
    }
}
