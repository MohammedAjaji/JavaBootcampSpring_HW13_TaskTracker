package com.example.spring_tasktracker.TaskController;

import com.example.spring_tasktracker.ApiResponse.ApiResponse;
import com.example.spring_tasktracker.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Task> getTask() {
        return tasks;
    }

    //creat
    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        tasks.add(task);
        return "Added!!";
    }

    //update
    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return new ApiResponse("Updated !!");
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "Deleted!!";
    }

    //Search
    @GetMapping("/search/{title}")
    public ArrayList<Task> searchTitle(@PathVariable String title) {
        ArrayList<Task> find = new ArrayList<>();
        for (Task a : tasks) {
            if (a.getTitle().equals(title)) {
                find.add(a);
            }
        }
        return find;
    }


}
