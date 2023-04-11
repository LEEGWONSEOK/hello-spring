package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")    // hello URI에 Get 메서드 요청
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  // key: data, value: hello!!
        return "hello"; // templates에 있는 html 이름과 동일한 파일을 찾습니다
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    // 여기서 그냥 localhost:8080/hello-mvc 하면 에러가 발생!
    // 이유는? WARN 보면 name이 없다고 뜹니다
    // localhost:8080/hello-mvc?name=?? 형태로 작성해야 합니다

    @GetMapping("hello-mvc2")
    public String helloMvc2(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    // @RequestParam 의 2번째 인자값으로 default로 'required=true' 입니다
    // false로 변경하고 localhost:8080/hello-mvc2 가 잘 나옵니다


    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }
    // 위와 동일하게 적용되는 것을 확인할 수 있음
    // 데이터(문자열)를 그대로 내려주는 방식임
    // 이 방식은 쓸일이 거의 없음

    // API 방식
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    // 객체가 JSON 형태로 응답함
}



