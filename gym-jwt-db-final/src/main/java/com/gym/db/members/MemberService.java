package com.gym.db.members;

import com.gym.db.members.dto.MemberRequest;
import com.gym.db.members.dto.MemberResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repo;

    public MemberService(MemberRepository repo) {
        this.repo = repo;
    }

    public List<MemberResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    public MemberResponse findById(Long id) {
        Member m = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Member no encontrado"));
        return toResponse(m);
    }

    public MemberResponse create(MemberRequest req) {
        Member m = new Member(null, req.getFullName(), req.getMembershipType(), req.isActive());
        return toResponse(repo.save(m));
    }

    public MemberResponse update(Long id, MemberRequest req) {
        Member m = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Member no encontrado"));
        m.setFullName(req.getFullName());
        m.setMembershipType(req.getMembershipType());
        m.setActive(req.isActive());
        return toResponse(repo.save(m));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Member no encontrado");
        }
        repo.deleteById(id);
    }

    private MemberResponse toResponse(Member m) {
        return new MemberResponse(m.getId(), m.getFullName(), m.getMembershipType(), m.isActive());
    }
}
