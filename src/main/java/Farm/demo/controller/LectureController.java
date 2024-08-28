package Farm.demo.controller;

import Farm.demo.domain.Lecture;
import Farm.demo.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("/{lectureId}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable int lectureId) {
        Optional<Lecture> lecture = lectureService.getLectureById(lectureId);
        return lecture.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lecture createLecture(@RequestBody Lecture lecture) {
        return lectureService.createLecture(lecture);
    }
}
