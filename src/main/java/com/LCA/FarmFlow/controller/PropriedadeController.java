package com.LCA.FarmFlow.controller;

import com.LCA.FarmFlow.model.plantacao.DadosAlteraPlantacao;
import com.LCA.FarmFlow.model.plantacao.DadosCadastraPlantacao;
import com.LCA.FarmFlow.model.plantacao.Plantacao;
import com.LCA.FarmFlow.model.plantacao.PlantacaoRepository;
import com.LCA.FarmFlow.model.propriedade.DadosAlteraPropriedade;
import com.LCA.FarmFlow.model.propriedade.DadosCadastraPropriedade;
import com.LCA.FarmFlow.model.propriedade.Propriedade;
import com.LCA.FarmFlow.model.propriedade.PropriedadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/propriedade")
public class PropriedadeController {
    @Autowired
    private PropriedadeRepository repositoryPropriedade;
    @GetMapping("/formPropriedade")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long idPropriedade) {
        Propriedade propriedade = (idPropriedade != null) ? repositoryPropriedade.findById(idPropriedade).orElse(null) : null;
        model.addAttribute("propriedade", propriedade);
        return "propriedade/formPropriedade";
    }
    @GetMapping("/viewPropriedade")
    public String carregaview(Model model) {
        model.addAttribute("listaPropriedade", repositoryPropriedade.findAll());
        return "propriedade/viewPropriedade";
    }
    @PostMapping
    public String cadastraPropriedade(DadosCadastraPropriedade dados) {
        Propriedade P1 = new Propriedade(dados);
        repositoryPropriedade.save(P1);
        return "redirect:/propriedade/formPropriedade";
    }
    @DeleteMapping
    @Transactional
    public String removePropriedade(Long idPropriedade)
    {
        repositoryPropriedade.deleteById(idPropriedade);
        return "redirect:/propriedade/viewPropriedade";
    }
    @PutMapping
    @Transactional
    public String alteraPropriedade(DadosAlteraPropriedade dados)
    {
        Propriedade P1 = repositoryPropriedade.getReferenceById(dados.idPropriedade());
        P1.atualizaDados(dados);
        return "propriedade/formPropriedade";
    }

    @GetMapping("/busca")
    public String buscaPropriedade(Model model, @RequestParam String responsavel) {

        List<Propriedade> propriedades = repositoryPropriedade.findByResponsavel(responsavel);

        model.addAttribute("listaPropriedade", propriedades);

        return "busca/busca";
    }
}
