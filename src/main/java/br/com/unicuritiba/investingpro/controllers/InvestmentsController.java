package br.com.unicuritiba.investingpro.controllers;

import br.com.unicuritiba.investingpro.models.Investments;
import br.com.unicuritiba.investingpro.services.InvestmentsService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/investimentos")
public class InvestmentsController {

    @Autowired
    private InvestmentsService service;

    @GetMapping
    public ResponseEntity<?> getAllInvestments() {

        return ResponseEntity.ok(service.searchAllInvestments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllInvestments(@PathVariable Long id) throws BadRequestException {

        return ResponseEntity.ok(service.searchInvestmentForId(id));
    }

    @PostMapping
    public ResponseEntity<?> postInvestment(@RequestBody Investments investment) {
        return ResponseEntity.ok(service.saveInvestment(investment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putInvestment(@PathVariable Long id, @RequestBody Investments investment) throws BadRequestException {
        return ResponseEntity.ok(service.updateInvestment(id, investment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInvestment(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteInvestment(id));
    }
}
