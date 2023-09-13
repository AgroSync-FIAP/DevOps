package br.com.agrosync.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.Date;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

import br.com.agrosync.controllers.AssessmentController;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "agrosync_tb_avaliacao")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long id;

    @Column(name = "data_avaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataAvaliacao;

    @NotNull
    @Lob
    @Column(name = "img_avaliacao", nullable = false)
    private byte[] imagem;

    @Column(name = "st_avaliacao", length = 30, nullable = false)
    @NotBlank
    private String status;

    @Column(name = "ds_solucao", length = 150, nullable = false)
    @NotBlank
    @Size(max = 150)
    private String solucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_problema")
    private Problema problema;

    public EntityModel<Assessment> toEntityModel() {
        Link selfLink = linkTo(AssessmentController.class).slash(id).withSelfRel();
        return EntityModel.of(this, selfLink);
    }

}

