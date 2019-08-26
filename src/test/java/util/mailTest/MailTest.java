package util.mailTest;

import org.junit.Test;
import util.SendEmailByVVY;

import javax.mail.MessagingException;

/**
 * 工具类邮件测试
 */
public class MailTest {

    @Test
    public void mailTest() throws MessagingException {
        SendEmailByVVY.sendEmail("1170313408@qq.com","test");
    }

}
