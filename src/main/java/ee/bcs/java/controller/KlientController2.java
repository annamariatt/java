package ee.bcs.java.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KlientController2 {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // http://localhost:8080/klient?nimi=Bulgakov&aadress=Moskva&vanus=33 (POST)
    @GetMapping("klient")
    public String createClient(@RequestParam("nimi") String nimi,
                               @RequestParam("aadress") String aadress,
                               @RequestParam("vanus") Integer vanus) {
        //TODO lisa clients listi uus klient
        String sql = "INSERT INTO klient (nimi, aadress, vanus) VALUES (:sqlNimi, :sqlAadress, :sqlVanus)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlNimi", nimi);
        paramMap.put("sqlAadress", aadress);
        paramMap.put("sqlVanus", vanus);
        jdbcTemplate.update(sql, paramMap);
        return "Klient on loodud";
    }

    // http://localhost:8080/klient2 (GET)
    @GetMapping("klient2")
    public List<ClientDto> getAllKlient() {
        String sql = "SELECT * FROM klient";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(ClientDto.class));
    }

    // http://localhost:8080/klient/vanus/65 (GET)
    @GetMapping("klient/vanus/{vanus}")
    public KlientDto getClient(@PathVariable("vanus") int vanus) {
        String sql = "SELECT * FROM klient WHERE vanus = :vanus";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vanus", vanus);

        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(KlientDto.class));

    }

    // http://localhost:8080/klient/delete/25  (DELETE)
    @GetMapping("klient/delete/{vanus}")
    public String deleteClient(@PathVariable("vanus") int vanus) {
        String sql = "DELETE FROM klient WHERE vanus = :vanus";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("vanus", vanus);
        jdbcTemplate.update(sql, paramMap);
        return "Kustutatud";
    }

    // http://localhost:8080/klient/update/15/Chicago (EDIT)
    @GetMapping("klient/update/{id}/{aadress}")
    public String updateClient(@PathVariable("aadress") String aadress, @PathVariable("id") int id) {
        String sql = "UPDATE klient SET aadress = :aadress WHERE id =:id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("aadress", aadress);
        jdbcTemplate.update(sql, paramMap);
                            return "Muudetud";
    }

    // http://localhost:8080/klient/getAllClients
    @GetMapping("klient/getAllClients")
    public List<KlientDto> getAllClient() {
        String sql = "SELECT * FROM klient";
        Map<String, Object> paramMap = new HashMap<>();
        List<KlientDto> result = jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(KlientDto.class));
        return result;
                //TODO tagasta kõik kliendid
        // (accessModifier) (tagastusTüüp) funktsiooniNimi (muutujaTüüp1 muutujaNimi1, muutujaTüüp2 muutujaNimi2
    }
}