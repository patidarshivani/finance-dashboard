package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import com.finance.dashboard.util.FinancialRecordSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class FinancialRecordService {

    @Autowired
    private FinancialRecordRepository repo;

    public FinancialRecord createRecord(FinancialRecord record) {
        return repo.save(record);
    }

    public List<FinancialRecord> getAllRecords() {
        return repo.findAll();
    }


    public List<FinancialRecord> filterRecords(
            RecordType type,
            String category,
            LocalDate startDate,
            LocalDate endDate
    ) {
        Specification<FinancialRecord> spec =
                FinancialRecordSpecification.filter(type, category, startDate, endDate);

        return repo.findAll(spec);
    }


//    public static Specification<FinancialRecord> filter(
//            RecordType type,
//            String category,
//            LocalDate startDate,
//            LocalDate endDate
//    ) {
//        return (root, query, cb) -> {
//
//            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();
//
//            if (type != null) {
//                predicates.add(cb.equal(root.get("type"), type));
//            }
//
//            if (category != null && !category.isEmpty()) {
//                predicates.add(cb.equal(root.get("category"), category));
//            }
//
//            if (startDate != null && endDate != null) {
//                predicates.add(cb.between(root.get("date"), startDate, endDate));
//            }
//            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
////            return cb.and(predicates.toArray(new Predicate[0]));
//        };
    }

