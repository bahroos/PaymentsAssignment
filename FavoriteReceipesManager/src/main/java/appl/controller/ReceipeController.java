package appl.controller;

import appl.exception.ReceipeNotFoundException;
import appl.model.Receipe;
import appl.model.ReceipeRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ReceipeController {

    private final ReceipeRepository repository;

    ReceipeController(ReceipeRepository repository) {
        this.repository = repository;
    }
    /**
     * GET  /healthcheck : Test endpoint.
     */
    @ApiOperation(value = "API healthcheck", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "API is up and running", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })
    @GetMapping(name = "/healthcheck", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Hi!!! My healthcheck works.", HttpStatus.OK);
    }

    @ApiOperation(value = "API For all receipes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(value = "/receipes", consumes = "application/json", produces = "application/json")
    public List<Receipe> all() {
        return (List<Receipe>) repository.findAll();
    }

    @ApiOperation(value = "API for creating a new receipe", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "API is up and running", response = String.class),
            @ApiResponse(code = 500, message = "Internal Server Error"),
    })

    @PostMapping(value = "/receipes", consumes = "application/json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Receipe newReceipe(@RequestBody Receipe newReceipe) {
        return repository.save(newReceipe);
    }

    @ApiOperation(value = "Update an receipe")
    @PutMapping(value="/receipes/{id}", consumes = "application/json", produces = "application/json" )
    public ResponseEntity < Receipe > updateReceipe(
            @ApiParam(value = "Receipe Id to update receipe object", required = true) @PathVariable(value = "id") Long receipeId,
            @ApiParam(value = "Update receipe object", required = true) @Valid @RequestBody Receipe newReceipe) throws ReceipeNotFoundException {
        Receipe receipe = repository.findById(receipeId)
                .orElseThrow(() -> new ReceipeNotFoundException(receipeId));
        receipe.setCookingInstructions(newReceipe.getCookingInstructions());
        receipe.setIngredients(newReceipe.getIngredients());
        receipe.setOptimalNoOfPeople(newReceipe.getOptimalNoOfPeople());
        receipe.setVegetarian(newReceipe.isVegetarian());

        // dateTime and Id should never change.

        final Receipe updatedReceipe = repository.save(receipe);
        return ResponseEntity.ok(updatedReceipe);
    }


    @ApiOperation(value = "Get an receipe by Receipe id")
    @GetMapping(value="/receipes/{id}",  consumes = "application/json", produces = "application/json")
    public ResponseEntity < Receipe > getReceipeById(
            @ApiParam(value = "Receipe id for which the receipe details are to be sent", required = true) @PathVariable(value = "id") Long receipeId)
            throws ReceipeNotFoundException {
        Receipe receipe = repository.findById(receipeId)
                .orElseThrow(() -> new ReceipeNotFoundException(receipeId));
        return ResponseEntity.ok().body(receipe);
    }

    @ApiOperation(value = "Delete an receipe")
    @DeleteMapping(value="/receipes/{id}", consumes = "application/json" , produces = "application/json")
    public Map < Integer, Boolean > deleteReceipe(
            @ApiParam(value = "Receipe Id from which object will delete from database table", required = true) @PathVariable(value = "id") Long receipeId)
            throws ReceipeNotFoundException {
        repository.findById(receipeId)
                .orElseThrow(() -> new ReceipeNotFoundException(receipeId));
        //Since it is found, we can delete it.
        repository.deleteById(receipeId);
        Map<Integer, Boolean> response = new HashMap<>();
        response.put(receipeId.intValue(), Boolean.TRUE);
        return response;
    }
}
