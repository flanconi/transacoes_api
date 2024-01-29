package br.com.transacoes.controllers;

import br.com.transacoes.services.TransacaoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class FiltroTransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public Double recuperaPorCateoria(@PathParam("categoria") String categoria){
        List<String> listaTransacoes = transacaoService.recuparListaTransacao().stream().map( x -> {
            return x.getTransacao();
        }).toList();
        List<Double> valoresGastosCategoria = listaTransacoes.stream()
                .filter(transacao -> {
                    return transacao.contains(categoria);
                }).map(itemCategoria -> {
                    int firstIndex = itemCategoria.indexOf(",");
                    int lastIndex = itemCategoria.lastIndexOf(",");
                    return Double.parseDouble(itemCategoria.substring(firstIndex + 1, lastIndex));
                }).toList();
        return valoresGastosCategoria.stream().reduce(0.00, (subtotal, element) -> subtotal + element);
    }
}
