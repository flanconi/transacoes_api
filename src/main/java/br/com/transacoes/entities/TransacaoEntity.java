package br.com.transacoes.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "transacoes")
public class TransacaoEntity {

    @Id
    @Column(name = "idtransacao", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "transacao", nullable = false)
    private String transacao;
}
