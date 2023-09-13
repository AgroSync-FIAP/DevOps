package br.com.agrosync.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.agrosync.models.Company;
import br.com.agrosync.models.Gender;
import br.com.agrosync.models.Problema;
import br.com.agrosync.models.Farm;
import br.com.agrosync.models.StatusCompany;
import br.com.agrosync.models.User;
import br.com.agrosync.repository.CompanyRepository;
import br.com.agrosync.repository.ProblemRepository;
import br.com.agrosync.repository.FarmRepository;
import br.com.agrosync.repository.UserRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private CompanyRepository empresaRepository;

        @Autowired
        private FarmRepository farmRepository;

        @Autowired
        private ProblemRepository problemaRepository;

        @Override
        public void run(String... args) throws Exception {

                // User
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                User user1 = User.builder()
                                .name("Usuário 1")
                                .gender(Gender.FEMININO)
                                .cpf(12345678901L)
                                .birthDate(LocalDate.of(1990, 5, 10).format(dateFormatter))
                                .registrationDate(LocalDate.now())
                                .email("user1@example.com")
                                .build();

                User user2 = User.builder()
                                .name("Usuário 2")
                                .gender(Gender.MASCULINO)
                                .cpf(98765432109L)
                                .birthDate(LocalDate.of(1985, 8, 15).format(dateFormatter))
                                .registrationDate(LocalDate.now())
                                .email("user2@example.com")
                                .build();
                userRepository.saveAll(List.of(user1, user2));

                // Empresas
                Company empresa1 = Company.builder()
                                .name("Empresa 01")
                                .nameFantasia("Empresa Fantazia")
                                .cnpj(1234567890l)
                                .email("devemais@outlooks")
                                .status(StatusCompany.ATIVA)
                                .descricao("Uma empresa")
                                .build();

                Company empresa2 = Company.builder()
                                .name("Empresa 02")
                                .nameFantasia("Empresa Fantazia")
                                .cnpj(1234567890l)
                                .email("devemais@outlooks")
                                .status(StatusCompany.ATIVA)
                                .descricao("Uma empresa")
                                .build();

                empresaRepository.saveAll(List.of(empresa1, empresa2));

                // farms
                Farm farm1 = Farm.builder()
                                .name("farm 1")
                                .loteInicial(1L)
                                .descricaoSolo("Solo fértil")
                                .descricaoClima("Tropical")
                                .build();

                Farm farm2 = Farm.builder()
                                .name("farm 2")
                                .loteInicial(2L)
                                .descricaoSolo("Solo arenoso")
                                .descricaoClima("Subtropical")
                                .build();

                farmRepository.saveAll(List.of(farm1, farm2));

                // Problemas
                Problema problema1 = Problema.builder()
                                .name("Problema 1")
                                .descricao("Descrição do problema 1")
                                .build();

                Problema problema2 = Problema.builder()
                                .name("Problema 2")
                                .descricao("Descrição do problema 2")
                                .build();

                problemaRepository.saveAll(List.of(problema1, problema2));
        }
}
