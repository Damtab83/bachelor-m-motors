package com.damtab.m_motors.webservices;

import com.damtab.m_motors.pojo.User;
import com.damtab.m_motors.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRegistration.REST_API + ApiRegistration.REST_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        List<User> myListUser = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(myListUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getuserById(@PathVariable Long id) {
        User myUser = userService.getuserById(id);
        return myUser == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.status(HttpStatus.OK).body(myUser);
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User myUser) {
        userService.createUser(myUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
        Boolean toDelete = userService.deleteUserById(id);
        return toDelete ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User newUser) {
        userService.updateUser(id, newUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
