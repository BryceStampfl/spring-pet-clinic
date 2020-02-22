package bs.springframework.petclinic.bootstrap;

import bs.springframework.petclinic.model.Owner;
import bs.springframework.petclinic.model.PetType;
import bs.springframework.petclinic.model.Vet;
import bs.springframework.petclinic.services.OwnerService;
import bs.springframework.petclinic.services.PetTypeService;
import bs.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);




        Owner owner1 = new Owner();
        owner1.setFirstName("Thor");
        owner1.setLastName("Ragnarok");

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Saggot");

        Owner owner3 = new Owner();
        owner3.setFirstName("Marilyn");
        owner3.setLastName("Manson");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Adam");
        vet1.setLastName("Sandler");

        Vet vet2 = new Vet();
        vet2.setFirstName("Will");
        vet2.setLastName("Ferrell");

        Vet vet3 = new Vet();
        vet3.setFirstName("John");
        vet3.setLastName("Reilly");

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Loading Vet");


    }
}
