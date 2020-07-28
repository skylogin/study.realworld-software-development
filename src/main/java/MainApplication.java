package main.java;

import java.io.IOException;
import main.java.parser.BankStatementCSVParser;
import main.java.parser.BankStatementParser;
import main.java.parser.Exporter;
import main.java.parser.HtmlExporter;
import main.java.parser.XmlExporter;

public class MainApplication {
  public static void main(final String[] args) throws IOException {

    final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
    final BankStatementParser bankStatementParser = new BankStatementCSVParser();
    final Exporter exporter = new HtmlExporter();

    bankStatementAnalyzer.analyze(args[0], bankStatementParser, exporter);

  }
}
