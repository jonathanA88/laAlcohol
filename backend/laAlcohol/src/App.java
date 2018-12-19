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

    public long login(Login login){
        long user_id = 0;


        // check if username/email and password exist in account table,
        // 1.a if it does, get the user_id
        // 2. set the lastlogin column in account table
        // 3. return the user_id

        // 1.b If it does not exist,  throw login failed

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
            pstmt.executeQuery();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
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


}



