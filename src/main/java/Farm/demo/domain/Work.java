package Farm.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false, length = 45)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private WorkCategory category;

    @Column(length = 500)
    private String detail;

    @Column
    private Integer reward;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private Set<UserWork> userWorks;

}
