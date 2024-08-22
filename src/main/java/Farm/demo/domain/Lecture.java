package Farm.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String time;

    @Column(length = 25)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private LectureCategory category;

    @Column(length = 500)
    private String detail;

    @Column
    private Integer reward;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private Set<UserLecture> userLectures;

    // Getters and Setters
}
