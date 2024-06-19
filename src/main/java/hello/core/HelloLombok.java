package hello.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@RequiredArgsConstructor // final이 붙은 필드를 모아서 생성자를 자동으로 만들어준다.
@ToString
public class HelloLombok {
//    private final String name;
//    private final int age;

    private String name;
    private int age;

    public static void main(String[] args) {
        // HelloLombok helloLombok = new HelloLombok("쌈뽕", 25);
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("쌈뽕코딩");
        String name = helloLombok.getName();

        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
