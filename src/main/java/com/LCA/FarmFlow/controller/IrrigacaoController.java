package com.LCA.FarmFlow.controller;


import com.LCA.FarmFlow.model.irrigacao.DadosAlteraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.DadosCadastraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import com.LCA.FarmFlow.model.irrigacao.IrrigacaoRepository;
import com.LCA.FarmFlow.model.plantacao.PlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/irrigacao")
public class IrrigacaoController {
    @Autowired
    private IrrigacaoRepository repository;
    @Autowired
    private PlantacaoRepository repositoryPlantacao;
    @GetMapping("/formIrrigacao")
    public String carregaPaginaFormulario(Model model,Long id) {

        if(id!=null)
        {
            Irrigacao irrigacao = repository.getReferenceById(id);
            model.addAttribute("irrigacao", irrigacao);
        }
        model.addAttribute("lista", repositoryPlantacao.findAll());

        return "irrigacao/formIrrigacao";
    }
    @GetMapping("/viewIrrigacao")
    public String carregaview(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "irrigacao/viewIrrigacao";
    }
    @PostMapping
    public String cadastraIrrigacao(DadosCadastraIrrigacao dados) {
        Irrigacao i1 = new Irrigacao(dados);
        repository.save(i1);
        return "redirect:/irrigacao/formIrrigacao";
    }
    @DeleteMapping
    @Transactional
    public String removeIrrigacao(Long id)
    {
        repository.deleteById(id);
        return "redirect:/irrigacao/viewIrrigacao";
    }
    @PutMapping
    @Transactional
    public String alteraIrrigacao(DadosAlteraIrrigacao dados)
    {
        Irrigacao i1  = repository.getReferenceById(dados.idIrrigacao());
       i1.atualizaDados(dados);
        return "irrigacao/formIrrigacao";
    }
    @GetMapping("/buscaIrrigacao")
    public String loadPage(Model model)
    {   return "irrigacao/buscaIrrigacao"; }
    @GetMapping("/irrigacao")
    public String getIrrigacoesPorData(Model model, @RequestParam("dataIrrig") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataIrrig) {
        List<Irrigacao>irrigacoes = repository.buscaIrrig(dataIrrig);
        model.addAttribute("lista",irrigacoes);
        return "irrigacao/buscaIrrigacao";
    }


}
