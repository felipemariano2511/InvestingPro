package br.com.unicuritiba.investingpro.services;

import br.com.unicuritiba.investingpro.dto.InvestmentsResponseDTO;
import br.com.unicuritiba.investingpro.models.Investments;
import br.com.unicuritiba.investingpro.repositories.InvestmentsRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestmentsService {

    @Autowired
    private InvestmentsRepository repository;

    public ResponseEntity<List<InvestmentsResponseDTO>> searchAllInvestments() {
        List<InvestmentsResponseDTO> list = repository.findAll().stream()
                .map(InvestmentsResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }

    public ResponseEntity<InvestmentsResponseDTO> searchInvestmentForId(Long id) throws BadRequestException {
        Investments investment = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Investimento não encontrado através do id " + id));

        return ResponseEntity.ok(new InvestmentsResponseDTO(investment));
    }

    public ResponseEntity<InvestmentsResponseDTO> searchInvestmentDetails(Long id) throws BadRequestException {
        return searchInvestmentForId(id);
    }

    public ResponseEntity<InvestmentsResponseDTO> saveInvestment(Investments investment) {
        Investments saved = repository.save(investment);
        return ResponseEntity.ok(new InvestmentsResponseDTO(saved));
    }

    public ResponseEntity<InvestmentsResponseDTO> updateInvestment(Long id, Investments investment) throws BadRequestException {
        Investments updateInvestment = repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Investimento não encontrado com id " + id));

        updateInvestment.setName(investment.getName());
        updateInvestment.setStartDate(investment.getStartDate());
        updateInvestment.setProfitability(investment.getProfitability());
        updateInvestment.setInitialInvestment(investment.getInitialInvestment());

        Investments updated = repository.saveAndFlush(updateInvestment);
        return ResponseEntity.ok(new InvestmentsResponseDTO(updated));
    }

    public ResponseEntity<Void> deleteInvestment(Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
