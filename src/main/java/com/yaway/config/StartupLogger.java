package com.yaway.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class StartupLogger implements CommandLineRunner{
    private final DataSource dataSource;

    public StartupLogger(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args){
        System.out.println("\n========SYSTEM STATUS=========");

        try(Connection conn=dataSource.getConnection()) {
            String dbUrl = conn.getMetaData().getURL();
            String dbName = conn.getCatalog();
            System.out.println("✅ DATABASE CONNECTED SUCCESSFULLY");
            System.out.println("🔗 JDBC URL: " + dbUrl);
            System.out.println("📂 Database Name: " + dbName);


        }catch (Exception e){

            System.out.println("❌ DATABASE CONNECTION FAILED: " + e.getMessage());
        }

        System.out.println("🌐 SERVER RUNNING AT: http://localhost:8000/");
        System.out.println("=================================================\n");
    }
}