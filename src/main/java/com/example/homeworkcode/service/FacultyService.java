package com.example.homeworkcode.service;

import com.example.homeworkcode.model.Faculty;
import com.example.homeworkcode.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private Map<Long,Faculty> faculties = new HashMap<>();
    private Long generatedFacultyId = 1L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(generatedFacultyId);
        faculties.put(generatedFacultyId, faculty);
        generatedFacultyId++;
        return faculty;
    }

    public Faculty getFacultyById(Long id) {
        faculties.get(id);
        return faculties.get(id);
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        faculties.put(id, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long id) {
        Faculty faculty = faculties.get(id);
        faculties.remove(id);
        return faculty;
    }

    public Collection<Faculty> FacultyFilter(String colour) {
        return faculties.values().stream()
                .filter(e -> colour.equals(e.getColour()))
                .collect(Collectors.toList());
    }
}
