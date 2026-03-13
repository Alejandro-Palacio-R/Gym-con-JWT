package com.gym.db.members;

import com.gym.db.members.dto.MemberRequest;
import com.gym.db.members.dto.MemberResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @GetMapping
    public List<MemberResponse> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MemberResponse get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public MemberResponse create(@Valid @RequestBody MemberRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public MemberResponse update(@PathVariable Long id, @Valid @RequestBody MemberRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
