package com.LCA.FarmFlow.controller;

import com.LCA.FarmFlow.model.colheita.Colheita;
import com.LCA.FarmFlow.model.colheita.ColheitaRepository;
import com.LCA.FarmFlow.model.colheita.DadosAlteraColheita;
import com.LCA.FarmFlow.model.colheita.DadosCadastraColheita;
import com.LCA.FarmFlow.model.cultura.Cultura;
import com.LCA.FarmFlow.model.cultura.CulturaRepository;
import com.LCA.FarmFlow.model.cultura.DadosAlteraCultura;
import com.LCA.FarmFlow.model.cultura.DadosCadastraCultura;
import com.LCA.FarmFlow.model.plantacao.Plantacao;
import com.LCA.FarmFlow.model.plantacao.PlantacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colheita")
public class ColheitaController {
    @Autowired
    private ColheitaRepository repositoryColheita;

    @Autowired
    private PlantacaoRepository repositoryPlantacao;
    @GetMapping("/formColheita")
    public String carregaPaginaFormulario(Model model, Long idColheita)
    {
        if(idColheita!=null)
        {
            Colheita colheita = repositoryColheita.getReferenceById(idColheita);
            model.addAttribute("colheita", colheita);
        }
        model.addAttribute("lista", repositoryPlantacao.findAll());
        return "colheita/formColheita";
    }
    @GetMapping("/viewColheita")
    public String carregaview(Model model) {
        model.addAttribute("lista", repositoryColheita.findAll());
        return "colheita/viewColheita";
    }
    @PostMapping
    public String cadastraColheita(DadosCadastraColheita dados) {
        Colheita C2 = new Colheita(dados);
        repositoryColheita.save(C2);
        return "redirect:/colheita/formColheita";
    }
    @DeleteMapping
    @Transactional
    public String removeColheita(Long idColheita)
    {
        repositoryColheita.deleteById(idColheita);
        return "redirect:/colheita/viewColheita";
    }
    @PutMapping
    @Transactional
    public String alteraColheita(DadosAlteraColheita dados)
    {
        Colheita C2 = repositoryColheita.getReferenceById(dados.idColheita());
        C2.autualizaDados(dados);
        repositoryColheita.save(C2);
        return "redirect:/colheita/viewColheita";
    }
}
