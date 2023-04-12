package uz.pdp.dars2_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars2_vazifa2.entity.Currency;

@Projection(types = Currency.class)
public interface CustomCurrency {
    Integer getId();
    String getName();
}
