package com.gym.db.classes;

import com.gym.db.classes.dto.GymClassRequest;
import com.gym.db.classes.dto.GymClassResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class GymClassController {

    private final GymClassService service;

    public GymClassController(GymClassService service) {
        this.service = service;
    }

    @GetMapping
    public List<GymClassResponse> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public GymClassResponse get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public GymClassResponse create(@Valid @RequestBody GymClassRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public GymClassResponse update(@PathVariable Long id, @Valid @RequestBody GymClassRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
