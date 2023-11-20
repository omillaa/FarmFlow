package com.LCA.FarmFlow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/busca")
public class BuscaPlanController {

    @GetMapping("/buscaPlan")
    public String loadPage(Model model) {
        return "busca/buscaPlan";
    }
}
