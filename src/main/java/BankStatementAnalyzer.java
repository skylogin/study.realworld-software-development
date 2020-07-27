package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import main.java.domain.BankTransaction;
import main.java.parser.BankStatementCSVParser;
import main.java.parser.BankStatementParser;

public class BankStatementAnalyzer {

  private static final String RESOURCES = "src/main/resources/";

  public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException{
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

    collectSummary(bankStatementProcessor);
  }

  private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
    System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
    System.out.println("The total for transactions in January " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
    System.out.println("The total for transactions in FEBRUARY " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
    System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

    System.out.println("Maximum transaction in 02/02 " + bankStatementProcessor.calculateMaximum(LocalDate.of(2017, Month.FEBRUARY, 2)));
    System.out.println("Minimum transaction in 02/02 " + bankStatementProcessor.calculateMinimum(LocalDate.of(2017, Month.FEBRUARY, 2)));

  }





}