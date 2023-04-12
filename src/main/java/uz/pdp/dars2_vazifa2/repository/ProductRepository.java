package uz.pdp.dars2_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dars2_vazifa2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
