package com.gym.db.members;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String membershipType;

    private boolean active;

    public Member() {}

    public Member(Long id, String fullName, String membershipType, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.membershipType = membershipType;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
