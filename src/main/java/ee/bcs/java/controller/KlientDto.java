package ee.bcs.java.controller;

public class KlientDto {
    private String nimi;
    private Integer vanus;
    private String aadress;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Integer getVanus() {
        return vanus;
    }

    public void setVanus(Integer vanus) {
        this.vanus = vanus;
    }

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }
}
