package br.com.agrosync.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_empresa")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Long id;

    @Column(name = "nm_empresa", length = 50, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "nm_fantasia", length = 50)
    private String nameFantasia;

    @Column(name = "nr_cnpj", nullable = false)
    @NotNull
    private Long cnpj;

    @Column(name = "ds_email", length = 200, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "ds_descricao", length = 150, nullable = false)
    @NotBlank(message = "Precisa ter descrição")
    @Size(max = 150)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "st_empresa", length = 20, nullable = false)
    private StatusCompany status;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Farm> farms;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Problema> problemas;

}
