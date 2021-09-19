package com.sda.onlineAuction.service;

import com.sda.onlineAuction.dto.UserDto;
import com.sda.onlineAuction.mapper.UserMapper;
import com.sda.onlineAuction.model.User;
import com.sda.onlineAuction.model.UserRole;
import com.sda.onlineAuction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public void add(UserDto userDto) {

        // Pasul 1: sa obtinem un user pe baza userDto
        User user = userMapper.map(userDto);

        // Pasul 2: sa salvam un user in baza de date cu ajutorul UserRepository
        userRepository.save(user);
    }
}
