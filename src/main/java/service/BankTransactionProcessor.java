package main.java.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import main.java.domain.BankTransaction;
import main.java.domain.SummaryStatistics;
import main.java.filter.BankTransactionFilter;
import main.java.filter.BankTransactionSummarizer;


public class BankTransactionProcessor {

  private final List<BankTransaction> bankTransactions;

  public BankTransactionProcessor(List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }


  public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter){
    final List<BankTransaction> result = new ArrayList<BankTransaction>();
    for(final BankTransaction bankTransaction : bankTransactions){
      if(bankTransactionFilter.test(bankTransaction)){
        result.add(bankTransaction);
      }
    }
    return result;
  }

  public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount){
    return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
  }


  public SummaryStatistics summarizeTransactions() {
    final DoubleSummaryStatistics doubleSummaryStatistics = bankTransactions.stream()
        .mapToDouble(BankTransaction::getAmount)
        .summaryStatistics();

    return new SummaryStatistics(doubleSummaryStatistics.getSum(),
        doubleSummaryStatistics.getMax(),
        doubleSummaryStatistics.getMin(),
        doubleSummaryStatistics.getAverage());
  }

  public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer){
    double result = 0d;
    for(final BankTransaction bankTransaction : bankTransactions){
      result += bankTransactionSummarizer.summarize(result, bankTransaction);
    }
    return result;
  }

  public double calculateTotalAmount(){
    return summarizeTransactions((acc, bankTransaction) -> acc+bankTransaction.getAmount());
  }

  public double calculateTotalInMonth(final Month month){
    return summarizeTransactions((acc, bankTransaction) -> bankTransaction.getDate().getMonth() == month? acc+bankTransaction.getAmount(): acc);
  }

  public double calculateTotalForCategory(final String category){
    return summarizeTransactions((acc, bankTransaction) -> bankTransaction.getDescription().equals(category)? acc+bankTransaction.getAmount(): acc);
  }

  public double calculateMaximum(LocalDate date) {
    double max = 0d;
    double current = 0d;
    for(final BankTransaction bankTransaction : bankTransactions){
      if(bankTransaction.getDate().equals(date)){
        current = bankTransaction.getAmount();

        if(current > max){
          max = current;
        }
      }
    }

    return max;
  }

  public double calculateMinimum(LocalDate date) {
    double min = 0d;
    double current = 0d;

    for(final BankTransaction bankTransaction : bankTransactions){
      if(bankTransaction.getDate().equals(date)){
        current = bankTransaction.getAmount();
        if(current < min){
          min = current;
        }
      }
    }

    return min;
  }
}
