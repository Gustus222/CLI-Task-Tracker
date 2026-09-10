package gustus.roadmap.tasktracker.Repository;

import gustus.roadmap.tasktracker.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
