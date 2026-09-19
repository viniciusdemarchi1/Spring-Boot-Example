package com.fatec.exemplo.apiusuarios.controller;

import com.fatec.exemplo.apiusuarios.model.Produto;
import com.fatec.exemplo.apiusuarios.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/produtos")
public class WebProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("produto", new Produto());

        return "cadastro_Produto";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);

        return "cadastro_Produto";
    }

    @GetMapping("/lista")
    public String listar(@RequestParam(required = false) String nome,
                         @RequestParam(required = false) Double preco,
                         Model model) {

        List<Produto> produtos;


        if (nome != null && !nome.isEmpty()) {
            produtos = produtoService.contendoPorNome(nome);
        } else if (preco != null) {
            produtos = produtoService.buscarPorPreco(preco);
        } else {
            produtos = produtoService.listarTodos();
        }

        model.addAttribute("produtos", produtos);
        return "lista_Produtos";
    }
}