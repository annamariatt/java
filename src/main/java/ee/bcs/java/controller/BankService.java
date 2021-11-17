package ee.bcs.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public String createAccount(PankDto pank) {
        String sql = "INSERT INTO pank (kontonumber, saldo, id) VALUES (:sqlKontonumber, :sqlSaldo, :sqlId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlKontonumber", pank.getKontonumber());
        paramMap.put("sqlSaldo", pank.getSaldo());
        paramMap.put("sqlId", pank.getId());
        jdbcTemplate.update(sql, paramMap);
        return "konto on loodud";
    }

    public Integer getSaldo(@PathVariable("kontonumber") Integer kontonumber) {
        String sql = "SELECT amount FROM pank WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonumber", kontonumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public String depositAmount(@PathVariable("amount") Integer amount,
                                @PathVariable("kontonumber") Integer kontonumber) {
        if (amount < 0) {
            return "Summa peab olema positiiivne arv";
        }
        //konto balanss - saamine
        String sql = "SELECT amount FROM pank WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("konto", kontonumber);
        jdbcTemplate.update(sql, paramMap);
        return "";
    }
}
