package co.com.daguiModel.Models;

import lombok.*;
import lombok.Builder;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Products {
    public int idProduct;
    public String nameProduct;
    public int amount;
    public Prices objectPrice;

}

