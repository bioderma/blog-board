package com.example.blogboard.service;

import com.example.blogboard.model.RoleType;
import com.example.blogboard.model.Users;
import com.example.blogboard.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	@Transactional(readOnly = true)
	public Users findMember(String username) {
		Users user = userRepository.findByUsername(username).orElseGet(()->{
			return new Users();
		});
		return user;
	}

	
	@Transactional
	public void joinMember(Users user) {

		String rawPassword = user.getPassword();//해쉬전 패스워드
		String encPassword = encoder.encode(rawPassword);//해쉬패스워드
		user.setPassword(encPassword);//패스워드에 해쉬패스워드 장착
		userRepository.save(user);
		user.setRole(RoleType.USER);
	}
	
	@Transactional
	public void updateMember(Users user) {
		Users persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원찾기  실패");
				
		});
		
		
		//validate 체크 = oauth필드에 값이 없으면 정보수정가능
		if(persistance.getOauth() == null || persistance.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
			persistance.setEmail(user.getEmail());
		}
		
	
		
		
	}
	
	

}
