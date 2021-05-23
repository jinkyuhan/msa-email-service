import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dbshema.properties")
public class TableNameConfig {

  @Value("${table.mail.name}")
  String mailTable;

  @Value("${table.account.name}")
  String accountTable;
}