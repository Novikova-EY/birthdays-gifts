package ru.novikova.birthdaysGifts.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.gift.Gift;
import ru.novikova.birthdaysGifts.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    private ResponseEntity<?> createNewUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

    @GetMapping
    private List<Gift> getStartPage() {
        return userService.findAllGifts();
    }
}
