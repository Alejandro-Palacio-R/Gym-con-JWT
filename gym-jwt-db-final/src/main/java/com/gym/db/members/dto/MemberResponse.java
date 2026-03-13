package com.gym.db.members.dto;

public class MemberResponse {
    private Long id;
    private String fullName;
    private String membershipType;
    private boolean active;

    public MemberResponse() {}

    public MemberResponse(Long id, String fullName, String membershipType, boolean active) {
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
