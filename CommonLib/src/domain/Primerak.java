package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.StatusPrimerka;

public class Primerak implements Serializable, IGeneralObject {

    private Integer rbr;
    private String izdavac;
    private StatusPrimerka status;
    private int godinaIzdavanja;
    private Integer knjigaId;

    public Primerak() {
    }

    public Primerak(int rbr, String izdavac, StatusPrimerka status, int godinaIzdavanja, Integer knjigaId) {
        this.rbr = rbr;
        this.izdavac = izdavac;
        this.status = status;
        this.godinaIzdavanja = godinaIzdavanja;
        this.knjigaId = knjigaId;
    }

    public Primerak(String izdavac, int godinaIzdavanja) {
        this.rbr = -1;
        this.izdavac = izdavac;
        this.status = StatusPrimerka.slobodna;
        this.godinaIzdavanja = godinaIzdavanja;

    }

    Primerak(Integer rbr) {
        this.rbr = rbr;

    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public void setRbr(Integer rbr) {
        this.rbr = rbr;
    }

    public Integer getRbr() {
        return rbr;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public StatusPrimerka getStatus() {
        return status;
    }

    public void setStatus(StatusPrimerka status) {
        this.status = status;
    }

    public Integer getKnjigaId() {
        return knjigaId;
    }

    public void setKnjigaId(Integer knjigaId) {
        this.knjigaId = knjigaId;
    }

    @Override
    public String toString() {
        return this.izdavac;
    }

    @Override
    public String getTableName() {
        return "primerak";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "izdavac, godinaIzdavanja, status, knjigaId";

    }

    @Override
    public String getInsertValues() {

        return new StringBuilder()
                .append("'")
                .append(this.izdavac)
                .append("', ")
                .append(this.godinaIzdavanja)
                .append(", '")
                .append(this.status.toString())
                .append("', ")
                .append(this.knjigaId)
                .toString();

    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
           if (rs.next()) {
             Primerak primerak = new Primerak();
            primerak.setKnjigaId(rs.getInt("knjigaID"));
            primerak.setRbr(rs.getInt("rbr"));
            primerak.setIzdavac(rs.getString("izdavac"));
            primerak.setStatus(StatusPrimerka.valueOf( rs.getString("status")));
            return primerak;
        }
        throw new SQLException("Sistem ne moze da pronadje primerke!");

    }

    @Override
    public String getObjectCase() {
        return "rbr = " + this.getRbr();

    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();

        while (rs.next()) {

            Primerak primerak = new Primerak();
            primerak.setRbr(rs.getInt("rbr"));
            primerak.setIzdavac(rs.getString("izdavac"));
            primerak.setStatus(StatusPrimerka.valueOf(rs.getString("status")));
            primerak.setGodinaIzdavanja(rs.getInt("godinaizdavanja"));
            primerak.setKnjigaId(rs.getInt("knjigaID"));

            list.add(primerak);

        }
        return list;
    }

    @Override
    public String getUpdateValues() {
        if (this.getStatus().equals(StatusPrimerka.izdata)) {
            return new StringBuilder()
                    .append("status = '").append(StatusPrimerka.slobodna.toString()).append("' ").toString();
        }

        return new StringBuilder()
                .append("status = '").append(StatusPrimerka.izdata.toString()).append("' ").toString();

    }

    @Override
    public void setId(int id) {
        this.rbr = id;
    }

    @Override
    public Integer getId() {
        return rbr;
    }

}
