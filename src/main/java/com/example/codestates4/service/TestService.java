package com.example.codestates4.service;

import com.example.codestates4.domain.member.Member;

import java.util.Map;

public interface TestService {

    // 테스트 생성 - C
    void joinTest(Map<String, String> map);

    // 테스트 단건 조회 - R
    Member findTestById(Long id);

    // 테스트 수정 - U
    void updateTestById(Long id, Map<String, String> map);

    // 테스트 삭제 - D
    void deleteTestById(Long id);

}
