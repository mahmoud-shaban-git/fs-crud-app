package com.springprogramming.crud_app.controller;

import com.springprogramming.crud_app.exception.UserNotFoundException;
import com.springprogramming.crud_app.model.Benutzer;
import com.springprogramming.crud_app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/user")
    Benutzer neuBenutzer (@RequestBody Benutzer neuBenutzer)
    {
        return userRepo.save(neuBenutzer);
    }

    @GetMapping("/users")
    public List<Benutzer> getAllUsers ()
    {
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Benutzer getUserById(@PathVariable Long id)
    {
        return userRepo.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id)
    {
         if (!userRepo.existsById(id))
         {
             throw new UserNotFoundException(id);
         }
         userRepo.deleteById(id);

         return "Benutzer mit dieser ID:" + id + "wurde erfolgreich gelöst";
    }

    @PutMapping("/user/{id}")
    public Benutzer updateUser(@RequestBody Benutzer newUser ,@PathVariable Long id)
    {
      return userRepo.findById(id).map(user -> {
          user.setUsername(newUser.getUsername());
          user.setName(newUser.getName());
          user.setEmail(newUser.getEmail());
          return userRepo.save(user);
      }).orElseThrow(() -> new UserNotFoundException(id));

}
}
