package com.cauabarros.aulajpacurso.repositories;

import com.cauabarros.aulajpacurso.entities.Order;
import com.cauabarros.aulajpacurso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
