package blog.example.blog.service;

import blog.example.blog.model.RoleType;
import blog.example.blog.model.User;
import blog.example.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encode;

    @Transactional(readOnly = true)
    public User 회원찾기(String username){
        User user = userRepository.findByUsername(username)
                .orElseGet(()-> new User());
        return user;
    }


    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword(); //비밀번호 원문
        String encPassword = encode.encode(rawPassword); //해쉬로 바꿈
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional
    public void 회원수정(User user){
        User persistence = userRepository.findById(Math.toIntExact(user.getId())).orElseThrow(() -> new IllegalArgumentException("회원 찾기 실패"));
        if( persistence.getOauth() == null || persistence.getOauth().equals("")) {
            String rawPassword = user.getPassword();
            String encPassword = encode.encode(rawPassword);
            persistence.setPassword(encPassword);
            persistence.setEmail(user.getEmail());
        }


    }

}
