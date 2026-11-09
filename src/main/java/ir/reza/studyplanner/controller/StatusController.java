package ir.reza.studyplanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public ResponseEntity<String> status() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("X-Planner-Version", "1.0")
                .body("Study Sessions Planner is running!");
    }
}