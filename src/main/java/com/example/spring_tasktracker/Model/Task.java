package com.example.spring_tasktracker.Model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Task {

    private String id ,title, description, status;

}
