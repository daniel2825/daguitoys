package co.com.daguiModel.Models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Benefits {
    public String idBenefits;
    public int benefits;/*Porcentaje descuento*/
    public String description;
}
