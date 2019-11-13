package appl.controller;

import appl.model.Receipe;
import appl.model.ReceipeRepository;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReceipeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReceipeRepository receipeRepository;

    @Test
    public void givenReceipes_whenGetReceipes_thenReturnJsonArray() throws Exception {
        Receipe receipe = new Receipe();
        receipe.setTitle("Test123");
        receipeRepository.save(receipe);
        System.out.println("Running test 1");
        mvc.perform(MockMvcRequestBuilders.get("/receipes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Is.is(receipe.getTitle())));
    }

}