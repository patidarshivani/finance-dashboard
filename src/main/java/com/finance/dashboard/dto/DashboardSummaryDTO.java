package com.finance.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DashboardSummaryDTO {

    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;

    public DashboardSummaryDTO(Double income, Double expense) {
        this.totalIncome = income != null ? income : 0;
        this.totalExpense = expense != null ? expense : 0;
        this.netBalance = this.totalIncome - this.totalExpense;
    }
}

