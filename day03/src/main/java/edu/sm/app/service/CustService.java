package edu.sm.app.service;

import edu.sm.app.dto.CustDto;
import edu.sm.app.frame.SMService;
import edu.sm.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustService implements SMService<String, CustDto> {

    final CustRepository custRepository;

    @Override
    public void add(CustDto custDto) throws Exception {
        System.out.println(custDto);
        custRepository.insert(custDto);
    }

    @Override
    public void modify(CustDto custDto) throws Exception {
        custRepository.update(custDto);
    }

    @Override
    public void del(String s) throws Exception {
        custRepository.delete(s);
    }

    @Override
    public CustDto get(String s) throws Exception {
        return custRepository.selectOne(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return custRepository.select();
    }
}