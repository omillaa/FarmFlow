package com.LCA.FarmFlow.controller;
import com.LCA.FarmFlow.model.cultura.Cultura;
import com.LCA.FarmFlow.model.cultura.CulturaRepository;
import com.LCA.FarmFlow.model.cultura.DadosAlteraCultura;
import com.LCA.FarmFlow.model.cultura.DadosCadastraCultura;
import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/cultura")
public class CulturaController {
@Autowired
private CulturaRepository repository;
    @GetMapping("/formCultura")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long id) {
        Cultura cultura = (id != null) ? repository.findById(id).orElse(null) : null;
        model.addAttribute("cultura", cultura);
        return "cultura/formCultura";
    }
    @GetMapping("/viewCultura")
    public String carregaview(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "cultura/viewCultura";
    }
    @PostMapping
    public String cadastraCultura(DadosCadastraCultura dados) {
        Cultura C1 = new Cultura(dados);
        repository.save(C1);
        return "redirect:/cultura/formCultura";
    }
    @DeleteMapping
    @Transactional
    public String removeCultura(Long id)
    {
        repository.deleteById(id);
        return "redirect:/cultura/viewCultura";
    }
    @PutMapping
    @Transactional
    public String alteraCultura(DadosAlteraCultura dados)
    {
        Cultura C1 = repository.getReferenceById(dados.id());
        C1.atualizaDados(dados);
        return "cultura/formCultura";
    }
    @GetMapping("/buscaCultura")
    public String loadPage(Model model)
    {   return "cultura/buscaCultura"; }
    @GetMapping("/cultura")
    public String buscaCultura (Model model, @RequestParam("nome") String nome) {
        List<Cultura> culturas = repository.buscaCultura(nome);
        model.addAttribute("lista",culturas);
        return "cultura/buscaCultura";
    }
}
