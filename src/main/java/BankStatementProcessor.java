package main.java;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import main.java.domain.BankTransaction;


public class BankStatementProcessor {

  private final List<BankTransaction> bankTransactions;

  public BankStatementProcessor(List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  public double calculateTotalAmount(){
    double total = 0d;
    for(final BankTransaction bankTransaction : bankTransactions){
      total += bankTransaction.getAmount();
    }
    return total;
  }

  public double calculateTotalInMonth(final Month month){
    double total = 0d;
    for(final BankTransaction bankTransaction : bankTransactions){
      if(bankTransaction.getDate().getMonth() == month){
        total += bankTransaction.getAmount();
      }
    }
    return total;
  }

  public double calculateTotalForCategory(final String category){
    double total = 0d;
    for(final BankTransaction bankTransaction : bankTransactions){
      if(bankTransaction.getDescription().equals(category)){
        total += bankTransaction.getAmount();
      }
    }
    return total;
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
