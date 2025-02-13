package danangriftantya.Cat.Note.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends JpaRepository<Note, Long> {
}
