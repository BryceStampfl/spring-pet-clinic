package bs.springframework.petclinic.services;

import bs.springframework.petclinic.model.Owner;


/**
 *
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
