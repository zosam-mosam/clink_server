package com.josam.clink.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.josam.clink.user.UserMapper;
import com.josam.clink.user.User_MasterVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Service
@Log
@RequiredArgsConstructor
public class APIUserDetailsService implements UserDetailsService {
	
//	private final APIUserRepository apiUserRepository;
	private final UserMapper usermapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<APIUser> result = apiUserRepository.findById(username);
		User_MasterVO result = usermapper.findById(username);
		
//		User_MasterVO apiUser = result.orElseThrow(()->new UsernameNotFoundException("회원이 존재하지 않습니다."));
		
		log.info("APIUserDetailsService");
		APIUserDTO dto = new APIUserDTO(result.getUser_id(), result.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
		log.info(dto.toString());
		return dto;
	}
}
