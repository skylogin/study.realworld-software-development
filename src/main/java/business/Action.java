package main.java.business;

@FunctionalInterface
public interface Action {
  void perform(Facts facts);
}
