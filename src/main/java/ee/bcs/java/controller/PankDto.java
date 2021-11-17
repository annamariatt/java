package ee.bcs.java.controller;

public class PankDto {
    private Integer id;
    private Integer saldo;
    private Integer kontonumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getKontonumber() {
        return kontonumber;
    }

    public void setKontonumber(Integer kontonumber) {
        this.kontonumber = kontonumber;
    }
}
