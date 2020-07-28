package main.java.atm;

import java.io.IOException;
import main.java.atm.parser.BankStatementCSVParser;
import main.java.atm.parser.BankStatementParser;
import main.java.atm.parser.Exporter;
import main.java.atm.parser.HtmlExporter;

public class ATMApplication {
  public static void main(final String[] args) throws IOException {

    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    final Exporter exporter = new HtmlExporter();

    bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter);

  }
}
