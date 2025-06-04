package com.api.crud.controllers;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public String saveUser(@ModelAttribute UserModel user, RedirectAttributes redirectAttributes) {
        if (userService.emailExists(user.getEmail())) {
            redirectAttributes.addFlashAttribute("message", "Usuario ya registrado con ese email");
            return "redirect:/#crear";
        }
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "Usuario registrado con éxito");
        return "redirect:/#crear";
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable ("id") Long id){
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "User with id " + id + " deleted";
        }else {
            return "Error, we have a problem";
        }
    }
}