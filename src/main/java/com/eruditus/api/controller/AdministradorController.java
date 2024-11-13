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

import com.eruditus.api.model.Administrador;
import com.eruditus.api.model.Aluno;
import com.eruditus.api.repository.AlunoRepository;
import com.eruditus.api.repository.AdministradorRepository;


@Controller        
public class AdministradorController {
    
    private AdministradorRepository ar;
    private AlunoRepository alunoR;
    
    @RequestMapping (value = "/cadastrarAluno", method = RequestMethod.GET)
    public String form() {
        return "aluno/formAluno";
    }
    
    @RequestMapping (value = "/cadastrarAluno", method = RequestMethod.POST)
    public String form(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
        
        if (result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "verifique os campos...");
            return "redirect:/cadastrarAluno";
        }
        
        alunoR.save(aluno);
        attributes.addFlashAttribute("mensagem", "aluno cadastrado com sucesso!!!");
        return "redirect:/cadastrarAluno";
    }
    
}
