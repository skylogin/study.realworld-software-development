package main.java.atm.parser;

import main.java.atm.domain.SummaryStatistics;

public class XmlExporter implements Exporter{

  @Override
  public String export(SummaryStatistics summaryStatistics) {
    String result = "<data>";
    result += "<sum>" + summaryStatistics.getSum() + "</sum>";
    result += "<average>" + summaryStatistics.getAverage() + "</average>";
    result += "<max>" + summaryStatistics.getMax() + "</max>";
    result += "<min>" + summaryStatistics.getMin() + "</min>";
    result += "</data>";
    return result;
  }
}
