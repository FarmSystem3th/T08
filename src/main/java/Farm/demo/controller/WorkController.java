package Farm.demo.controller;


import Farm.demo.domain.Work;
import Farm.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/works")
public class WorkController {

    @Autowired
    private WorkService workService;

    @GetMapping
    public List<Work> getAllWorks() {
        return workService.getAllWorks();
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
