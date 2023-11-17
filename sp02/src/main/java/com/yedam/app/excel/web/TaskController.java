package com.yedam.app.excel.web;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.yedam.app.excel.service.TaskRepository;
import com.yedam.app.excel.service.Task;

//...

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

 @Autowired
 TaskRepository tr;

 @PostMapping("/create")
 @JsonSerialize(using = LocalDateTimeSerializer.class)
 @Transactional
 Task createTask(@RequestBody TaskCreateParams params) {

     Integer max = tr.findMaxOrdinal();

     if (max == null) {
         max = 1;
     }
     else {
         max += 1;
     }

     Task e = new Task();
     e.setStart(params.start);
     e.setEnd(params.end);
     e.setText(params.text);
     e.setOrdinal(max);
     e.setPriority(now());

     tr.save(e);

     return e;
 }

 // ...

 public static class TaskCreateParams {
     public LocalDateTime start;
     public LocalDateTime end;
     public String text;
 }

}