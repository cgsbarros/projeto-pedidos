package com.cauabarros.aulajpacurso.repositories;

import com.cauabarros.aulajpacurso.entities.Category;
import com.cauabarros.aulajpacurso.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
