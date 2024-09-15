package Farm.demo.controller;


import Farm.demo.domain.Work;
import Farm.demo.domain.WorkCategory;
import Farm.demo.service.WorkService;
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

@RestController()
@RequestMapping("api/works")
public class WorkController {

    @Autowired
    private WorkService workService;


    // 수정 작업 중
    @GetMapping
    public List<WorkDto> getAllWorks() {
        List<Work> works = workService.getAllWorks();
        List<WorkDto> result = works.stream()
                .map(o -> new WorkDto(o))
                .collect(toList());

        return result;
    }
    @Data
    public class WorkDto {
        private Integer workId;
        private String name;
        private WorkCategory category;
        private String date_time;

        WorkDto(Work work) {
            workId = work.getId();
            name = work.getName();
            category =  work.getCategory();
            date_time =  work.getDate_time();

        }



    }


    @GetMapping("/{workId}")
    public ResponseEntity<Work> getWorkById(@PathVariable int workId) {
        Optional<Work> work = workService.getWorkById(workId);
        return work.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Work createWork(@RequestBody Work work) {
        return workService.createWork(work);
    }
}



