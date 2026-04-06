package com.finance.dashboard.controller;

import com.finance.dashboard.dto.CategoryWiseDTO;
import com.finance.dashboard.dto.DashboardSummaryDTO;
import com.finance.dashboard.dto.MonthlyTrendDTO;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService service;

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/summary")
    public DashboardSummaryDTO summary() {
        return service.getSummary();
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/category-wise")
    public List<CategoryWiseDTO> categoryWise() {
        return service.getCategoryWise();
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/monthly")
    public List<MonthlyTrendDTO> monthly() {
        return service.getMonthlyTrends();
    }

    @PreAuthorize("hasAnyRole('ADMIN','ANALYST')")
    @GetMapping("/recent")
    public List<FinancialRecord> recent() {
        return service.getRecent();
    }
}
