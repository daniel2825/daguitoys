package co.com.inventory.services;

import co.com.daguiModel.Models.Benefits;
import co.com.daguiModel.Models.Prices;
import co.com.daguiModel.Models.Products;
import co.com.inventory.consumer.IOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GetProductsServices implements IGetProductsServices {
  private final IOperation operation;
  Logger logger = Logger.getLogger("GetProductsServices.class");

  @Autowired
  public GetProductsServices(final IOperation operation) {
    this.operation = operation;
  }

  @Override
  public Products getInventory() {
    /*Conexion a la base de datos aws*/
    final Products products = new Products();
    products.amount = 3;
    products.idProduct = 2;
    products.nameProduct = "Martillo";
    products.objectPrice = new Prices();
    products.objectPrice.price = 5266;
    products.objectPrice.benefits = new Benefits();
    products.objectPrice.benefits.benefits = 50;
    final int imp = products.objectPrice.benefits.benefits;
    products.objectPrice.benefits.description = "beneficio descuento del " + imp + "% aplicado";
    this.clientNew("Si");
    return products;
  }

  public void clientNew(String s) {
    s = "Si";
    String discount = "";
    final String reportFinal;
    if (s.equals("Si")) {
      discount = "obtiene un 20% en compras si referencia a un amigo y realiza una compra";
    } else {
      discount = "obtiene un 50% en compras si referencia 3 amigos y estos realizan una compra";
    }
    reportFinal = discount;
    this.logger.info(reportFinal);
  }

  @Override
  public Products getInventory2() {

    final int benefits = 50;
    this.clientNew("Si");
    return Products.builder()
        .amount(3)
        .idProduct(2)
        .nameProduct("Martillo")
        .objectPrice(
            Prices.builder()
                .price(5266)
                .benefits(
                    Benefits.builder()
                        .benefits(benefits)
                        .description("beneficio descuento del " + benefits + "aplicado")
                        .build())
                .build())
        .build();
  }

  @Override
  public int getSum(final int input1, final int input2) {
    final String log = "Saved sum";
    this.operation.saveLogSum(log);
    return this.operation.sum(input1, input2);
  }
}
