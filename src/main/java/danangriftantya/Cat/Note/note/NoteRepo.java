package danangriftantya.Cat.Note.note;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {
    Optional<Note> findByTitle(String title);
}
