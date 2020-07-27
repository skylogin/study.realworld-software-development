package test.java.parser;

import java.time.LocalDate;
import java.time.Month;
import main.java.domain.BankTransaction;
import main.java.parser.BankStatementCSVParser;
import main.java.parser.BankStatementParser;
import org.junit.Assert;
import org.junit.Test;

public class BankStatementCSVParserTest {
  private final BankStatementParser statementParser = new BankStatementCSVParser();

  @Test
  public void shouldParseOneCorrectLine() throws Exception{
    // given
    final String line = "30-01-2017,-50,Tesco";

    // when
    final BankTransaction result = statementParser.parseFrom(line);
    final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
    final double tolerance = 0.0d;

    // then
    Assert.assertEquals(expected.getDate(), result.getDate());
    Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
    Assert.assertEquals(expected.getDescription(), result.getDescription());
  }
}
