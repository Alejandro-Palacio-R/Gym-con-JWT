package com.gym.db.classes.dto;

import java.time.LocalDateTime;

public class GymClassResponse {
    private Long id;
    private String name;
    private String coach;
    private LocalDateTime startTime;
    private int capacity;

    public GymClassResponse() {}

    public GymClassResponse(Long id, String name, String coach, LocalDateTime startTime, int capacity) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.startTime = startTime;
        this.capacity = capacity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
