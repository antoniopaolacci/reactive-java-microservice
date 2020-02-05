package com.quicktutorialz.nio.entities;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class ToDo {

    private String id;
    private String title;
    private String description;
    private LocalDate date;

    //empty constructor
    public ToDo() { }

    //pojo constructor
    public ToDo(String title, String description) {
        this.id = UUID.randomUUID().toString();          // a generated ID
        this.title = title;
        this.description = description;
        this.date = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        
    	if (this == o) return true;
        
    	if (!(o instanceof ToDo)) return false;
        
        ToDo toDo = (ToDo) o;
        
        return Objects.equals(getId(), toDo.getId()) &&
                Objects.equals(getTitle(), toDo.getTitle()) &&
                Objects.equals(getDescription(), toDo.getDescription()) &&
                Objects.equals(getDate(), toDo.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getDate());
    }
    
}
