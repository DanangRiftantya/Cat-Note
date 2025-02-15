package danangriftantya.Cat.Note.note;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoteController {
    private final NoteService noteService;
    private NoteRepo noteRepo;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @MessageMapping("/notes.getAllNotes")
    @SendTo("/topic/public")
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @MessageMapping("/notes.getNoteById")
    @SendTo("/topic/public")
    public Note getNoteById(long id) {
        return noteService.findById(id);
    }

    @MessageMapping("/notes.createNote")
    @SendTo("/topic/public")
    public Note createNote(Note note) {
        return noteRepo.save(note);
    }

    @MessageMapping("/notes.updateNote")
    @SendTo("/topic/public")
    public Note updateNote(long id, Note note) {
        Note updatedNote = noteService.findById(id);
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return noteRepo.save(updatedNote);
    }

    @MessageMapping("/notes.deleteNotes")
    @SendTo("/topic/deletedNotes")
    public void deleteNotes(Long id) {
        noteService.delete(id);
    }


}
