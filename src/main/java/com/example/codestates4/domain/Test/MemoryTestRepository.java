package com.example.codestates4.domain.Test;

import com.example.codestates4.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTestRepository implements TestRepository {

    private final List<Member> collectors = new ArrayList<>();

    // Create
    @Override
    public void save(Map<String, String> map) {

        Member member = new Member();

        member.setId(Long.parseLong(map.get("id")));
        member.setName(map.get("name"));
        member.setGrade(map.get("grade"));

        collectors.add(member);

        // 에러가 나는 원인은.. 맵은 String으로 선언되어 있는데,
        // 리턴타입은 Long이므로.. 리턴타입과 타입이 맞지 않아서 에러가 난다.
        // String val1 "1"값을 Long으로 반환하여 넘겨준다.
    }

    // Read
    @Override
    public Member findById(Long id) {

        return collectors.stream().filter(member -> Long.toString(id).equals(member.getId())).findAny().orElse(null);
    }

    // Update
    @Override
    public void updateById(Long id, Map<String, String> map) {
        findById(id).setGrade(map.get("name"));
        findById(id).setGrade(map.get("grade"));
    }

    // Delete
    @Override
    public void deleteById(Long id) {

        collectors.remove(findById(id));

    }
}
