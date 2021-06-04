import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:table.name.properties")
public class TableNameConfig {

  @Value("${table.mail.name}")
  public static String mailTable;

  @Value("${table.account.name}")
  public static String accountTable;
}