package com.finance.dashboard.util;



import com.finance.dashboard.entity.*;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinancialRecordSpecification {

//        public static Specification<FinancialRecord> filter(
//                RecordType type,
//                String category,
//                LocalDate startDate,
//                LocalDate endDate
//        ) {
//            return (root, query, cb) -> {
//
//                var predicates = cb.conjunction();
//
//                if (type != null) {
//                    predicates.getExpressions().add(
//                            cb.equal(root.get("type"), type)
//                    );
//                }
//
//                if (category != null && !category.isEmpty()) {
//                    predicates.getExpressions().add(
//                            cb.equal(root.get("category"), category)
//                    );
//                }
//
//                if (startDate != null && endDate != null) {
//                    predicates.getExpressions().add(
//                            cb.between(root.get("date"), startDate, endDate)
//                    );
//                }
//
//                return predicates;
//            };


            public static Specification<FinancialRecord> filter(
                    RecordType type,
                    String category,
                    LocalDate startDate,
                    LocalDate endDate
    ) {
                return (root, query, cb) -> {

                    List<Predicate> predicates = new ArrayList<>();

                    if (type != null) {
                        predicates.add(cb.equal(root.get("type"), type));
                    }

                    if (category != null && !category.isEmpty()) {
                        predicates.add(cb.equal(root.get("category"), category));
                    }

                    if (startDate != null && endDate != null) {
                        predicates.add(cb.between(root.get("date"), startDate, endDate));
                    }
                    return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
//            return cb.and(predicates.toArray(new Predicate[0]));
                };
        }
    }

