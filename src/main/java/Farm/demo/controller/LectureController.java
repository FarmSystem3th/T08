package Farm.demo.controller;

import Farm.demo.domain.Lecture;
import Farm.demo.service.LectureService;
import jdk.jfr.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {

    @Autowired
    private LectureService lectureService;



    @GetMapping
    public List<LectureDto> getAllLectures() {
        List<Lecture> lectures = lectureService.getAllLectures();
        List<LectureDto> lectureDtos = lectures.stream()
                .map(o -> new LectureDto(o))
                .collect(toList());
        return lectureDtos;
    }

    //location, reward 없애기. -- 수정 작업 중 , 엔티티를  dto로 변환하기
    //id name dateTime location category detail
    @Data
    @Getter @Setter
    public class LectureDto {
        //
        private Integer lectureId;
        private String name;
        private String description;
        private String date_time;

        // 엔티티 ->dto
        LectureDto(Lecture lecture){
            this.lectureId = lecture.getId();
            this.name = lecture.getName();
            this.description = lecture.getDetail();
            this.date_time = lecture.getDateTime();
        }

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
