package main.java.atm.service;

import java.time.Month;
import main.java.atm.domain.BankTransaction;
import main.java.atm.filter.BankTransactionFilter;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {

  @Override
  public boolean test(BankTransaction bankTransaction) {
    return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
  }
}
