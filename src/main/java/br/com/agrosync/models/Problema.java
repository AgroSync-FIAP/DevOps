package br.com.agrosync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agrosync_tb_problema")
public class Problema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_problema")
    private Long id;

    @Column(name = "nm_problema", length = 100, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "ds_problema", length = 100, nullable = false)
    @NotBlank
    private String descricao;

    @OneToOne(mappedBy = "problema")
    private Assessment avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Company empresa;

}
