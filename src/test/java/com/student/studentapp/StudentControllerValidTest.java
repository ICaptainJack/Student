package com.student.studentapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.controllers.StudentController;
import com.student.dto.StudentDto;
import com.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
//@WebMvcTest(StudentController.class)
@SpringBootTest
public class StudentControllerValidTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private StudentServiceImpl service;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void newStudentEntityValid() throws Exception {
        List<StudentDto> list = new ArrayList<>();
        StudentDto studentDto = new StudentDto();
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("1991-03-02");
        studentDto.setFirstName("");
        studentDto.setLastName("Esip");
        studentDto.setEmail("se@mail.ru");
        studentDto.setGender("Male");
        studentDto.setDateOfBirth(date);
        studentDto.setCountryOfBirth("Russia");
        list.add(studentDto);

        String contentAsString = mvc.perform(
                        post("/student")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(list))
                )
                .andExpect(status().is5xxServerError())
                .andReturn()
                .getResponse()
                .getContentAsString();
        String response = "{\n" +
                "  \"timestamp\": \"2022-07-09T11:18:51.800+00:00\",\n" +
                "  \"status\": 500,\n" +
                "  \"error\": \"Internal Server Error\",\n" +
                "  \"path\": \"/student\"\n" +
                "}";
        assertEquals(response,contentAsString);
    }
}