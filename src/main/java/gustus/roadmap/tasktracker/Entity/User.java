package gustus.roadmap.tasktracker.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @GeneratedValue
    @Id
    private Long id;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    @JsonManagedReference
    private List<AppTask> appTasks;
}
