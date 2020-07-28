package main.java.service;

import java.time.Month;
import main.java.domain.BankTransaction;
import main.java.filter.BankTransactionFilter;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

  @Override
  public boolean test(BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
  }
}
