package Farm.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
public class Lecture {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    // localDate 삭제 -String 으로 통합
   /* @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String time;*/
    @Column(nullable=false)
    private String dateTime;

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
