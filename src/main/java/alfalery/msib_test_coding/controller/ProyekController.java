package alfalery.msib_test_coding.controller;

import alfalery.msib_test_coding.model.CreateProyekRequest;
import alfalery.msib_test_coding.model.UpdateProyekRequest;
import alfalery.msib_test_coding.model.ProyekResponse;
import alfalery.msib_test_coding.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping(
        path = "/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@RequestBody CreateProyekRequest request) {
        try {
            ProyekResponse response = proyekService.create(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating project: " + e.getMessage());
        }
    }

    @GetMapping(
        path = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        try {
            ProyekResponse response = proyekService.get(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project with ID " + id + " not found");
        }
    }

    @PutMapping(
        path = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> update(@RequestBody UpdateProyekRequest request, @PathVariable("id") Long id) {
        try {
            request.setId(id);
            ProyekResponse response = proyekService.update(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating project: " + e.getMessage());
        }
    }

    @DeleteMapping(
        path = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> remove(@PathVariable("id") Long id) {
        try {
            proyekService.remove(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project with ID " + id + " not found");
        }
    }

    @GetMapping(
        path = "/",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ProyekResponse>> list() {
        List<ProyekResponse> responseList = proyekService.list();
        return ResponseEntity.ok(responseList);
    }
}
