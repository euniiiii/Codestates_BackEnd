package com.example.codestates4.service;

import com.example.codestates4.domain.Test.MemoryTestRepository;
import com.example.codestates4.domain.Test.TestRepository;
import com.example.codestates4.domain.member.Member;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServiceImpl implements TestService{

    private final TestRepository testRepository;

//    public TestServiceImpl(MemoryTestRepository memoryTestRepository) {
//        this.testRepository = memoryTestRepository;
//    }

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    // Create
    @Override
    public void joinTest(Map<String, String> map) {
        testRepository.save(map);
    }

    // Read
    @Override
    public Member findTestById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void updateTestById(Long id, Map<String, String> map) {
        testRepository.updateById(id, map);
    }

    // Delete
    @Override
    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
    }
}
