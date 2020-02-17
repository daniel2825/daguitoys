package co.com.inventory.services;

import co.com.daguiModel.Models.Products;

public interface IGetProductsServices {
  Products getInventory();

  Products getInventory2();

  int getSum(int input1, int input2);
}
