package main.java.business;

@FunctionalInterface
public interface Action {
  void execute(Facts facts);
}
