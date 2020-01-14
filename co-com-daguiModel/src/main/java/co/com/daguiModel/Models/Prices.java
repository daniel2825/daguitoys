package co.com.daguiModel.Models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prices {
    public String idPrices;
    public Benefits benefits;
    public float price;
}
