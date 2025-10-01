package com.ifsp.projeto3bim.controller;

import com.ifsp.projeto3bim.model.Tarefa;
import jakarta.servlet.http.HttpSession;
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
    public String listar(Model model, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        model.addAttribute("tarefas", tarefas);
        return "index";
    }

    @PostMapping("/add")
    public String adicionar(@RequestParam("texto") String texto,
                            @RequestParam("data") String data,
                            @RequestParam(value = "grupo", required = false) String grupo,
                            HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        if (grupo == null) {
            grupo = "";
        }

        tarefas.add(new Tarefa(texto, data, "Pending", grupo));
        return "redirect:/tarefas";
    }

    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable int id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        if (id >= 0 && id < tarefas.size()) {
            tarefas.get(id).toggleStatus();
        }
        return "redirect:/tarefas";
    }

    @PostMapping("/delete/{id}")
    public String deletar(@PathVariable int id, HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        if (id >= 0 && id < tarefas.size()) {
            tarefas.remove(id);
        }
        return "redirect:/tarefas";
    }
}
