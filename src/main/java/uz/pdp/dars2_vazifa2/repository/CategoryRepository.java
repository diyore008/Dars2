package uz.pdp.dars2_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dars2_vazifa2.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
