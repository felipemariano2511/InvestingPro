package br.com.unicuritiba.investingpro.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "investiments")
public class Investments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name =  "start_data")
    private Date startDate;

    @Column(name = "profitability")
    private float profitability;

    @Column(name = "initial_investment")
    private float initialInvestment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getProfitability() {
        return profitability;
    }

    public void setProfitability(float profitability) {
        this.profitability = profitability;
    }

    public float getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(float initialInvestment) {
        this.initialInvestment = initialInvestment;
    }
}
