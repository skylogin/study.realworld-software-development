package main.java;

import java.io.IOException;
import main.java.parser.BankStatementCSVParser;
import main.java.parser.BankStatementParser;

public class MainApplication {
  public static void main(final String[] args) throws IOException {

    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    bankStatementAnalyzer.analyze(args[0], bankStatementParser);

  }
}
