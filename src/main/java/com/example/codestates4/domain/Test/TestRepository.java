package com.example.codestates4.domain.Test;

import com.example.codestates4.domain.member.Member;

import java.util.Map;

public interface TestRepository {

    // C
    void save(Map<String, String> map);

    // R
    Member findById(Long id);

    // U
    void updateById(Long id, Map<String, String> map);

    // D
    void deleteById(Long id);
}
