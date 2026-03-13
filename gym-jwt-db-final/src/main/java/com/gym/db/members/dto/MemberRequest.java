package com.gym.db.members.dto;

import jakarta.validation.constraints.NotBlank;

public class MemberRequest {
    @NotBlank
    private String fullName;

    @NotBlank
    private String membershipType;

    private boolean active = true;

    public MemberRequest() {}

    public MemberRequest(String fullName, String membershipType, boolean active) {
        this.fullName = fullName;
        this.membershipType = membershipType;
        this.active = active;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
