package blog.example.blog.service;

import blog.example.blog.model.RoleType;
import blog.example.blog.model.User;
import blog.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword(); //비밀번호 원문
        String encPassword = encode.encode(rawPassword); //해쉬로 바꿈
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

}
