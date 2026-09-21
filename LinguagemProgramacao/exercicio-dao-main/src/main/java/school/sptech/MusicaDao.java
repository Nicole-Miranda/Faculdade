package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MusicaDao {

    private final JdbcTemplate jdbcTemplate;

    public MusicaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }


    /* Escreva os métodos abaixo */


    public List<Musica> findAll() {
        List<Musica> Musica = jdbcTemplate
                .query("SELECT * FROM Musica", new BeanPropertyRowMapper<>(Musica.class));

        return Musica;
    }

    public Musica findById(Integer id) {
        List<Musica> musicaId= jdbcTemplate.query("SELECT * FROM Musica WHERE id = ?", new BeanPropertyRowMapper<>(Musica.class), id);

        if(musicaId.size() == 0){
            return null;
        }

        return musicaId.get(0);

    }


    public List<Musica> findByNomeLike(String nome) {
        //String sql = "SELECT * FROM Musica WHERE LOWER(nome) LIKE LOWER(?)";
        String parametroBusca = "%" + nome + "%";

        return jdbcTemplate.query(
                "SELECT * FROM Musica WHERE LOWER(nome) LIKE LOWER(?)",
                new BeanPropertyRowMapper<>(Musica.class),
                parametroBusca
        );
    }


    public List<Musica> findByArtista(String artista){

        List<Musica> musicaArtista = jdbcTemplate
                .query("SELECT *  FROM Musica WHERE artista = ?", new BeanPropertyRowMapper<>(Musica.class), artista);

        return musicaArtista;
    }



    public List<Musica> findByAlbum(String album){

        List<Musica> musicaAlbum = jdbcTemplate
                .query("SELECT * FROM Musica WHERE album = ?", new BeanPropertyRowMapper<>(Musica.class), album);

        return musicaAlbum;
    }

    public List<Musica> findByDuracaoGreaterThan(Integer duracao){

        List<Musica> musicaMaiorDuracao = jdbcTemplate
                .query("SELECT * FROM Musica WHERE duracao >= ?", new BeanPropertyRowMapper<>(Musica.class), duracao);

        return musicaMaiorDuracao;

    }

    public List<Musica> findByAlbumAndNomeLike(String album, String nome){

        String parametroBusca = "%" + nome + "%";
        String parametroBuscaAlbum = "%" + album + "%";
        return jdbcTemplate.query(
                "SELECT * FROM Musica WHERE LOWER(nome) LIKE LOWER(?) AND album LIKE ?",
                new BeanPropertyRowMapper<>(Musica.class),
                parametroBusca,parametroBuscaAlbum
        );
    }

    public void save(Musica musica){
        if(musica.getId()==null){
            jdbcTemplate.update("INSERT INTO musica VALUES(DEFAULT,?,?,?,?)",musica.getNome(),musica.getArtista(),musica.getAlbum(),musica.getDuracao());
        }else{
            jdbcTemplate.update("UPDATE musica SET nome =?, artista=?, album=?,duracao=? WHERE id =?",musica.getNome(),musica.getArtista(),musica.getAlbum(),musica.getDuracao(), musica.getId());

        }
    }

    public void deleteById(Integer id){
        jdbcTemplate.update("DELETE FROM musica WHERE id=?",id);
    }


}






