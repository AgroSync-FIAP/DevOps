package br.com.agrosync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "agrosync_tb_suplychain")
public class SuplyChain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_suplychain")
    private Long id;

    @Column(name = "qtd_produzida", nullable = false)
    @NotNull
    private Long qtdProduzida;

    @Column(name = "qtd_exportada", nullable = false)
    @NotNull
    private Long qtdExportada;

    @Column(name = "qtd_perdida", nullable = false)
    @NotNull
    private Long qtdPerdida;

    @OneToOne
    @JoinColumn(name = "id_farm")
    private Farm farm;

}
