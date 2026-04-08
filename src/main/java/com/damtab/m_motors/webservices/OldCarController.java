package com.damtab.m_motors.webservices;

import com.damtab.m_motors.pojo.OldCar;
import com.damtab.m_motors.services.OldCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_OLDCAR)
public class OldCarController {

    @Autowired
    private OldCarService oldCarService;

    @GetMapping
    public ResponseEntity<Object> getAllOldCar() {
        List<OldCar> myListOldCar = oldCarService.getAllOldCars();
        return ResponseEntity.status(HttpStatus.OK).body(myListOldCar);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getOldCarById(@PathVariable Long id) {
        Optional<OldCar> myOldCar = oldCarService.getOldCarById(id);
        return myOldCar == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myOldCar);
    }

    @PostMapping
    public ResponseEntity<Object> createOldCar(@RequestBody OldCar myOldCar) {
        oldCarService.createOldCar(myOldCar);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteOldCarById(@PathVariable Long id) {
        Boolean toDelete = oldCarService.deleteOldCarById(id);
        return toDelete ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateOldCar(@PathVariable Long id, @RequestBody OldCar newOldCar) {
        oldCarService.updateOldCar(id, newOldCar);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
