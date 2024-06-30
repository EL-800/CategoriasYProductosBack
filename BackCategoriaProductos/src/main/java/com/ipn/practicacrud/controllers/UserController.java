package com.ipn.practicacrud.controllers;

import com.ipn.practicacrud.models.User;
import com.ipn.practicacrud.services.EmailService;
import com.ipn.practicacrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;
    @GetMapping("/prueba")
    public void sendEmail(){
        emailService.pruebaEmail();
    }

    @GetMapping("{id}")
    public ResponseEntity<User>GetUserById(@PathVariable int id){
        var user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> AddUser(@RequestBody User user){
        var userCreated = userService.RegisterUser(user);
        emailService.sendEmail(user.getEmail(),"Registro","Te has registrado de manera correcta");
        return new ResponseEntity<User>(user,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> UpdateUseer(@RequestBody User user, @PathVariable int id){
        var userUpdated = userService.updateUser(id,user);
        if(userUpdated == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        else
            return new ResponseEntity<User>(userUpdated,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteUser(@PathVariable int id){
        String email = userService.getUserById(id).getEmail();
        boolean isUserDeleted = userService.deleteUser(id);
        if(isUserDeleted) {
            var responde = new ResponseEntity<>("Registro eliminado correctamente", HttpStatusCode.valueOf(204));
            emailService.sendEmail(email,"Eliminado","Has borrado tu cuenta");
            return responde;
        }
        else
            return new ResponseEntity<>("Registro no fue eliminado",HttpStatus.NOT_FOUND);
    }
}
