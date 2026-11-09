package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.service.StudySessionService;
import ir.reza.studyplanner.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final StudySessionService studySessionService;
    private final SubjectService subjectService;

    public HomeController(
            StudySessionService studySessionService,
            SubjectService subjectService) {
        this.studySessionService = studySessionService;
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public String home(Model model) {

        List<StudySession> sessions = studySessionService.findAll();

        model.addAttribute("sessions", sessions);
        model.addAttribute("subjects", subjectService.findAll());

        int totalMinutes = sessions.stream()
                .mapToInt(StudySession::getMinutes)
                .sum();

        model.addAttribute("totalMinutes", totalMinutes);

        return "index";
    }
}