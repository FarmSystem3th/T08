package Farm.demo.domain;


import lombok.Getter;

@Getter
public enum Sex {
    MALE("M"),
    FEMALE("F");

    private final String value;

    Sex(String value) {
        this.value = value;
    }

    //


}
