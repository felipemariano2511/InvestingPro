package br.com.unicuritiba.investingpro.dto;

import br.com.unicuritiba.investingpro.models.Investments;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class InvestmentsResponseDTO {

    private String name;
    private Date startDate;
    private float initialInvestment;
    private float profitability;
    private long daysElapsed;
    private float invoicedAmount;

    public InvestmentsResponseDTO(Investments investment) {
        this.name = investment.getName();
        this.startDate = investment.getStartDate();
        this.initialInvestment = investment.getInitialInvestment();
        this.profitability = investment.getProfitability();

        LocalDate start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate today = LocalDate.now();
        this.daysElapsed = ChronoUnit.DAYS.between(start, today);

        float performance = initialInvestment * (profitability / 100) * (daysElapsed / 30f);
        this.invoicedAmount = initialInvestment + performance;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public float getInitialInvestment() {
        return initialInvestment;
    }

    public float getProfitability() {
        return profitability;
    }

    public long getDaysElapsed() {
        return daysElapsed;
    }

    public float getInvoicedAmount() {
        return invoicedAmount;
    }
}
