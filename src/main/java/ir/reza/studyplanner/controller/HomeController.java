package ir.reza.studyplanner.controller;

import ir.reza.studyplanner.dto.response.StudySessionResponseDto;
import ir.reza.studyplanner.dto.response.SubjectResponseDto;
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

        List<StudySessionResponseDto> sessions =
                studySessionService.findAll();

        List<SubjectResponseDto> subjects =
                subjectService.findAll();

        int totalMinutes = sessions.stream()
                .mapToInt(StudySessionResponseDto::minutes)
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