import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dbshema.properties")
public class TableNameConfig {

  @Value("${table.mail.name}")
<<<<<<< HEAD
  public static String mailTable;

  @Value("${table.account.name}")
  public static String accountTable;
=======
  public final static String mailTable;

  @Value("${table.account.name}")
  public final static String accountTable;
>>>>>>> b6392a8f459b5f1778a26f5f31822f0486a20d27
}