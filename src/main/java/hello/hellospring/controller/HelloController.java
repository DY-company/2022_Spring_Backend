package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") /* get메소드  */
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; /* hello 를 찾아서 hello.html을 랜더링 하라는 의미 */
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name")String name, Model model){
        model.addAttribute("name", name);

        return "hello-telmplate";
    }
    @GetMapping("hello-string")
    @ResponseBody          //html을 http에서 header와 body값이 있는데 body 부분의 데이터를 직접 데이터를 넣어 주겠다
    public String helloString(@RequestParam("name")String name){
        return "hello" + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }

    static class Hello{
        private String name; //private 은 외부에서 꺼낼수 없음

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
