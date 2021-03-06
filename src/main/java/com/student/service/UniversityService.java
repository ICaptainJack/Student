package com.student.service;

import com.student.dto.UniversityDto;

import java.util.List;

public interface UniversityService {

    List<UniversityDto> findByAbbreviation(String abbrev);

    void addUniversityEntity(List<UniversityDto> universityDtoList);
}
