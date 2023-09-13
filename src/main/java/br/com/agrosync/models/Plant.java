package br.com.agrosync.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_plant")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private Long id;

    @Column(name = "type_planting", nullable = false)
    @NotBlank
    private String typePlanting;

    @Column(name = "scientific_name", nullable = false)
    @NotBlank
    private String scientificName;

    @Column(name = "common_name", nullable = false)
    @NotBlank
    private String commonName;

    @Column(name = "status", nullable = false)
    @NotBlank
    private String status;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

}
