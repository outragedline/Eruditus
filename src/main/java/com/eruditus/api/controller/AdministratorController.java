package com.eruditus.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eruditus.api.model.Administrator;
import com.eruditus.api.model.Student;
import com.eruditus.api.repository.AdministratorRepository;
import com.eruditus.api.repository.StudentRepository;


@Controller        
public class AdministratorController {
    
    private AdministratorRepository ar;
    private StudentRepository sr;
    
    @RequestMapping (value = "/registerStudent", method = RequestMethod.GET)
    public String form() {
        return "student/formStudent";
    }
    
    @RequestMapping (value = "/registerStudent", method = RequestMethod.POST)
    public String form(@Valid Student student, BindingResult result, RedirectAttributes attributes){
        
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "verifique os campos...");
            return "redirect:/registerStudent";
        }
        
        sr.save(student);
        attributes.addFlashAttribute("mensagem", "aluno cadastrado com sucesso!!!");
        return "redirect:/administrator";
    }

    
    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ModelAndView studantDetails(@PathVariable("id") long id){
        Administrator administrator = sr.findById(id);
        ModelAndView mv = new ModelAndView("student/datilsStudent");
        mv.addObject("student", administrator);
        
        Iterable<Student> student = sr.findByAdministrator(administrator);
        
        return mv;
    }
    
    @RequestMapping("/deletStudent")
    public String deletStudent(long id){
        Administrator student = sr.findById(id);
        sr.delete(student);
        
        return "redirect: /administrator";     
    }
    
    
    
}
