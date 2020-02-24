package co.com.inventory.consumer;

public interface IOperation {
  int sum(int a, int b);

  int rest(int a, int b);

  void saveLogSum(final String log);
}
