package appl.controller;

import appl.model.Receipe;
import appl.model.ReceipeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void givenReceipes_whenGetReceipes_thenReturnCollection() throws Exception {
        Receipe receipe1 = new Receipe();
        receipe1.setTitle("NewTitle1");
        receipe1.setCookingInstructions("CookingInstructions1");
        receipe1.setIngredients("Ingredients1");
        receipe1.setOptimalNoOfPeople(1);
        receipe1.setVegetarian(true);
        receipe1.setDateTime("14‐11‐1977 09:01");
        receipeRepository.save(receipe1);

        Receipe receipe2 = new Receipe();
        receipe2.setTitle("NewTitle2");
        receipe2.setCookingInstructions("CookingInstructions2");
        receipe2.setIngredients("Ingredients2");
        receipe2.setOptimalNoOfPeople(2);
        receipe2.setVegetarian(true);
        receipe2.setDateTime("14‐11‐1977 09:02");
        receipeRepository.save(receipe2);

        mvc.perform(MockMvcRequestBuilders.get("/receipes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Is.is(receipe1.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cookingInstructions", Is.is(receipe1.getCookingInstructions())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ingredients", Is.is(receipe1.getIngredients())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].optimalNoOfPeople", Is.is(receipe1.getOptimalNoOfPeople())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].vegetarian", Is.is(receipe1.isVegetarian())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].title", Is.is(receipe2.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].cookingInstructions", Is.is(receipe2.getCookingInstructions())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ingredients", Is.is(receipe2.getIngredients())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].optimalNoOfPeople", Is.is(receipe2.getOptimalNoOfPeople())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].vegetarian", Is.is(receipe2.isVegetarian())));
    }

    @Test
    public void givenReceipes_whenGetOneReceipes_thenReturnJsonSingelton() throws Exception {
        Receipe receipe1 = new Receipe();
        receipe1.setTitle("NewTitle1");
        receipe1.setCookingInstructions("CookingInstructions1");
        receipe1.setIngredients("Ingredients1");
        receipe1.setOptimalNoOfPeople(1);
        receipe1.setVegetarian(true);
        receipe1.setDateTime("d14‐11‐1977 09:01");
        receipeRepository.save(receipe1);

        Receipe receipe2 = new Receipe();
        receipe2.setTitle("NewTitle2");
        receipe2.setCookingInstructions("CookingInstructions2");
        receipe2.setIngredients("Ingredients2");
        receipe2.setOptimalNoOfPeople(2);
        receipe2.setVegetarian(true);
        receipe2.setDateTime("d14‐11‐1977 09:02");
        receipeRepository.save(receipe2);

        mvc.perform(MockMvcRequestBuilders.get("/receipes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is(receipe1.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cookingInstructions", Is.is(receipe1.getCookingInstructions())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingredients", Is.is(receipe1.getIngredients())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.optimalNoOfPeople", Is.is(receipe1.getOptimalNoOfPeople())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vegetarian", Is.is(receipe1.isVegetarian())));
    }

    @Test
    public void givenReceipes_whenCreateOneReceipe_thenIsSuccesslCreated() throws Exception {
        Receipe receipe1 = new Receipe();
        receipe1.setTitle("NewTitle1");
        receipe1.setCookingInstructions("CookingInstructions1");
        receipe1.setIngredients("Ingredients1");
        receipe1.setOptimalNoOfPeople(1);
        receipe1.setVegetarian(true);
        receipe1.setDateTime("d14‐11‐1977 09:01");

        mvc.perform(MockMvcRequestBuilders.post("/receipes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(receipe1))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Is.is(receipe1.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.cookingInstructions", Is.is(receipe1.getCookingInstructions())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ingredients", Is.is(receipe1.getIngredients())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.optimalNoOfPeople", Is.is(receipe1.getOptimalNoOfPeople())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vegetarian", Is.is(receipe1.isVegetarian())));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}