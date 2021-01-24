import java.io.IOException;
//import javax.mail;
import javax.mail.*;

public class MainClass {
    public static void main(String[] args) throws IOException, MessagingException {

    GmailClient gmailClient = new GmailClient();
    gmailClient.findEmailBySubject("Example for test");

    }

}
