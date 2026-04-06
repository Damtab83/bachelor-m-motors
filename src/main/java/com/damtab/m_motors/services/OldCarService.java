package com.damtab.m_motors.services;

import com.damtab.m_motors.pojo.OldCar;
import com.damtab.m_motors.repository.OldCarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OldCarService {

    @Autowired
    private OldCarRepository oldCarRepository;

    public List<OldCar> getAllOldCars() {
        return oldCarRepository.findAll();
    }

    public Optional<OldCar> getOldCarById(Long id) {
        return oldCarRepository.findById(id);
    }

    public void createOldCar(OldCar myOldCar) {
        oldCarRepository.save(myOldCar);
    }

    public Boolean deleteOldCarById(Long id) {
        Boolean toDelete = oldCarRepository.existsById(id);
        if (toDelete) {
            oldCarRepository.deleteById(id);
        }
        return toDelete;
    }

    public void updateOldCar(Long id, OldCar newOldCar) {
        OldCar oldCarExisting = this.getOldCarById(id)
                .orElseThrow(()-> new RuntimeException("OldCar not found"));
        if(oldCarExisting != null) {
            oldCarExisting.setBrand(newOldCar.getBrand());
            oldCarExisting.setPrice(newOldCar.getPrice());
            oldCarRepository.save(oldCarExisting);
        }
    }
}
