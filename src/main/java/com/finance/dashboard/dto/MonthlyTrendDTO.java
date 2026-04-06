package com.finance.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor // This creates the (Integer, Double) constructor for JPA
@NoArgsConstructor  // This creates the empty constructor for Jackson
public class MonthlyTrendDTO {
    private Integer month;
    private Double total;
}