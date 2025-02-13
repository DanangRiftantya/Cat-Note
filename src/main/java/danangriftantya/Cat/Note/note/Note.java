package danangriftantya.Cat.Note.note;

import danangriftantya.Cat.Note.user.User;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Note {

    private long id;
    private String title;
    private String content;
    private User author;
    private Date timestamp;

}
