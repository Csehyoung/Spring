package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {

        log.info("helloBasic");
        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {

        log.info("mappingGetV1");
        return "OK";
    }

    /**
     * 편리한 축약 애노테이션
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     * @return
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {

        log.info("mappingGetV2");
        return "OK";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     *
     * /mapping/csehyoung
     * URL에 {userID} 형태로 해놓으면 PathVariable을 통해 해당 데이터를 꺼내 쓸 수 있다.
     * 최근에는 리소스 경로에 식별자를 넣는 스타일을 선호한다.
     * 사용 하는 변수명이 템플릿의 이름과 같으면 축약하여 선언이 가능하다. ex) mappingPath(@PathVariable String userId)
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {

        log.info("mappingPath userid = {}", data);
        return "OK";
    }

    /**
     * @PathVariable 다중사용
     *
     *
     * @return
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {

        log.info("mappingPath userID = {}, orderId = {}", userId, orderId);
        return "OK";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     *
     * 해당 파라미터 정보가 있어야 호출이 가능하다. 밑에 예제는 ?mode=debug가 포함되어 있어야 실행이 됨.
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     *
     * 해당 헤더 정보가 있어야 호출이 가능하다. 밑에 예제는 헤더에 key : mode, value : debug 라는 정보가 들어있어야 호출이 된다.
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     *
     * 헤더의 Content Type이 application/json 일때 실행됨. (요청헤더의 Content Type)
     * 밑의 예제는 consumes = application/json과 동일.
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     *
     * 헤더의 Accept가 text/html이어야 호출됨. (요청헤더의 Accept)
     * 아래 예제는 produces = text/html과 같음.
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
