package main.java.atm.filter;

import main.java.atm.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer{
  double summarize(double accumulator, BankTransaction bankTransaction);
}
