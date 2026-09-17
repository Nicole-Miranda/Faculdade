package org.example;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        JdbcTemplate template = new JdbcTemplate(conexao.getConexao());

        template.execute("DROP TABLE IF EXISTS PESSOA");

        template.execute("CREATE TABLE PESSOA " +
                "(id int primary key auto_increment," +
                "nome varchar(50)," +
                "data_nascimento DATE," +
                "isAdmin bit)");

        //UPDATE, QUERY

        System.out.println("INSERT");
        template.update("INSERT INTO PESSOA VALUES" +
                "(DEFAULT,?,?,?)","Nicole","2006-08-04",0);


        List<Pessoa> pessoa = template.query("SELECT * FROM PESSOA", new BeanPropertyRowMapper<>(Pessoa.class));

        System.out.println(pessoa);


        System.out.println("UPDATE");
        template.update("UPDATE PESSOA SET nome=? where id=?", "Pedro",1);
        pessoa = template.query("SELECT * FROM PESSOA", new BeanPropertyRowMapper<>(Pessoa.class));
        System.out.println(pessoa);

        System.out.println("DELETE");
        template.update("DELETE FROM PESSOA WHERE id=?",1);
        pessoa = template.query("SELECT * FROM PESSOA", new BeanPropertyRowMapper<>(Pessoa.class));
        System.out.println(pessoa);

        // queryForObjetc
        template.update("INSERT INTO PESSOA VALUES" +
                "(DEFAULT,?,?,?)","Nicole","2006-08-04",0);
        template.update("INSERT INTO PESSOA VALUES" +
                "(DEFAULT,?,?,?)","Lorena","2006-08-04",0);
        Pessoa pessoas = template.queryForObject("SELECT * FROM PESSOA where id = ?", new BeanPropertyRowMapper<>(Pessoa.class),2 );
        System.out.println(pessoa);

    }

}