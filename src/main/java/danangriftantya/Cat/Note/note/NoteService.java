package danangriftantya.Cat.Note.note;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteRepo noteRepo;

    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    public Note findById(long id) {
        return noteRepo.findById(id).get();
    }

    public Note save(Note note) {
        return noteRepo.save(note);
    }

    public void delete(long id) {
        noteRepo.deleteById(id);
    }
}
