package main.java.parser;

import main.java.domain.SummaryStatistics;

public interface Exporter {
  String export(SummaryStatistics summaryStatistics);
}
