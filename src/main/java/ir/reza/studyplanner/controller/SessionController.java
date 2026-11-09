package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.service.StudySessionService;
import ir.reza.studyplanner.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final StudySessionService studySessionService;
    private final SubjectService subjectService;

    public SessionController(
            StudySessionService studySessionService,
            SubjectService subjectService) {

        this.studySessionService = studySessionService;
        this.subjectService = subjectService;
    }

    @GetMapping
    public String findAll(Model model) {

        model.addAttribute("sessions", studySessionService.findAll());
        model.addAttribute("subjects", subjectService.findAll());

        return "session-list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-session";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam Long id, Model model) {

        StudySession session = studySessionService.findById(id);

        if (session == null) {
            return "redirect:/sessions";
        }

        model.addAttribute("session", session);

        return "session-detail";
    }

    @PostMapping("/save")
    public String add(
            @RequestParam Long subjectId,
            @RequestParam int minutes,
            @RequestParam String notes) {

        StudySession session = new StudySession(
                null,
                subjectId,
                minutes,
                notes
        );

        studySessionService.add(session);

        return "redirect:/sessions";
    }

    @GetMapping("/home")
    public String home(Model model) {

        List<StudySession> sessions = studySessionService.findAll();

        model.addAttribute("sessions", sessions);
        model.addAttribute("subjects", subjectService.findAll());

        int totalMinutes = sessions.stream()
                .mapToInt(StudySession::getMinutes)
                .sum();

        model.addAttribute("totalMinutes", totalMinutes);

        return "redirect:/";
    }
}