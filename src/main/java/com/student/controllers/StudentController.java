package com.student.controllers;

import com.student.dto.StudentDto;
import com.student.Interfaces.Impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping
    public List<StudentDto> findByName(@RequestParam("name") String name) {
        logger.info("trying to get the entity student = " + name);
        return studentService.findByName(name);
    }

//    @PostMapping
//    public void newStudentEntity(@RequestBody List<StudentDto> studentDtoList) {
//        //todo: переписать через stream
//        StringBuilder stringBuilder = new StringBuilder();
//        for (StudentDto x : studentDtoList) {
//            stringBuilder.append(x.getFirst_name()).append(" ").append(x.getLast_name());
//        }
//        logger.info("attempt to add entity student = " + stringBuilder);
//        studentService.addStudentEntity(studentDtoList);
//    }
    @PostMapping
    public void newStudentEntity(@RequestBody List<StudentDto> studentDtoList) {
        String studDto =  studentDtoList
                .stream()
                .map(studentDto ->
                        new StringBuilder(studentDto.getFirst_name())
                        .append(" ")
                        .append(studentDto.getLast_name())
                )
                .collect(Collectors.joining(","));
        logger.info("attempt to add entity student = " + studDto);
        studentService.addStudentEntity(studentDtoList);
    }
    @PutMapping
    public void updateStudentEntity(@RequestBody StudentDto studentDto, @RequestParam("id") int id) {
        logger.info("attempt to update student data = " + studentDto.getLast_name());
        studentService.updateStudentEntity(studentDto, id);
    }
}




