import java.util.Date;

public class Account {

    private long user_id;
    private String username;
    private String password;
    //private String email;
    private java.sql.Timestamp lastlogin;

    public Long getUser_id() {return user_id;}

    public void setUser_id(long user_id) { this.user_id = user_id;}

    public String getUsername() {
        return username;
    }

    //public String getEmail() { return email;}

    public String getPassword() {
        return password;
    }

    public java.sql.Timestamp getLastlogin() {
        return lastlogin;
    }

   // public void setEmail(String email) {
   //     this.email = email;
   // }

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
