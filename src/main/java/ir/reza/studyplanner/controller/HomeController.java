package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.model.Subject;
import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.service.SubjectService;
import ir.reza.studyplanner.service.StudySessionService;
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

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<StudySession> sessions = studySessionService.findAll();

        List<Subject> subjects = subjectService.findAll();

        int totalMinutes = sessions.stream()
                .mapToInt(StudySession::getMinutes)
                .sum();

        model.addAttribute("sessions", sessions);
        model.addAttribute("subjects", subjects);
        model.addAttribute("totalMinutes", totalMinutes);

        System.out.println("Sessions: " + sessions.size());
        System.out.println("Subjects: " + subjects.size());
        System.out.println("Total Minutes: " + totalMinutes);

        return "forward:/index.jsp";
    }
}