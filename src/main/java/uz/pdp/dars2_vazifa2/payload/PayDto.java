package uz.pdp.dars2_vazifa2.payload;

import lombok.Data;

@Data
public class PayDto {
    private double summa;
    private Integer userId;
    private Integer currencyId;
    private Integer basketId;
}
