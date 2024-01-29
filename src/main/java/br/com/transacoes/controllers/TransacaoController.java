package br.com.transacoes.controllers;

import br.com.transacoes.entities.TransacaoEntity;
import br.com.transacoes.services.TransacaoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("transacao")
@CrossOrigin(origins = "http://localhost:4200")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public List<TransacaoEntity> recuperaTransacao(){
        return transacaoService.recuparListaTransacao();
    }

    @PostMapping
    public ResponseEntity inserirTransacao(@RequestBody List<TransacaoEntity> transacao){
        List<Boolean> itemComId = new ArrayList<Boolean>();
        transacao.forEach(itemTransacao -> {
            if (itemTransacao.getId() != null) {
                itemComId.add(true);
            } else {
                itemComId.add(false);
            }
        });

        if(itemComId.contains(true)) {
            return ResponseEntity.status(500).build();
        } else {
            transacao.forEach( itemTransacao -> {
                transacaoService.insereOuAtulizaTransacao(itemTransacao);
            });
            return ResponseEntity.status(200).build();
        }
    }

    @DeleteMapping
    public void apagarTransacao(@PathParam("id") Integer id){
        transacaoService.apagaTransacao(id);
    }

    @PutMapping
    public ResponseEntity atualizaTransacao(@RequestBody TransacaoEntity transacao){
        if(transacao.getId() != null) {
            transacaoService.insereOuAtulizaTransacao(transacao);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(500).build();
        }
    }

}
