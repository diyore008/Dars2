package uz.pdp.dars2_vazifa2.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.dars2_vazifa2.entity.User;

@Projection(types = User.class)
public interface CustomUser {
    Integer getId();
    String getUsername();
    String getPhoneNumber();
}
