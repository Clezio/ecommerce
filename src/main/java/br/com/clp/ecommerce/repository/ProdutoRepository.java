package br.com.clp.ecommerce.repository;

import br.com.clp.ecommerce.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
