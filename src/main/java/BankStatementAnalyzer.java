package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import main.java.domain.BankTransaction;
import main.java.domain.SummaryStatistics;
import main.java.parser.BankStatementParser;
import main.java.parser.Exporter;
import main.java.service.BankTransactionIsInFebruaryAndExpensive;
import main.java.service.BankTransactionProcessor;

public class BankStatementAnalyzer {

  private static final String RESOURCES = "src/main/resources/";

  public void analyze(final String fileName, final BankStatementParser bankStatementParser, final
      Exporter exporter) throws IOException{
    final Path path = Paths.get(RESOURCES + fileName);
    final List<String> lines = Files.readAllLines(path);

    final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    final BankTransactionProcessor bankTransactionProcessor = new BankTransactionProcessor(bankTransactions);

    final SummaryStatistics summaryStatistics = bankTransactionProcessor.summarizeTransactions();

    System.out.println(exporter.export(summaryStatistics));
  }





}