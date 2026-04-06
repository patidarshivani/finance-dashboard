package com.finance.dashboard.repository;

import com.finance.dashboard.dto.CategoryWiseDTO;
import com.finance.dashboard.dto.MonthlyTrendDTO;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> , JpaSpecificationExecutor<FinancialRecord> {

    @Query("SELECT SUM(f.amount) FROM FinancialRecord f WHERE f.type = :type")
    Double sumByType(@Param("type") RecordType type);


    @Query("SELECT new com.finance.dashboard.dto.CategoryWiseDTO(f.category, SUM(f.amount)) " +
            "FROM FinancialRecord f GROUP BY f.category")
    List<CategoryWiseDTO> getCategoryWiseData();

//    @Query("SELECT new com.finance.dashboard.dto.MonthlyTrendDTO(FUNCTION('MONTH', f.date), SUM(f.amount)) " +
//            "FROM FinancialRecord f GROUP BY FUNCTION('MONTH', f.date)")
//    List<MonthlyTrendDTO> getMonthlyTrends();

    @Query("SELECT new com.finance.dashboard.dto.MonthlyTrendDTO(MONTH(f.date), SUM(f.amount)) " +
            "FROM FinancialRecord f GROUP BY MONTH(f.date)")
    List<MonthlyTrendDTO> getMonthlyTrends();

//    @Query("SELECT new com.finance.dashboard.dto.MonthlyTrendDTO(MONTH(f.date), SUM(f.amount)) " +
//            "FROM FinancialRecord f GROUP BY MONTH(f.date)")
//    List<MonthlyTrendDTO> getMonthlyTrends();

    List<FinancialRecord> findTop5ByOrderByDateDesc();
}
