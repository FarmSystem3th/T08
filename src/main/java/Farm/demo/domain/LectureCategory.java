package Farm.demo.domain;


import lombok.Getter;

@Getter
public enum LectureCategory {
    //건강, 경영 , 취미 ,it
    HEALTH("건강"),
    MANAGEMENT("경영"),
    HOBBY("취미"),
    IT("IT");

    private final String name;

    LectureCategory(String name) {
        this.name = name;
    }

}
