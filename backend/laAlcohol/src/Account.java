import java.util.Date;

public class Account {

    private String username;
    private String password;
    private String email;
    private java.sql.Timestamp lastlogin;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public java.sql.Timestamp getLastlogin() {
        return lastlogin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLastlogin(java.sql.Timestamp lastlogin) {
        this.lastlogin = lastlogin;
    }
}
