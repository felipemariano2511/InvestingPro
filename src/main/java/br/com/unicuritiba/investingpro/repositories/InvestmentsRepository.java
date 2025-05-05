package br.com.unicuritiba.investingpro.repositories;

import br.com.unicuritiba.investingpro.models.Investments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentsRepository extends JpaRepository<Investments, Long> {}
