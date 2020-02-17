package services;

import co.com.daguiModel.Models.Benefits;
import co.com.daguiModel.Models.Prices;
import co.com.daguiModel.Models.Products;
import co.com.inventory.consumer.IOperation;
import co.com.inventory.services.GetProductsServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetProductsServicesTest {

  private GetProductsServices getproductservices;
  @Mock private IOperation operation;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
    this.getproductservices = new GetProductsServices(this.operation);
  }

  @Test
  public void Getproductservices2Test() {

    final Products getProductsClass = this.getproductservices.getInventory2();

    Assert.assertNotNull(getProductsClass);
    Assert.assertEquals(this.buildGetproducts2().idProduct, getProductsClass.idProduct);
  }

  @Test
  public void TestAdd() {
    // Setup
    final int a = 10;
    final int b = 11;
    Mockito.when(this.operation.sum(Mockito.anyInt(), Mockito.anyInt())).thenReturn(21);
    doNothing().when(this.operation).saveLogSum(Mockito.anyString());
    // Execution
    final int resultado = this.getproductservices.getSum(a, b);
    // Assertion
    Assert.assertEquals(21, resultado);
    verify(this.operation, times(1)).saveLogSum(Mockito.anyString());
  }

  @Test
  public void Getproductservices3Test() {

    final Products getProductsClass = this.getproductservices.getInventory();

    Assert.assertNotNull(getProductsClass);
    Assert.assertEquals(
        this.buildGetproducts3().objectPrice.getBenefits().benefits,
        getProductsClass.objectPrice.getBenefits().benefits);
  }
  /*
  @Test
  public void clientNewTest(){

      doNothing().when(this.getproductservices).clientNew(any());
      getproductservices.clientNew("Si");
      verify(getproductservices,times(1)).clientNew("Si");

  }*/

  public Products buildGetproducts2() {
    final int benefits = 50;
    final Products productsExpected =
        Products.builder()
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
    return productsExpected;
  }

  public Products buildGetproducts3() {
    /*Conexion a la base de datos aws*/
    final Products productsExpected = new Products();
    productsExpected.amount = 3;
    productsExpected.idProduct = 2;
    productsExpected.nameProduct = "Martillo";
    productsExpected.objectPrice = new Prices();
    productsExpected.objectPrice.price = 5266;
    productsExpected.objectPrice.benefits = new Benefits();
    productsExpected.objectPrice.benefits.benefits = 50;
    final int imp = productsExpected.objectPrice.benefits.benefits;
    productsExpected.objectPrice.benefits.description =
        "beneficio descuento del " + imp + "% aplicado";

    return productsExpected;
  }
}
