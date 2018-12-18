 public class Main {
    public static void main(String[] args) {

        App app = new App();
        //app.connect();

        Account account = new Account();
        account.setUsername("jonathan");
        account.setEmail("jona.anders@gmail.com");
        account.setPassword("laalcohol");
        account.setLastlogin(getCurrentTimeStamp());

        app.createAccount(account);
        //createAccount(new Account)
    }


     private static java.sql.Timestamp getCurrentTimeStamp() {

         java.util.Date today = new java.util.Date();
         return new java.sql.Timestamp(today.getTime());

     }
}


