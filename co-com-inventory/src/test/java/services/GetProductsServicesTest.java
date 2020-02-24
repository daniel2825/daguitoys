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

import java.util.ArrayList;
import java.util.List;

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
  public void TestRest() {
    // Setup
    final String a = "10";
    final String b = "11";
    Mockito.when(this.operation.rest(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
    doNothing().when(this.operation).saveLogSum(Mockito.anyString());
    // Execution
    final int resultado = this.getproductservices.getRest(a, b);
    // Assertion
    Assert.assertEquals(1, resultado);
    verify(this.operation, times(1)).saveLogSum(Mockito.anyString());
  }

  @Test(expected = NullPointerException.class)
  public void TestRestException() {
    // Setup
    final String a = "10";
    final String b = "11";
    Mockito.when(this.operation.rest(Mockito.anyInt(), Mockito.anyInt())).thenReturn(1);
    doNothing().when(this.operation).saveLogSum(Mockito.anyString());
    doThrow(new SecurityException("TEst")).when(this.operation).rest(Mockito.anyInt(), anyInt());
    /* Mockito.when(this.operation.rest(Mockito.anyInt(), Mockito.anyInt()))
    .thenThrow(new NullPointerException("TEst"));*/
    // Execution
    final int resultado = this.getproductservices.getRest(a, b);
    Mockito.spy(this.getproductservices.getRest(a, b));
    // Assertion
    Assert.assertEquals(1, resultado);
    verify(this.getproductservices, times(1)).getRest(Mockito.anyString(), Mockito.anyString());
    verify(this.operation, times(1)).saveLogSum(Mockito.anyString());
  }

  @Test
  public void whenSpyingOnList_thenCorrect() {
    final List<String> list = new ArrayList<String>();
    final List<String> spyList = Mockito.spy(list);

    spyList.add("one");
    spyList.add("two");

    Mockito.verify(spyList).add("one");
    Mockito.verify(spyList).add("two");

    Assert.assertEquals(2, spyList.size());
  }

  @Test
  public void whenSpyingOnList_thenInCorrect() {
    final List<String> list = new ArrayList<String>();

    list.add("one");
    list.add("two");

    Mockito.verify(list).add("one");
    Mockito.verify(list).add("two");

    Assert.assertEquals(2, list.size());
  }

  @Test
  public void Getproductservices3Test() {

    final Products getProductsClass = this.getproductservices.getInventory();

    Assert.assertNotNull(getProductsClass);
    Assert.assertEquals(
        this.buildGetproducts3().objectPrice.getBenefits().benefits,
        getProductsClass.objectPrice.getBenefits().benefits);
  }

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
