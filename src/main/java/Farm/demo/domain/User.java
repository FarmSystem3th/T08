package Farm.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    private String userName;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(length = 14)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(length = 1)
    private Sex sex;

    @Column(length = 50)
    private String address;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 1000)
    private String careers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserWork> userWorks;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserLecture> userLectures;

    // Getters and Setters
}
