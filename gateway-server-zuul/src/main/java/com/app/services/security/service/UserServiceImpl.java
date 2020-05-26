package com.app.services.security.service;

import com.app.services.model.User;
import com.app.services.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(this.passwordEncoder().encode(user.getPassword()));
        user.setEnabled(true);
        user.setCreateDate(new Date());
        user.setLastPasswordResetDate(new Date());
        userRepository.saveAndFlush(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
