package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import main.java.domain.BankTransaction;
import main.java.parser.BankStatementParser;
import main.java.service.BankTransactionIsInFebruaryAndExpensive;
import main.java.service.BankTransactionProcessor;

public class BankStatementAnalyzer {

  private static final String RESOURCES = "src/main/resources/";

  public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException{
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    final BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);

    collectSummary(bankTransactionProcessor);
  }

  private static void collectSummary(final BankTransactionProcessor bankTransactionProcessor){
    System.out.println("The total for all transactions is " + bankTransactionProcessor.calculateTotalAmount());
    System.out.println("The total for transactions in January " + bankTransactionProcessor.calculateTotalInMonth(Month.JANUARY));
    System.out.println("The total for transactions in FEBRUARY " + bankTransactionProcessor.calculateTotalInMonth(Month.FEBRUARY));
    System.out.println("The total salary received is " + bankTransactionProcessor.calculateTotalForCategory("Salary"));

    System.out.println("Maximum transaction in 02/02 " + bankTransactionProcessor
        .calculateMaximum(LocalDate.of(2017, Month.FEBRUARY, 2)));
    System.out.println("Minimum transaction in 02/02 " + bankTransactionProcessor
        .calculateMinimum(LocalDate.of(2017, Month.FEBRUARY, 2)));

    final List<BankTransaction> someTransaction = bankTransactionProcessor.findTransactions(new BankTransactionIsInFebruaryAndExpensive());
    final List<BankTransaction> sameTransaction = bankTransactionProcessor.findTransactions(
        bankTransaction -> bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000);

  }





}