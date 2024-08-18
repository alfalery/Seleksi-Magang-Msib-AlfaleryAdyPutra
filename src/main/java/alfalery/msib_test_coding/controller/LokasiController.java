package alfalery.msib_test_coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import alfalery.msib_test_coding.model.LokasiResponse;
import alfalery.msib_test_coding.model.CreateLokasiRequest;
import alfalery.msib_test_coding.model.UpdateLokasiRequest;
import alfalery.msib_test_coding.service.LokasiService;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping(
        path = "/",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@RequestBody CreateLokasiRequest request) {
    try {
        LokasiResponse response = lokasiService.create(request);
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        // Log the exception
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating location: " + e.getMessage());
    }
}


    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public LokasiResponse get(@PathVariable("id") Long id) {
        return lokasiService.get(id);
    }

    @PutMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public LokasiResponse update(@RequestBody UpdateLokasiRequest request,
                                 @PathVariable("id") Long id) {
        request.setId(id);
        return lokasiService.update(request);
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String remove(@PathVariable("id") Long id) {
        lokasiService.remove(id);
        return "OK";
    }

    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<LokasiResponse> list() {
        return lokasiService.list();
    }
}
