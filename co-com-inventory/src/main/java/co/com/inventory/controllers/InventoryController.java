package co.com.inventory.controllers;

import co.com.daguiModel.Models.Products;
import co.com.inventory.services.IGetProductsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    private final IGetProductsServices productsServices;

    @Autowired
    public InventoryController(IGetProductsServices productsServices){
        this.productsServices = productsServices;
    }

    @GetMapping(value = "/get/inventory")
    @ResponseBody
    public ResponseEntity<Products> products(){

        final Products products =
                productsServices.getInventory2();

        final Products products2 =
                productsServices.getInventory();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
