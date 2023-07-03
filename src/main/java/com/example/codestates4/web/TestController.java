package com.example.codestates4.web;

import com.example.codestates4.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/latest")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    // 우리는 아직 초보자이니까..
    // post-man이라는 프로그램을 설치해서 프로젝트 실행하고(RUN)
    // 설치한 프로그램으로 기능이 잘 동작하는지 테스트 해보자.

    // Create
    @PostMapping("/test")
    // http://localhost:8080/api/latest/test
    public ResponseEntity<String> create(@RequestBody Map<String, String> map) {
        // val1
        // val2
        System.out.println("map.get(\"id\") = " + map.get("id"));
        System.out.println("map.get(\"name\") = " + map.get("name"));
        System.out.println("map.get(\"grade\") = " + map.get("grade"));

        testService.joinTest(map);

        return ResponseEntity.ok("CREATED!");
    }

    // Read - 단건 조회
    @GetMapping("/test/{id}")
    // http://localhost:8080/api/latest/test/{id}
    public ResponseEntity<String> read(@PathVariable Long id) {
        System.out.println("id = " + id);

        testService.findTestById(id);

        return ResponseEntity.ok("Hello world KNU");
    }

    // Update
    @PutMapping("/test/{id}")
    // http://localhost:8080/api/latest/test/{id}
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Map<String, String> map) {
        System.out.println("id = " + id);
        System.out.println("map.get(\"val1\") = " + map.get("val1"));
        System.out.println("map.get(\"val1\") = " + map.get("val2"));

        testService.updateTestById(id, map);

        return null;
    }

    // Delete
    @DeleteMapping("/test/{id}")
    // http://localhost:8080/api/latest/test/{id}
    public ResponseEntity<String> delete(@PathVariable Long id) {
        System.out.println("id = " + id);

        testService.deleteTestById(id);

        return ResponseEntity.ok("DELETED!");
    }
}
