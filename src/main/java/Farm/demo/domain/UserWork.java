package Farm.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class UserWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id", nullable = false)
    private Work work;


    // 추가 정보 필요하면 작성
    /*@Column
    private LocalDate participationDate;

    @Column(length = 20)
    private String status;
*/
    // Getters and Setters
}
