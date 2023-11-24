package com.saudesyncapi.repository;

import com.saudesyncapi.model.Cliente;
import com.saudesyncapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    List<Movimentacao> findByClienteFez(Cliente clienteFez);

    List<Movimentacao> findByClienteRecebe(Cliente clienteRecebe);

}
