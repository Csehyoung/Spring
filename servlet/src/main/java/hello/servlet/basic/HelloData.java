package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

//lombok의 기능, 우리가 흔히 알고있는 getter, setter가 자동으로 포함되어있다.
@Getter @Setter
public class HelloData {
    String username;
    String age;
}
