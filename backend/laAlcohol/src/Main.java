import javax.security.auth.login.LoginException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        //app.connect();


        //Test 1
        /*
        Account account = new Account();
        account.setUsername("jonathan");
        account.setEmail("jona.anders@gmail.com");
        account.setPassword("laalcohol");
        account.setLastlogin(getCurrentTimeStamp());

        // what id is returned when a new user is created?
        long id = app.createAccount(account);
        System.out.println(id);
        */


        /*
        //Test 2
        Account login = new Account();
        login.setUsername("jonathan");
        login.setPassword("laalcohol");
        try {
            long user_id = app.login(login);
            System.out.println(user_id);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
        */

        /*
        //Test 3
        Account login2 = new Account();
        login2.setUsername("jonathan");
        login2.setPassword("wrongpassword");
        try {
            long user_id = app.login(login2);
            System.out.println(user_id);
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
        */

        //Test 3
        // Create a birthdate for test
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "1988-02-16";
        Date dateObject = null;
        try {
            dateObject = sdf.parse(dateString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        java.sql.Date sqlDate = new java.sql.Date(dateObject.getTime());

        PersonInfo personinfo = new PersonInfo();
        //id ska vara det id vi får från test 1
        personinfo.setUser_id(1);
        personinfo.setName("Jonathan Andersson");
        personinfo.setBirthday(sqlDate);
        personinfo.setWeight((float) 82.5);
        personinfo.setHeight((float) 183);
        app.updatePersonInfo(personinfo);

    }


     private static java.sql.Timestamp getCurrentTimeStamp() {

         java.util.Date today = new java.util.Date();
         return new java.sql.Timestamp(today.getTime());

     }
}


