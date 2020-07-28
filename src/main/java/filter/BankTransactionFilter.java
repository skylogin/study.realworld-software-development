package main.java.filter;

import main.java.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
  boolean test(BankTransaction bankTransaction);
}
