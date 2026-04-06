package com.damtab.m_motors.services;

import com.damtab.m_motors.pojo.ImageCar;
import com.damtab.m_motors.repository.ImageCarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ImageCarService {

    @Autowired
    private ImageCarRepository imageCarRepository;

    public List<ImageCar> getAllImageCar() {return imageCarRepository.findAll();}

    public ImageCar getImageCarById(long id) {return imageCarRepository.findById(id).orElse(null);}

    public void createImageCar(ImageCar myImageCar) {imageCarRepository.save(myImageCar);}

    public Boolean deleteImageCar(Long id) {
        Boolean toDelete = imageCarRepository.existsById(id);
        if(toDelete) {
            imageCarRepository.deleteById(id);
        }
        return toDelete;
    }

    public void updateImageCar(long id, ImageCar newImageCar) {
        ImageCar oldImageCar = this.getImageCarById(id);
        if(oldImageCar != null) {
            oldImageCar.setName(newImageCar.getName());
            oldImageCar.setSize(newImageCar.getSize());
            imageCarRepository.save(oldImageCar);
        }
    }
}
