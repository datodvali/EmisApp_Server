package com.freeuniproject.emisapp.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emis/api/dashboard")
public class DashboardController {

    @GetMapping("/pages")
    public List<String> getViewablePages() {
        return List.of("SubjectCard", "SubjectRegistration", "Library");
    }

}
