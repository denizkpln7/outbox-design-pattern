package com.denizkpln.outboxdesignpattern.repository;

import com.denizkpln.outboxdesignpattern.model.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutBoxRepository extends JpaRepository<Outbox,Long> {
}
