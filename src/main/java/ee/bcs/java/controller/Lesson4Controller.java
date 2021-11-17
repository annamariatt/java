package ee.bcs.java.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4Controller {
    Map<String, Integer> accounts = new HashMap<>();

    @GetMapping("bank/createAccount")
    // http://localhost:8080/bank/createAccount?accountNumber=EE123
    public String createAccount(@RequestParam("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "Konto on loodud";
    }
    @GetMapping("bank2/createAccount/{accountNumber}")
    // http://localhost:8080/bank2/createAccount/EE123
    public String createAccount2(@PathVariable("accountNumber") String accountNumber) {
        accounts.put(accountNumber, 0);
        return "Konto on loodud";
    }

    @GetMapping("bank/getBalance")
    // http://localhost:8080/bank/getBalance?accountNumber=EE123
    public String getBalance(@RequestParam("accountNumber") String accountNumber) {
        Integer balance = accounts.get(accountNumber);
        return "Konto jääk on: " + balance;
    }

    @GetMapping("bank/depositMoney")
    // http://localhost:8080/bank/depositMoney?accountNumber=EE123&amount=1600
    public String depositMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") Integer amount) {
        if (amount > 0) {
            Integer balance = accounts.get(accountNumber);
            Integer newBalance = balance + amount;
            accounts.put(accountNumber, newBalance);
            return "Konto uus jääk on: " + newBalance;
        } else {
            return "Summa peab olema suurem, kui 0";
        }
    }

    @GetMapping("bank/withdrawMoney")
// http://localhost:8080/bank/withdrawMoney?accountNumber=EE123&amount=1500
    public String withdrawMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        if (balance >= amount) {
            Integer newBalance = balance - amount;
            accounts.put(accountNumber, newBalance);
            return "Kontolt väljastatud: " + amount;
        } else {
            return "Kontojääk pole piisav";
        }
    }

    @GetMapping("bank/transferMoney")
    // http://localhost:8080/bank/transferMoney?accountNumber=EE123&toAccountNumber=EE124&amount=1500
    public String transferMoney(@RequestParam("accountNumber") String accountNumber, @RequestParam("toAccountNumber") String toAccountNumber, @RequestParam("amount") Integer amount) {
        Integer balance = accounts.get(accountNumber);
        Integer toBalance = accounts.get(toAccountNumber);
        if (toBalance == null) {
            return "Selline konto puudub";
        } else if (balance >= amount) {
            Integer newBalance = balance - amount;
            accounts.put(accountNumber, newBalance);
            accounts.put(toAccountNumber, amount + toBalance);
            return "Kontolt üle kantud: " + amount;
        } else {
            return "Tehingu jaoks puuduvad vabad vahendid";
        }
    }
}