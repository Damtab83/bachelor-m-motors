package com.damtab.m_motors.services;

import com.damtab.m_motors.pojo.TestingDriving;
import com.damtab.m_motors.repository.TestingDrivingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TestingDrivingService {

    @Autowired
    private TestingDrivingRepository testingDrivingRepository;

    public List<TestingDriving> getAllTestingDriving() { return testingDrivingRepository.findAll();}

    public TestingDriving getTestDrivingById(long id) {return testingDrivingRepository.findById(id).orElse(null);}

    public void createTestDriving(TestingDriving myTestDriving) {testingDrivingRepository.save(myTestDriving);}

    public Boolean deleteTestDriving(Long id) {
        Boolean toDelete = testingDrivingRepository.existsById(id);
        if(toDelete) {
            testingDrivingRepository.deleteById(id);
        }
        return toDelete;
    }

    public void updateTestDriving(Long id, TestingDriving newTestDriving) {
        TestingDriving oldTestDriving = this.getTestDrivingById(id);
        if(oldTestDriving != null) {
            oldTestDriving.setTestDate(newTestDriving.getTestDate());
            oldTestDriving.setConfirmed(newTestDriving.getConfirmed());
            testingDrivingRepository.save(oldTestDriving);
        }
    }
}
