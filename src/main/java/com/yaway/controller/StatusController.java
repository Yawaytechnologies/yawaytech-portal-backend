package com.yaway.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.sql.DataSource;
import java.sql.Connection;


@RestController
@RequestMapping("/api")
public class StatusController {
    private final DataSource dataSource;

    public StatusController(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        try (Connection conn = dataSource.getConnection()) {
            String dbName = conn.getCatalog();
            return ResponseEntity.ok("✅ DB Connected. Database: " + dbName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("❌ DB Connection Failed: " + e.getMessage());
        }
    }
}