package com.finance.dashboard.controller;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.entity.RecordType;
import com.finance.dashboard.service.FinancialRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialRecordController {

    @Autowired
    private FinancialRecordService service;


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<FinancialRecord> create(@Valid @RequestBody FinancialRecord record) {
        return ResponseEntity.ok(service.createRecord(record));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FinancialRecord> update(
            @PathVariable Long id,
            @RequestBody FinancialRecord record
    ) {
        return ResponseEntity.ok(service.updateRecord(id, record));
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteRecord(id);
        return ResponseEntity.ok("Record deleted successfully");
    }

//    @PostMapping
//    public ResponseEntity<FinancialRecord> create(
//            @Valid @RequestBody FinancialRecord record
//    ) {
//        return ResponseEntity.ok(service.createRecord(record));
//    }


    @PreAuthorize("hasAnyRole('ADMIN','ANALYST','VIEWER')")
    @GetMapping
    public List<FinancialRecord> getAll() {
        return service.getAllRecords();
    }


    @GetMapping("/filter")
    public List<FinancialRecord> filter(
            @RequestParam(required = false) RecordType type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return service.filterRecords(type, category, startDate, endDate);
    }
//    @GetMapping
//    public List<FinancialRecord> getAll() {
//        return service.getAllRecords();
//    }
}
