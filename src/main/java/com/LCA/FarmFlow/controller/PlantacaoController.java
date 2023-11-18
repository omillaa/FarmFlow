package com.LCA.FarmFlow.controller;



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
    private PlantacaoRepository repository;
    @GetMapping("/formPlantacao")
    public String carregaPaginaFormulario(Model model, @RequestParam(required = false) Long id) {
        Plantacao plantacao = (id != null) ? repository.findById(id).orElse(null) : null;
        model.addAttribute("plantacao", plantacao);
        return "plantacao/formPlantacao";
    }
    @GetMapping("/viewPlantacao")
    public String carregaview(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "plantacao/viewPlantacao";
    }
    @PostMapping
    public String cadastraPlantacao(DadosCadastraPlantacao dados) {
        Plantacao p1 = new Plantacao(dados);
        repository.save(p1);
        return "redirect:/plantacao/formPlantacao";
    }
    @DeleteMapping
    @Transactional
    public String removePlantacao(Long id)
    {
        repository.deleteById(id);
        return "redirect:/plantacao/viewPlantacao";
    }
    @PutMapping
    @Transactional
    public String alteraPlantacao(DadosAlteraPlantacao dados)
    {
        Plantacao p1  = repository.getReferenceById(dados.idPlantacao());
        p1.atualizaDados(dados);
        return "plantacao/formPlantacao";
    }

}
