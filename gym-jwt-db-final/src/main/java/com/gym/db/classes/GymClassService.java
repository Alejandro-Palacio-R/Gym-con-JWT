package com.gym.db.classes;

import com.gym.db.classes.dto.GymClassRequest;
import com.gym.db.classes.dto.GymClassResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymClassService {

    private final GymClassRepository repo;

    public GymClassService(GymClassRepository repo) {
        this.repo = repo;
    }

    public List<GymClassResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public GymClassResponse findById(Long id) {
        GymClass c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
        return toResponse(c);
    }

    public GymClassResponse create(GymClassRequest req) {
        GymClass c = new GymClass(null, req.getName(), req.getCoach(), req.getStartTime(), req.getCapacity());
        return toResponse(repo.save(c));
    }

    public GymClassResponse update(Long id, GymClassRequest req) {
        GymClass c = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Clase no encontrada"));
        c.setName(req.getName());
        c.setCoach(req.getCoach());
        c.setStartTime(req.getStartTime());
        c.setCapacity(req.getCapacity());
        return toResponse(repo.save(c));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Clase no encontrada");
        }
        repo.deleteById(id);
    }

    private GymClassResponse toResponse(GymClass c) {
        return new GymClassResponse(c.getId(), c.getName(), c.getCoach(), c.getStartTime(), c.getCapacity());
    }
}
