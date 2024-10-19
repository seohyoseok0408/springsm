package edu.sm.app.service;

import edu.sm.app.dto.CartDto;
import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.frame.SMService;
import edu.sm.app.repository.CartRepository;
import edu.sm.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService implements SMService<Integer, CartDto> {

    final CartRepository cartRepository;

    @Override
    public void add(CartDto cartDto) throws Exception {
        cartRepository.insert(cartDto);
    }

    @Override
    public void modify(CartDto cartDto) throws Exception {
        cartRepository.update(cartDto);
    }

    @Override
    public void del(Integer integer) throws Exception {
        cartRepository.delete(integer);
    }

    @Override
    public CartDto get(Integer integer) throws Exception {
        return cartRepository.selectOne(integer);
    }

    @Override
    public List<CartDto> get() throws Exception {
        return cartRepository.select();
    }
}
