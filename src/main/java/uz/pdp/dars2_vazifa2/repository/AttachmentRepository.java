package uz.pdp.dars2_vazifa2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.dars2_vazifa2.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
