import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        //app.connect();

        Account account = new Account();
        account.setUsername("jonathan");
        account.setEmail("jona.anders@gmail.com");
        account.setPassword("laalcohol");
        account.setLastlogin(getCurrentTimeStamp());

        // what id is returned when a new user is created?
        long id = app.createAccount(account);
        System.out.println(id);
        //createAccount(new Account)

        //test login
        Account login = new Account();
        login.setUsername("jonathan");
        login.setPassword("laalcohol");
        try {
            long user_id = app.login(login);
            System.out.println(user_id);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }

    }


     private static java.sql.Timestamp getCurrentTimeStamp() {

         java.util.Date today = new java.util.Date();
         return new java.sql.Timestamp(today.getTime());

     }
}


