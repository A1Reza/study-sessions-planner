package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.dto.request.StudySessionRequestDto;
import ir.reza.studyplanner.dto.response.StudySessionResponseDto;
import ir.reza.studyplanner.service.StudySessionService;
import ir.reza.studyplanner.service.SubjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String showAddForm(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "add-session";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model) {

        StudySessionResponseDto session = studySessionService.findById(id);

        if (session == null) {
            return "redirect:/sessions";
        }

        model.addAttribute("session", session);
        return "session-detail";
    }

    @PostMapping("/save")
    public String add(
            @Valid @ModelAttribute("session") StudySessionRequestDto dto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("subjects", subjectService.findAll());
            return "add-session";
        }

        studySessionService.add(dto);

        return "redirect:/sessions";
    }
}