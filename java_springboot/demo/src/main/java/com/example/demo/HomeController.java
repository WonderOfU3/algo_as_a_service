package com.example.demo;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
//@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public String home(@RequestBody() MyBody body) {
        String sort_order = body.getSort_order();
        List<Integer> values = body.getValues();
        if (!sort_order.equals("asc") && !sort_order.equals("desc")) {
            return "Sort order is incorrect";
        }
        if (values.isEmpty()) {
            return "List is empty";
        }
        Collections.sort(values);
        if (sort_order.equals("desc")) {
            Collections.reverse(values);
        }
        return sort_order + ": " + values;
    }
    /*public String home(@RequestBody() String json) {
        JSONObject obj = new JSONObject(json);
        String sort_order = obj.get("sort_order").toString();
        Object values = obj.get("values");
        return "Hello "+ sort_order + " " + values;
    }*/

    /*@GetMapping("/{name}")
    public String home(@PathVariable String name, @RequestParam(value = "titi", required = false, defaultValue = "pppp") String toto) {
        return "Hello, "+name+"!" + toto;
    }*/
}
