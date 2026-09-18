package gustus.roadmap.tasktracker.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import gustus.roadmap.tasktracker.Enum.AppTaskStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AppTask {
    @GeneratedValue
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private AppTaskStatus status;

    private String description;

    @CreationTimestamp
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

}
