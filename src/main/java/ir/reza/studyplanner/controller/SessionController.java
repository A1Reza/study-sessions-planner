package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.model.StudySession;
import ir.reza.studyplanner.service.StudySessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    private final StudySessionService studySessionService;

    public SessionController(StudySessionService studySessionService) {
        this.studySessionService = studySessionService;
    }

    @GetMapping
    public String findAll(Model model) {

        model.addAttribute(
                "sessions",
                studySessionService.findAll()
        );

        return "session-list";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-session";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam Long id, Model model) { /* /sessions/detail?id=1 */

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
}