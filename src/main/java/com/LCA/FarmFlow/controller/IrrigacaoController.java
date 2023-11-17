package com.LCA.FarmFlow.controller;

import com.LCA.FarmFlow.model.colheita.Colheita;
import com.LCA.FarmFlow.model.colheita.ColheitaRepository;
import com.LCA.FarmFlow.model.colheita.DadosAlteraColheita;
import com.LCA.FarmFlow.model.colheita.DadosCadastraColheita;
import com.LCA.FarmFlow.model.irrigacao.DadosAlteraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.DadosCadastraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import com.LCA.FarmFlow.model.irrigacao.IrrigacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/irrigacao")
public class IrrigacaoController {
    @Autowired
    private IrrigacaoRepository repositoryIrrigacao;
    @GetMapping("/formIrrigacao")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long idIrrigacao) {
        Irrigacao irrigacao = (idIrrigacao != null) ? repositoryIrrigacao.findById(idIrrigacao).orElse(null) : null;
        model.addAttribute("irrigacao", irrigacao);
        return "irrigacao/formIrrigacao";
    }
    @GetMapping("/viewIrrigacao")
    public String carregaview(Model model) {
        model.addAttribute("listaIrrigacao", repositoryIrrigacao.findAll());
        return "irrigacao/viewIrrigacao";
    }
    @PostMapping
    public String cadastraIrrigacao(DadosCadastraIrrigacao dados) {
        Irrigacao I = new Irrigacao(dados);
        repositoryIrrigacao.save(I);
        return "redirect:/irrigacao/formIrrigacao";
    }
    @DeleteMapping
    @Transactional
    public String removeIrrigacao(Long idIrrigacao)
    {
        repositoryIrrigacao.deleteById(idIrrigacao);
        return "redirect:/irrigacao/viewIrrigacao";
    }
    @PutMapping
    @Transactional
    public String alteraIrrigacao(DadosAlteraIrrigacao dados)
    {
        Irrigacao I = repositoryIrrigacao.getReferenceById(dados.idIrrigacao());
        I.autualizaDados(dados);
        return "irrigacao/formIrrigacao";
    }
}
