package ee.bcs.java.controller;

public class TransactionDto {
    private Integer kontonumber;
    private Integer id;
    private Integer created;
    private Integer amount;
    private String type;

    public Integer getKontonumber() {
        return kontonumber;
    }

    public void setKontonumber(Integer kontonumber) {
        this.kontonumber = kontonumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
