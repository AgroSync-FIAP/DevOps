package br.com.agrosync.models;

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
@Table(name = "agrosync_tb_telefone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    @Column(name = "nr_ddi", nullable = false)
    @NotNull
    private Long ddi;

    @Column(name = "nr_ddd", nullable = false)
    @NotNull
    private Long ddd;

    @Column(name = "nr_telefone", nullable = false)
    @NotNull
    private String numero;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

}
