package br.com.agrosync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "agrosync_tb_login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_login")
    private Long id;

    @Column(name = "ds_email", length = 80, unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "ds_senha", length = 15, nullable = false)
    @NotBlank
    private String senha;

    @OneToOne(mappedBy = "login")
    private User user;

}
