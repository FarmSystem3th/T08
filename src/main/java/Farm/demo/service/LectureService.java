package Farm.demo.service;

import Farm.demo.domain.Lecture;
import Farm.demo.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Optional<Lecture> getLectureById(int lectureId) {
        return lectureRepository.findById(lectureId);
    }

    public Lecture createLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }
}
