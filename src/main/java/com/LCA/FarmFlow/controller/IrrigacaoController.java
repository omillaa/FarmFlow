package com.LCA.FarmFlow.controller;


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
    private IrrigacaoRepository repository;
    @GetMapping("/formIrrigacao")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long id) {
        Irrigacao irrigacao = (id != null) ? repository.findById(id).orElse(null) : null;
        model.addAttribute("irrigacao", irrigacao);
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

}
