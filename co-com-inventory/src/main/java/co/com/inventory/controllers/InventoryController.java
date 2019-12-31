package co.com.inventory.controllers;

import co.com.daguiModel.Models.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("{ $daguitoys.base.enpoint }")
public class InventoryController {

    @GetMapping(value = "/get/inventory")
    @ResponseBody
    public ResponseEntity<Products> products(){
        /*Conexion a la base de datos aws*/
        Products products = new Products();
        products.cantidad = 3;
        products.idProducto = 2;
        products.nombreProducto = "Martillo";

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
