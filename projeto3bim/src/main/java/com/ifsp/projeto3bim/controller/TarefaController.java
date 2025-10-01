package com.ifsp.projeto3bim.controller;

import com.ifsp.projeto3bim.model.Tarefa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    private List<Tarefa> tarefas = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tarefas", tarefas);
        return "index";
    }

    @PostMapping("/add")
    public String adicionar(@RequestParam("texto") String texto, @RequestParam("data") String data) {
        tarefas.add(new Tarefa(texto, data, "Pending"));
        return "redirect:/tarefas";
    }

    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable int id) {
        if (id >= 0 && id < tarefas.size()) {
            tarefas.get(id).toggleStatus();
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/delete/{id}")
    public String deletar(@PathVariable int id) {
        if (id >= 0 && id < tarefas.size()) {
            tarefas.remove(id);
        }
        return "redirect:/tarefas";
    }
}
