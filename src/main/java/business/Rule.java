package main.java.business;

@FunctionalInterface
public interface Rule {
  void perform(Facts facts);
}
