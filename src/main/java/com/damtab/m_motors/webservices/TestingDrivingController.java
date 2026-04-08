package com.damtab.m_motors.webservices;

import com.damtab.m_motors.pojo.TestingDriving;
import com.damtab.m_motors.services.TestingDrivingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_TESTINGDRIVING)
public class TestingDrivingController {

    @Autowired
    private TestingDrivingService testingDrivingService;

    @GetMapping
    public ResponseEntity<Object> getAllTestingDriving() {
        List<TestingDriving> myListTestingDriving = testingDrivingService.getAllTestingDriving();
        return ResponseEntity.status(HttpStatus.OK).body(myListTestingDriving);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getTestingDrivingById(@PathVariable Long id) {
        TestingDriving myTestDrive = testingDrivingService.getTestDrivingById(id);
        return myTestDrive == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myTestDrive);
    }

    @PostMapping
    public ResponseEntity<Object> createTestingDriving(@RequestBody TestingDriving myTestDrive) {
        testingDrivingService.createTestDriving(myTestDrive);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteTestingDrivingById(@PathVariable Long id) {
        Boolean toDelete = testingDrivingService.deleteTestDriving(id);
        return toDelete ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateTestingDriving(@PathVariable Long id, @RequestBody TestingDriving newTestDrive) {
        testingDrivingService.updateTestDriving(id, newTestDrive);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
