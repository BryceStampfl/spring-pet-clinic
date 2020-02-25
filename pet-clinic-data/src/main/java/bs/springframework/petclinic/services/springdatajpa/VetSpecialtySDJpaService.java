package bs.springframework.petclinic.services.springdatajpa;

import bs.springframework.petclinic.model.Specialty;
import bs.springframework.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class VetSpecialtySDJpaService implements SpecialtyService {

    private SpecialtyService specialtyService;

    public VetSpecialtySDJpaService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyService.findById(aLong);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyService.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyService.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyService.deleteById(aLong);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyService.findAll().forEach(specialties::add);
        return specialties;
    }
}
