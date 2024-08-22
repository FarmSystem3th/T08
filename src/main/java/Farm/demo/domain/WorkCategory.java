package Farm.demo.domain;


import lombok.Getter;

@Getter
public enum WorkCategory {
    // 카테고리 정보, 취미 ,집안일 , 돌봄
    HOUSEHOLD("집안일"),
    HOBBY("취미"),
    CARE("돌봄"),
    INFORMATION("정보");


    private final String name;

    WorkCategory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }



}
