package com.dhiraj.AdminController;

import com.dhiraj.model.Admin;
import com.dhiraj.model.Twit;
import com.dhiraj.model.User;
import com.dhiraj.repository.AdminRepository;
import com.dhiraj.repository.TwitRepository;
import com.dhiraj.repository.UserRepository;
import com.dhiraj.service.TwitService;
import com.dhiraj.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {

    private final AdminRepository adminRepository;

    private final UserRepository userRepository;
    private final TwitService twitService;
    private final UserService userService;
    private final TwitRepository twitRepository;

    public AdminController(AdminRepository adminRepository, UserRepository userRepository, TwitService twitService, UserService userService, TwitRepository twitRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.twitService = twitService;
        this.userService = userService;
        this.twitRepository = twitRepository;
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getAllUsersCount")
    public long getAllUsersCount() {
        return userRepository.count();
    }


    @GetMapping("/getUser")
    public List<User> getUser(@RequestParam String query) {
        return userService.searchUser(query);
    }

    @DeleteMapping("/users/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        try {
            if (userRepository.existsById(userId)) {



                userRepository.deleteById(userId);
                return ResponseEntity.ok("User deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }


    @GetMapping("/admin")
    public Admin getAdmin(@RequestParam String username) {
        return adminRepository.findTopByUsername(username);
    }


    @GetMapping("/postcount")
    public Long gettweetcount() {
        return twitRepository.count();
    }

    @GetMapping ("/getAllAdmin")
    List<Admin> getall(){
        return adminRepository.findAll();
    }

    @GetMapping ("/getloc")
    List<Object> getallloc(){
        return  userRepository.findLocationCounts();
    }

    @PostMapping("/addadmin")
    public String addAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return "Admin added successfully";
    }

    @DeleteMapping("twit/{id}")
    public void deleteTweet(@PathVariable Long id) {
        twitRepository.deleteById(id);
    }



}
