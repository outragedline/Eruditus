
package com.eruditus.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eruditus.api.dto.course.CourseCreationDTO;
import com.eruditus.api.dto.course.CourseDTO;
import com.eruditus.api.model.Course;
import com.eruditus.api.model.User;
import com.eruditus.api.repository.UserRepository;
import com.eruditus.api.service.AuthService;
import com.eruditus.api.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("courses/{id}")
public class SeasonController {

}
