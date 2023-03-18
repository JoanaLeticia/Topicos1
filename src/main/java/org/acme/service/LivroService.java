package org.acme.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.acme.dto.LivroDTO;
import org.acme.dto.LivroResponseDTO;

public interface LivroService {
    List<LivroResponseDTO> getAll();

    LivroResponseDTO findById(@Min(1) Long id);
    LivroResponseDTO create(@NotNull @Valid LivroDTO procuctDTO);
    LivroResponseDTO update(@Min(1) Long id, @NotNull @Valid LivroDTO producDTO);

    void delete(@Min(1) Long id);

    List<LivroResponseDTO> findByNome(@NotNull String nome);

    long count();
}
