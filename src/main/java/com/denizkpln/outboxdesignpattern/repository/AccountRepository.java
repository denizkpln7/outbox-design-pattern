package com.denizkpln.outboxdesignpattern.repository;

import com.denizkpln.outboxdesignpattern.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
