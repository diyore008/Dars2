package uz.pdp.dars2_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.pdp.dars2_vazifa2.entity.Info;
import uz.pdp.dars2_vazifa2.projection.CustomInfo;

@RepositoryRestResource(collectionResourceRel = "list", path = "info", excerptProjection = CustomInfo.class)
public interface InfoRepository extends JpaRepository<Info, Integer> {
}
