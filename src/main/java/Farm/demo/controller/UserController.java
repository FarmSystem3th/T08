package Farm.demo.controller;

import Farm.demo.domain.User;
import Farm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {



    // 엔티티로 받은 모든 것들을 dto로 받는 작업을 해야함.
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User updatedUser) {
        Optional<User> userOptional = userService.getUserById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }

}
