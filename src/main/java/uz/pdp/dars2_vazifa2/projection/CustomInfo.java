package uz.pdp.dars2_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars2_vazifa2.entity.Info;

@Projection(types = Info.class)
public interface CustomInfo {
    Integer getId();
    String getName();
    String getInfo();
}
