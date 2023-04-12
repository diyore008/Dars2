package uz.pdp.dars2_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.dars2_vazifa2.entity.Currency;
import uz.pdp.dars2_vazifa2.projection.CustomCurrency;

@RepositoryRestResource(collectionResourceRel = "list", path = "currency", excerptProjection = CustomCurrency.class)
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
