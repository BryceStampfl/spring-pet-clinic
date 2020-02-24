package bs.springframework.petclinic.repositories;

import bs.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Vet, Long> {
}
