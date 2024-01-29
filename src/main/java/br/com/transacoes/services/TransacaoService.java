package br.com.transacoes.services;

import br.com.transacoes.entities.TransacaoEntity;
import br.com.transacoes.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<TransacaoEntity> recuparListaTransacao(){
        return transacaoRepository.findAll();
    }

    public void insereOuAtulizaTransacao(TransacaoEntity transacao){ transacaoRepository.save(transacao); }

    public void apagaTransacao(Integer id){
        transacaoRepository.deleteById(id);
    }
}
