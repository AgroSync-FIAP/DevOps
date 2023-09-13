package br.com.agrosync.models;

import java.time.LocalDate;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agrosync_tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToOne(mappedBy = "user")
    private Company company;
    
    @OneToOne
    @JoinColumn(name = "login_id")
    private Login login;

    @Column(name = "user_name", length = 100, nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_gender", length = 20, nullable = false)
    private Gender gender;
    

    @Column(name = "user_email", length = 100, nullable = false)
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email must be valid")
    private String email;

    @Column(name = "user_cpf", nullable = false)
    @NotNull(message = "CPF cannot be null")
    private Long cpf;

    @Column(name = "user_birth_date", nullable = false)
    @NotNull(message = "Birth date cannot be null")
    private String birthDate;

    @Column(name = "user_registration_date", nullable = false)
    @NotNull(message = "Registro não pode ser nulo")
    private LocalDate registrationDate;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    @Column(name = "user_cnpj")
    private String cnpj;

    public String getBirthDate() {
        return null;
    }
}
