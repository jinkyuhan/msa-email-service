
/**
 * @author jinkyuhan
 * @version 1.0.0 21/03/27
 * @see MailRepository
 */
import java.util.List;

import com.jk.msa.email.entity.Mail;
import com.jk.msa.email.repository.MailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired
  MailRepository mailRepository;

  public Mail[] getAllMails() {
    List<Mail> mails = mailRepository.findAll();
    return mails.toArray(new Mail[mails.size()]);
  }

}