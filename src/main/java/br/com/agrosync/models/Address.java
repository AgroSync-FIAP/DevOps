package br.com.agrosync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "agrosync_tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Long id;

    @Column(name = "nr_rua", nullable = false)
    @NotNull
    private Integer numero;

    @Column(name = "nm_rua", length = 150, nullable = false)
    @NotBlank
    private String rua;

    @Column(name = "nm_bairro", length = 80, nullable = false)
    @NotBlank
    private String bairro;

    @Column(name = "sg_estado", length = 2, nullable = false)
    @NotBlank
    private String estado;

    @Column(name = "nm_pais", length = 50, nullable = false)
    @NotBlank
    private String pais;

    @Column(name = "nr_cep", length = 8, nullable = false)
    @NotNull
    private Integer cep;

    @Column(name = "ds_complemento", length = 70)
    private String complemento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_farm")
    private Farm farm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

}
