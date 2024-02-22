package com.musical.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musical.project.Entity.Role;
import com.musical.project.Repository.RoleRepository;

@Service
public class RoleService {
      
	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		return roleRepository.save(role);
		
	}
}
