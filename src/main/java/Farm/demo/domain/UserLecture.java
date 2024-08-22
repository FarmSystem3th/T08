package Farm.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class UserLecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false)
    private Lecture lecture;


    //추가 정보 작성
    /*@Column
    private LocalDate participationDate;

    @Column(length = 20)
    private String status;*/

    // Getters and Setters
}
