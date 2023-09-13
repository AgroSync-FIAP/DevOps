package br.com.agrosync.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "agrosync_tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @Column(name = "dt_pagamento", nullable = false)
    @NotNull
    private Date dataPagamento;

    @Column(name = "preco_pagamento", nullable = false)
    @NotNull
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Company empresa;

}
