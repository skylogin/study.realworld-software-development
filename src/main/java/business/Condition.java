package main.java.business;

@FunctionalInterface
public interface Condition {
  boolean evaluate(Facts facts);
}
