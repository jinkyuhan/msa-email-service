import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dbshema.properties")
public class TableNameConfig {

  @Value("${table.mail.name}")
  public final static String mailTable;

  @Value("${table.account.name}")
  public final static String accountTable;
}