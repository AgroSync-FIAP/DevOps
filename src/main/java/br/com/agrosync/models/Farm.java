package br.com.agrosync.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_farm")
    private Long id;

    @Column(name = "nm_farm", length = 80, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "lt_inicial", nullable = false)
    @NotNull
    private Long loteInicial;

    @Column(name = "lt_atual")
    private Long loteAtual;

    @Column(name = "ds_solo", length = 200, nullable = false)
    @NotBlank
    private String descricaoSolo;

    @Column(name = "ds_clima", length = 100, nullable = false)
    @NotBlank
    private String descricaoClima;

    @ManyToMany
    private List<Address> addresss;

    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL)
    private SuplyChain suplychain;

    @OneToOne
    @JoinColumn(name = "id_producao_cultivo")
    private Plant producaoCultivo;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Company empresa;

}

