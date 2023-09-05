package com.freeuniproject.emisapp.api;

import com.freeuniproject.emisapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/emis/api/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/upload/profilePicture")
    public ResponseEntity<byte[]> uploadProfilePicture(@RequestBody MultipartFile image) {
//        studentService.saveProfilePicture(image.getBytes())
        return null;
    }

    @PutMapping("/update/phoneNumber")
    public boolean updatePhoneNumber(@RequestParam Long id, @RequestParam String phoneNumber) {
        userService.updatePhoneNumber(id, phoneNumber);
        return true;
    }

    @PutMapping("/update/password")
    public boolean updatePassword(@RequestParam Long id, @RequestParam String password) {
        userService.updatePassword(id, password);
        return true;
    }


}
