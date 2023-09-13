package br.com.agrosync.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agrosync.models.Assessment;
import br.com.agrosync.repository.AssessmentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agrosync/avaliacoes")
public class AssessmentController {
    
    @Autowired
    private AssessmentRepository avaliacaoRepository;


    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<Assessment>>> obterAvaliacoesPaginadas(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Assessment> avaliacoesPage = avaliacaoRepository.findAll(pageable);

        List<EntityModel<Assessment>> avaliacoes = avaliacoesPage.getContent().stream()
                .map(Assessment::toEntityModel)
                .collect(Collectors.toList());

        PagedModel<EntityModel<Assessment>> pagedModel = PagedModel.of(avaliacoes,
                new PagedModel.PageMetadata(avaliacoesPage.getSize(), avaliacoesPage.getNumber(),
                        avaliacoesPage.getTotalElements(), avaliacoesPage.getTotalPages()));

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Assessment>> buscarAvaliacaoPorId(@PathVariable Long id) {
        Optional<Assessment> avaliacaoOptional = avaliacaoRepository.findById(id);

        if (avaliacaoOptional.isPresent()) {
            Assessment avaliacao = avaliacaoOptional.get();
            EntityModel<Assessment> avaliacaoModel = criarModeloAvaliacao(avaliacao);
            return ResponseEntity.ok(avaliacaoModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Assessment> criarAvaliacao(@RequestBody @Valid Assessment avaliacao) {
        Assessment novaAvaliacao = avaliacaoRepository.save(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> atualizarAvaliacaoPorId(@PathVariable Long id,
            @RequestBody @Valid Assessment avaliacaoAtualizada) {
        Optional<Assessment> avaliacaoOptional = avaliacaoRepository.findById(id);

        if (avaliacaoOptional.isPresent()) {
            Assessment avaliacao = avaliacaoOptional.get();
            avaliacao.setDataAvaliacao(avaliacaoAtualizada.getDataAvaliacao());
            avaliacao.setImagem(avaliacaoAtualizada.getImagem());
            avaliacao.setStatus(avaliacaoAtualizada.getStatus());
            avaliacao.setSolucao(avaliacaoAtualizada.getSolucao());
            avaliacaoRepository.save(avaliacao);
            return ResponseEntity.ok(avaliacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private EntityModel<Assessment> criarModeloAvaliacao(Assessment avaliacao) {
        EntityModel<Assessment> modelo = EntityModel.of(avaliacao);
        Link selfLink = WebMvcLinkBuilder.linkTo(AssessmentController.class).slash(avaliacao.getId()).withSelfRel();
        modelo.add(selfLink);
        return modelo;
    }
}
