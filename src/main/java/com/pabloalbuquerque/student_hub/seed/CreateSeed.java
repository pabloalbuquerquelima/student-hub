package com.pabloalbuquerque.student_hub.seed;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreateSeed {

    private final JdbcTemplate jdbcTemplate;

    public CreateSeed(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres_student_hub");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        CreateSeed createSeed = new CreateSeed(dataSource);
        createSeed.run(args);
    }

    public void run(String... args) {
        executeSqlFile("src/main/resources/create.sql");
    }

    public void executeSqlFile(String filepath) {
        try {
           String sqlScript = new String(Files.readAllBytes(Paths.get(filepath)));
           jdbcTemplate.execute(sqlScript);

           System.out.println("Sucesso ao executar o arquivo: " + filepath);
        } catch (Exception e) {
            System.err.println("Erro ao executar o arquivo: " + filepath);
            e.printStackTrace();
        }
    }
}
