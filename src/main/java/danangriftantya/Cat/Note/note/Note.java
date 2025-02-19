package danangriftantya.Cat.Note.note;

import danangriftantya.Cat.Note.user.User;
import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private long id;

    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private Date lastUpdated;

}
