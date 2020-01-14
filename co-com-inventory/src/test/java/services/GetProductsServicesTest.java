package services;

import co.com.daguiModel.Models.Benefits;
import co.com.daguiModel.Models.Prices;
import co.com.daguiModel.Models.Products;
import co.com.inventory.services.GetProductsServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GetProductsServicesTest {

    private GetProductsServices getproductservices;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        getproductservices = new GetProductsServices();
    }

    @Test
    public void Getproductservices2Test(){

       final Products getProductsClass = getproductservices.getInventory2();

    Assert.assertNotNull(getProductsClass);
    Assert.assertEquals(buildGetproducts2().idProduct,getProductsClass.idProduct);

    }

    @Test
    public void Getproductservices3Test(){

        final Products getProductsClass = getproductservices.getInventory();

        Assert.assertNotNull(getProductsClass);
        Assert.assertEquals(buildGetproducts3().objectPrice.getBenefits().benefits,getProductsClass.objectPrice.getBenefits().benefits);
    }
/*
    @Test
    public void clientNewTest(){

        doNothing().when(this.getproductservices).clientNew(any());
        getproductservices.clientNew("Si");
        verify(getproductservices,times(1)).clientNew("Si");

    }*/

    public Products buildGetproducts2(){
        int benefits = 50;
        final Products productsExpected = Products.builder()
                .amount(3)
                .idProduct(2)
                .nameProduct("Martillo")
                .objectPrice(
                        Prices.builder()
                                .price(5266)
                                .benefits(
                                        Benefits.builder()
                                                .benefits(benefits)
                                                .description("beneficio descuento del "+ benefits + "aplicado")
                                                .build())
                                .build())
                .build();
        return productsExpected;
    }

    public Products buildGetproducts3(){
        /*Conexion a la base de datos aws*/
        Products productsExpected = new Products();
        productsExpected.amount = 3;
        productsExpected.idProduct = 2;
        productsExpected.nameProduct = "Martillo";
        productsExpected.objectPrice = new Prices();
        productsExpected.objectPrice.price = 5266;
        productsExpected.objectPrice.benefits = new Benefits();
        productsExpected.objectPrice.benefits.benefits = 50;
        int imp = productsExpected.objectPrice.benefits.benefits;
        productsExpected.objectPrice.benefits.description = "beneficio descuento del "+ imp +"% aplicado";

        return productsExpected;
    }

}
