import javax.security.auth.login.LoginException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    private final String url = "jdbc:postgresql://localhost/laalcohol";
    private final String user = "postgres";
    private final String password = "Lingon20";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public long login(Account account) throws LoginException{
        long user_id = 0;
        String SQL = "SELECT user_id "
                + "FROM account "
                + "WHERE username = ? AND "
                + "password = ?";

        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)){
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    user_id = rs.getLong(1);
                } else {
                    // Va där best practice här? Hur returnar jag long när det går bra och
                    // invalid login om det går dåligt?
                    throw new LoginException("Invalid username or password");

                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user_id;
    }

    public Account getAccount(long user_id) {
        String SQL = "SELECT user_id,username, password, email "
                + "FROM account "
                + "WHERE user_id = ?";

        Account account = new Account();

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setLong(1, user_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {

                    account.setUser_id(rs.getLong(1));
                    account.setUsername(rs.getString(2));
                    account.setPassword(rs.getString(3));
                    account.setEmail(rs.getString(4));
                    account.setLastlogin(rs.getTimestamp(5));
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return account;
    }

    /*
        create an account
     */
    public long createAccount(Account account){
        String SQL = "INSERT INTO account(username, password, email, last_login) "
                + "VALUES(?,?,?,?)";

        long id = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)){

            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getEmail());
            pstmt.setTimestamp(4, account.getLastlogin());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }


    public long updatePersonInfo(PersonInfo personinfo) {
        String SQL = "WITH new_values (user_id, email, name, birthday, weight, height) AS ("
                + "VALUES (?, ?, ?, ?, ? ,?)"
                + "),"
                + "upsert AS ("
                + "UPDATE person_info pi "
                + "SET user_id = nv.user_id,"
                + "email = nv.email,"
                + "name = nv.name,"
                + "birthday = nv.birthday,"
                + "weight = nv.weight,"
                + "height = nv.height "
                + "FROM new_values nv "
                + "WHERE pi.user_id = nv.user_id "
                + "RETURNING pi.*"
                + ")"
                + "INSERT INTO person_info (user_id, email, name, birthday, weight, height) "
                + "SELECT user_id, email, name, birthday, weight, height "
                + "FROM new_values "
                + "WHERE NOT EXISTS "
                + "(SELECT 1 "
                + "FROM upsert up "
                + "WHERE up.user_id = new_values.user_id)";

        long id = 0;
        System.out.println(SQL);

        return id;
    }

}



