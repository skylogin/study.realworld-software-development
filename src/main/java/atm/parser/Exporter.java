package main.java.atm.parser;

import main.java.atm.domain.SummaryStatistics;

public interface Exporter {
  String export(SummaryStatistics summaryStatistics);
}
