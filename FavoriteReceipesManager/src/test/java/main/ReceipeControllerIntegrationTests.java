package main;

import appl.ReceipeApplication;
import appl.model.Receipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReceipeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ReceipeControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testHealthCheck() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/healthcheck",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetAllReceipes() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/receipes",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetReceipeById() {
        Receipe Receipe = restTemplate.getForObject(getRootUrl() + "/receipes/1", Receipe.class);
        System.out.println(((Receipe) Receipe).getId());
        assertNotNull(Receipe);
    }

    @Test
    public void testCreateReceipe() {
        Receipe Receipe = new Receipe();
        Receipe.setIngredients("Ingridents");
        Receipe.setCookingInstructions("Instructions");
        Receipe.setTitle("Test");
        ResponseEntity<Receipe> postResponse = restTemplate.postForEntity(getRootUrl() + "/receipes", Receipe, Receipe.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateReceipe() {
        int id = 1;
        Receipe Receipe = restTemplate.getForObject(getRootUrl() + "/receipes/" + id, Receipe.class);
        Receipe.setCookingInstructions("Changes");
        restTemplate.put(getRootUrl() + "/Receipes/" + id, Receipe);
        Receipe updatedReceipe = restTemplate.getForObject(getRootUrl() + "/Receipes/" + id, Receipe.class);
        assertNotNull(updatedReceipe);
    }

    @Test
    public void testDeleteReceipe() {
        int id = 2;
        Receipe Receipe = restTemplate.getForObject(getRootUrl() + "/Receipes/" + id, Receipe.class);
        assertNotNull(Receipe);
        restTemplate.delete(getRootUrl() + "/receipes/" + id);
        try {
            Receipe = restTemplate.getForObject(getRootUrl() + "/Receipes/" + id, Receipe.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}