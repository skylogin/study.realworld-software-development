package main.java.atm.parser;

import java.util.List;
import main.java.atm.domain.BankTransaction;

public interface BankStatementParser {
  BankTransaction parseFrom(String line);
  List<BankTransaction> parseLinesFrom(List<String> lines);
}
