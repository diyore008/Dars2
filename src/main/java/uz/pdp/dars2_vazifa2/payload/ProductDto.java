package uz.pdp.dars2_vazifa2.payload;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private double price;
    private Integer infoId;
    private Integer photoId; //Attachment id
    private Integer categoryId;
}
