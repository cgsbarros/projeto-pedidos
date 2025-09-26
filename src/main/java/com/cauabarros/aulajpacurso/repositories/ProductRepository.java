package com.cauabarros.aulajpacurso.repositories;

import com.cauabarros.aulajpacurso.entities.Category;
import com.cauabarros.aulajpacurso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
