package com.LCA.FarmFlow.controller;

import com.LCA.FarmFlow.model.irrigacao.DadosAlteraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.DadosCadastraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import com.LCA.FarmFlow.model.irrigacao.IrrigacaoRepository;
import com.LCA.FarmFlow.model.plantacao.DadosAlteraPlantacao;
import com.LCA.FarmFlow.model.plantacao.DadosCadastraPlantacao;
import com.LCA.FarmFlow.model.plantacao.Plantacao;
import com.LCA.FarmFlow.model.plantacao.PlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/plantacao")
public class PlantacaoController {
    @Autowired
    private PlantacaoRepository repositoryPlantacao;
    @GetMapping("/formPlantacao")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long idPlantacao) {
        Plantacao plantacao = (idPlantacao != null) ? repositoryPlantacao.findById(idPlantacao).orElse(null) : null;
        model.addAttribute("plantacao", plantacao);
        return "plantacao/formPlantacao";
    }
    @GetMapping("/viewPlantacao")
    public String carregaview(Model model) {
        model.addAttribute("listaPlantacao", repositoryPlantacao.findAll());
        return "plantacao/viewPlantacao";
    }
    @PostMapping
    public String cadastraPlantacao(DadosCadastraPlantacao dados) {
        Plantacao P = new Plantacao(dados);
        repositoryPlantacao.save(P);
        return "redirect:/plantacao/formPlantacao";
    }
    @DeleteMapping
    @Transactional
    public String removePlantacao(Long idPlantacao)
    {
        repositoryPlantacao.deleteById(idPlantacao);
        return "redirect:/plantacao/viewPlantacao";
    }
    @PutMapping
    @Transactional
    public String alteraPlantacao(DadosAlteraPlantacao dados)
    {
        Plantacao P = repositoryPlantacao.getReferenceById(dados.idPlantacao());
        P.atualizaDados(dados);
        return "plantacao/formPlantacao";
    }
}
