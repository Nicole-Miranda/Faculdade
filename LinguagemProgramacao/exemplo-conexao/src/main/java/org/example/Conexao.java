package org.example;

import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexao {

    private DataSource conexao;

    public Conexao(){

        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setUsername("sa");
        driver.setPassword("");
        driver.setUrl("jdbc:h2:file:./banco-de-dados");
        driver.setDriverClassName("org.h2.Driver");

        this.conexao = driver;
    }

    public DataSource getConexao() {
        return this.conexao;
    }
}