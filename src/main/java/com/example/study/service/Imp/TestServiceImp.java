package com.example.study.service.Imp;

import com.example.study.entity.Test;
import com.example.study.mapper.TestMapper;
import com.example.study.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImp implements TestService {

    @Autowired
    public TestMapper testMapper;

    @Override
    public List<Test> findall() {
        List<Test> l =testMapper.findall();
        return l;
    }
}
