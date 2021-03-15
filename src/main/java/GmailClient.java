import javax.mail.*;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GmailClient {
    public void findEmailBySubject(String subject) throws MessagingException, IOException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(new File("\\src\\main\\resources\\smtp.properties")));

            Session session = Session.getDefaultInstance(props, null);

            Store store = session.getStore("imaps");
            //connect
            store.connect("smtp.gmail.com", "eldadco1234@gmail.com", "Aa1321!!");
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            //get the num of messages that the inbox contains
            int messageCount = inbox.getMessageCount();

            System.out.println("The inbox contains " + messageCount + " messages");
            //Get list of all messages from the inbox
            Message[] messages = inbox.getMessages();
            System.out.println("------------------------------");
            for (Message message : messages) {
                if (message.getSubject().contains(subject)) {
                    System.out.println("Requested mail was found : The mail subject is : " + message.getSubject() + "\n" + "The mail was sent in : " + message.getReceivedDate());
                    break;
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
