package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}

