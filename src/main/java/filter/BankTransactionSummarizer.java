package main.java.filter;

import main.java.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer{
  double summarize(double accumulator, BankTransaction bankTransaction);
}
