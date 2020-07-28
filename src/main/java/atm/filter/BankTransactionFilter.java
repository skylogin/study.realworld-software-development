package main.java.atm.filter;

import main.java.atm.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
  boolean test(BankTransaction bankTransaction);
}
