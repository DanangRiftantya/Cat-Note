package danangriftantya.Cat.Note.testUser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import danangriftantya.Cat.Note.note.NoteController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(post("/user.register")
                        .param("username", "testuser")
                        .param("password", "testpassword")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("testuser"));
    }

    @Test
    public void testLogin() throws Exception {
        // First we have to register a test user
        mockMvc.perform(post("/user.register")
                .param("username", "testuser")
                .param("password", "testpassword")
        );

        // Then test the log in function
        mockMvc.perform(post("/user.login")
                .param("username", "testuser")
                .param("password", "testpassword"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
