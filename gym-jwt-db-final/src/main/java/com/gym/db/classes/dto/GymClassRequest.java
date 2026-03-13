package com.gym.db.classes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class GymClassRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String coach;

    @NotNull
    private LocalDateTime startTime;

    private int capacity = 20;

    public GymClassRequest() {}

    public GymClassRequest(String name, String coach, LocalDateTime startTime, int capacity) {
        this.name = name;
        this.coach = coach;
        this.startTime = startTime;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
