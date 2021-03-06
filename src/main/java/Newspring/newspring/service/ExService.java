package Newspring.newspring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Newspring.newspring.auth.MyUserDetail;
import Newspring.newspring.entity.User;
import Newspring.newspring.repository.ExRepository;
import lombok.RequiredArgsConstructor;

@Service
@Slf4j

public class ExService implements UserDetailsService {
    private final ExRepository repository;

    public ExService(ExRepository repository){
        this.repository = repository;
    }
    @Transactional
    public void joinUser(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername());
        user.setUserId(user.getUserId());
        user.setEmail(user.getEmail());
        user.setPhoneNumber(user.getPhoneNumber());

        repository.saveUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(email);
        //여기서 받은 유저 패스워드와 비교하여 로그인 인증
        User user = repository.findUserByEmail(email);
        return new MyUserDetail(user);
    }
}