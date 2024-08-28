package Farm.demo.service;

import Farm.demo.domain.Work;
import Farm.demo.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkService {

    @Autowired
    private WorkRepository workRepository;

    public List<Work> getAllWorks() {
        return workRepository.findAll();
    }

    public Optional<Work> getWorkById(int workId) {
        return workRepository.findById(workId);
    }

    public Work createWork(Work work) {
        return workRepository.save(work);
    }
}
