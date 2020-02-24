package co.com.inventory.consumer;

import org.springframework.stereotype.Component;

@Component
public class Operation implements IOperation {
  @Override
  public int rest(final int input1, final int input2) {
    return input1 - input2;
  }

  @Override
  public int sum(final int input1, final int input2) {
    return input1 + input2;
  }

  @Override
  public void saveLogSum(final String log) {
    System.out.println("Saved" + log);
  }
}
