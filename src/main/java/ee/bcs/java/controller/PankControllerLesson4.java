package ee.bcs.java.controller;


import com.fasterxml.jackson.databind.util.Named;
import ee.bcs.java.sample.SampleTransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PankControllerLesson4 {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //TODO KÕIK ANNOTATSIOONID ON PUUDU
    public String depositMoney(String accountNumber, Integer amount) {
        if (amount < 0) {
            return "Amount peab olema positiivne arv";
        }
        // leia praegune kotno jääk
        String sql = "SELECT balance FROM aacount WHERE account_number = :accountNumber";
        Map paramMap = new HashMap();
        paramMap.put("accountNumber", accountNumber);
        Integer currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return currentBalance.toString();
    }

    // http://localhost:8080/pank?id=1&kontonumber=123&saldo=1000 (POST)
    @GetMapping("pank")
    public String createClient(@RequestParam("id") Integer id,
                               @RequestParam("kontonumber") Integer kontonumber,
                               @RequestParam("saldo") Integer saldo) {
        //TODO lisa clients listi uus klient
        String sql = "INSERT INTO pank (id, kontonumber, saldo) VALUES (:sqlId, :sqlKontonumber, :sqlSaldo)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlId", id);
        paramMap.put("sqlKontonumber", kontonumber);
        paramMap.put("sqlSaldo", saldo);
        jdbcTemplate.update(sql, paramMap);
        return "Konto on loodud";
    }




    // http://localhost:8080/pank2/getBalance?kontonumber=123
    @GetMapping("pank2/getBalance")
    public int getBalance(@RequestParam("kontonumber") Integer kontonumber) {
        String sql = "SELECT saldo FROM pank WHERE kontonumber = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", kontonumber);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

    }

    // http://localhost:8080/pank2/depositMoney?kontonumber=123&amount=100
    @GetMapping("pank2/depositMoney")
    public String depositMoney(@RequestParam("kontonumber") Integer kontonumber,
                               @RequestParam("amount") int amount) {
        if (amount < 0) {
            return "Summa peab olema positiivne number";
        }
        String sql = "SELECT saldo FROM pank WHERE kontonumber = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", kontonumber);
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        int newBalance = currentBalance + amount;

        String sql2 = "UPDATE pank SET saldo = :newBalance WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("newBalance", newBalance);
        paramMap2.put("kontonumber", kontonumber);
        jdbcTemplate.update(sql2, paramMap2);
        return "Raha lisamine õnnestus";
    }

    // http://localhost:8080/pank2/withdrawMoney?kontonumber=123&amount=100
    @GetMapping("pank2/withdrawMoney")
    public String withdrawMoney(@RequestParam("kontonumber") Integer kontonumber,
                                @RequestParam("amount") int amount) {
        if (amount < 0) {
            return "Summa peab olema positiivne number";
        }
        String sql = "SELECT saldo FROM pank WHERE kontonumber = :sqlAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sqlAccNo", kontonumber);
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        int newBalance = currentBalance - amount;


        String sql2 = "UPDATE pank SET saldo = :newBalance WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("newBalance", newBalance);
        paramMap2.put("kontonumber", kontonumber);
        jdbcTemplate.update(sql2, paramMap2);
        return "Raha on väljastatud";
    }

    // http://localhost:8080/pank2/transferMoney?toKontonumber=123&fromKontonumber=987&amount=100
    @GetMapping("pank2/transferMoney")
    public String transferMoney(@RequestParam("toKontonumber") Integer toKontonumber,
                                @RequestParam("fromKontonumber") Integer fromKontonumber,
                                @RequestParam("amount") int amount) {

        String sql = "SELECT saldo FROM pank WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonumber", fromKontonumber);
        int fromAccountCurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        if (fromAccountCurrentBalance < amount) {
            return "Kontol pole piisavalt palju raha";
        }
        String sql2 = "SELECT saldo FROM pank WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("kontonumber", toKontonumber);
        int toAccountCurrentBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Integer.class);

        int fromAccountNewBalance = fromAccountCurrentBalance - amount;
        int toAccountNewBalance = toAccountCurrentBalance + amount;

        String sql3 = "UPDATE pank SET saldo = :amount WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("amount", fromAccountNewBalance);
        paramMap3.put("kontonumber", fromKontonumber);
        jdbcTemplate.update(sql3, paramMap3);

        String sql4 = "UPDATE pank SET saldo = :amount WHERE kontonumber = :kontonumber";
        Map<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("amount", toAccountNewBalance);
        paramMap4.put("kontonumber", toKontonumber);
        jdbcTemplate.update(sql4, paramMap4);
        return "Raha on ülekantud";
    }
    // http://localhost:8080/pank2/transactionHistory?kontonumber=123&from=2021-11-01&to=2021-11-03
    // http://localhost:8080/pank2/transactionHistory?kontonumber=123&from=2021-11-01
    @GetMapping("pank2/transactionHistory")
    public List<TransactionDto> getTransactionHistory(
            @RequestParam("kontonumber") Integer kontonumber
    ){
        String sql = "SELECT * FROM transaction WHERE kontonumber = :kontonumber ";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("kontonumber", kontonumber);
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(TransactionDto.class));
    }
}
