package bs.springframework.petclinic.bootstrap;

import bs.springframework.petclinic.model.*;
import bs.springframework.petclinic.services.OwnerService;
import bs.springframework.petclinic.services.PetTypeService;
import bs.springframework.petclinic.services.SpecialtyService;
import bs.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);


        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Thor");
        owner1.setLastName("Ragnarok");
        owner1.setAddress("Yggdrasil 500 ct.");
        owner1.setCity("Otherworld");
        owner1.setTelephone("0123456789");

        Pet thorsPet = new Pet();
        thorsPet.setPetType(savedDogPetType);
        thorsPet.setOwner(owner1);
        thorsPet.setBirthDate(LocalDate.now());
        thorsPet.setName("Diablo");
        owner1.getPets().add(thorsPet);


        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Saggot");
        owner1.setAddress("Berkeley 1200 st");
        owner1.setCity("Joshua 500 st.");
        owner1.setTelephone("3333333333");

        Pet bobsPet = new Pet();
        bobsPet.setPetType(savedCatPetType);
        bobsPet.setOwner(owner2);
        bobsPet.setBirthDate(LocalDate.now());
        bobsPet.setName("Christopher");
        owner2.getPets().add(bobsPet);


        Owner owner3 = new Owner();
        owner3.setFirstName("Marilyn");
        owner3.setLastName("Manson");
        owner3.setAddress("Hollywood 123 st.");
        owner3.setCity("LA");
        owner3.setTelephone("2222222222");

        Pet marilynsPet = new Pet();
        marilynsPet.setPetType(savedDogPetType);
        marilynsPet.setOwner(owner3);
        marilynsPet.setBirthDate(LocalDate.now());
        marilynsPet.setName("Bobbie Brown");
        owner3.getPets().add(marilynsPet);

        Pet marilynsCat = new Pet();
        marilynsCat.setPetType(savedCatPetType);
        marilynsCat.setOwner(owner3);
        marilynsCat.setBirthDate(LocalDate.now());
        marilynsCat.setName("Jose");
        owner3.getPets().add(marilynsCat);


        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        System.out.println("Loading Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Adam");
        vet1.setLastName("Sandler");
        vet1.getSpecialties().add(radiology);

        Vet vet2 = new Vet();
        vet2.setFirstName("Will");
        vet2.setLastName("Ferrell");
        vet2.getSpecialties().add(surgery);

        Vet vet3 = new Vet();
        vet3.setFirstName("John");
        vet3.setLastName("Reilly");
        vet3.getSpecialties().add(dentistry);

        vetService.save(vet1);
        vetService.save(vet2);
        vetService.save(vet3);

        System.out.println("Loading Vet");
    }
}
