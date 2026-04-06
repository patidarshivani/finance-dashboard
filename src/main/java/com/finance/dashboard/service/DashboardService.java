package com.finance.dashboard.service;

import com.finance.dashboard.dto.CategoryWiseDTO;
import com.finance.dashboard.dto.DashboardSummaryDTO;
import com.finance.dashboard.dto.MonthlyTrendDTO;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private FinancialRecordRepository repo;

    public DashboardSummaryDTO getSummary() {
        Double income = repo.sumByType(RecordType.INCOME);
        Double expense = repo.sumByType(RecordType.EXPENSE);

        return new DashboardSummaryDTO(income, expense);
    }

    public List<CategoryWiseDTO> getCategoryWise() {
        return repo.getCategoryWiseData();
    }

    public List<MonthlyTrendDTO> getMonthlyTrends() {
        return repo.getMonthlyTrends();
    }

    public List<FinancialRecord> getRecent() {
        return repo.findTop5ByOrderByDateDesc();
    }
}
