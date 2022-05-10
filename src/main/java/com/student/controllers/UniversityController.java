package com.student.controllers;

import com.student.dto.UniversityDto;
import com.student.service.UniversityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public List<UniversityDto> findByAbbreviation(@RequestParam("abbrev") String abbrev) {
        // todo: создать класс маппер который преобразует ентити в дто
        logger.info("trying to get the essence of the university = " + abbrev);
        return universityService.findByAbbreviation(abbrev);
    }

    @PostMapping
    public void addUniversityEntity(@RequestBody List<UniversityDto> listUniversityDto) {
        StringBuilder stringBuilder = new StringBuilder();
        for (UniversityDto x : listUniversityDto) {
            stringBuilder.append(x);
        }
        logger.info("trying to add entity university = " + stringBuilder);
        universityService.addUniversityEntity(listUniversityDto);
    }
}
