package main.java.atm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import main.java.atm.domain.BankTransaction;
import main.java.atm.domain.SummaryStatistics;
import main.java.atm.parser.BankStatementParser;
import main.java.atm.parser.Exporter;
import main.java.atm.service.BankTransactionProcessor;

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