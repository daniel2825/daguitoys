package controllers;

import co.com.daguiModel.Models.Benefits;
import co.com.daguiModel.Models.Prices;
import co.com.daguiModel.Models.Products;
import co.com.inventory.controllers.InventoryController;
import co.com.inventory.services.IGetProductsServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class InventoryControllerTest {

    @InjectMocks
    InventoryController inventoryController;

    @Mock
    private IGetProductsServices productsServices;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void productsTest(){

       final ResponseEntity<Products> responseProduct = inventoryController.products();

        Assert.assertEquals(HttpStatus.OK,responseProduct.getStatusCode());
    }

}
