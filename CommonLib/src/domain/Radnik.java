
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Radnik implements Serializable, IGeneralObject {

    private Integer id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private StatusRadnika status;

    public Radnik() {
    }

    public Radnik(int id, String ime, String prezime, String username, String password, StatusRadnika status) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    Radnik(Integer id) {
        this.id = id;

    }

    public Radnik(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Radnik(String ime, String prezime, String username, String password, StatusRadnika status) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.status = status;
    }

  

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusRadnika getStatus() {
        return status;
    }

    public void setStatus(StatusRadnika status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Radnik other = (Radnik) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }

    @Override
    public String getTableName() {
        return "radnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, username, password, status";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.ime)
                .append("', '")
                .append(this.prezime)
                .append("', '")
                .append(this.username)
                .append("', '")
                .append(this.password)
                .append("', ")
                .append(this.status.getId())
                .toString();

    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        if (rs.next()) {
            Radnik radnik = new Radnik();
            radnik.setId(rs.getInt("id"));
            radnik.setIme(rs.getString("ime"));
            radnik.setPrezime(rs.getString("prezime"));
            radnik.setUsername(rs.getString("username"));
            radnik.setPassword(rs.getString("password"));
            radnik.setStatus(StatusRadnika.getById(rs.getInt("status")));
            return radnik;
        }
        //return null;
        //sklonjeno da baca EXCP jer je blokirao formu 
         throw new SQLException("Sistem ne moze da pronadje bibliotekara po zadatim vrednostima!");

    }

    @Override
    public String getObjectCase() {
        return "password= '" + this.getPassword() + "' AND username = '" + this.getUsername() + "'";

    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();

        while (rs.next()) {
            Radnik radnik = new Radnik();

            radnik.setId(rs.getInt("id"));
            radnik.setIme(rs.getString("ime"));
            radnik.setPrezime(rs.getString("prezime"));
            radnik.setUsername(rs.getString("username"));
            radnik.setPassword(rs.getString("password"));

            radnik.setStatus(StatusRadnika.getById(rs.getInt("status")));

            list.add(radnik);
        }

        return list;

    }

    @Override
    public String getUpdateValues() {
        return new StringBuilder()
                .append("ime = '").append(this.getIme()).append("', ")
                .append("prezime = '").append(this.getPrezime()).append("', ")
                .append("username= ").append(this.getUsername())
                .append("password= ").append(this.getPassword())
                .toString();

    }

}
