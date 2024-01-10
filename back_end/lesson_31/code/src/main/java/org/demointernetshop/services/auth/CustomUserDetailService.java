package org.demointernetshop.services.auth;

import lombok.RequiredArgsConstructor;
import org.demointernetshop.repository.UserRepository;
import org.demointernetshop.services.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByName method");
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found with name: " + username));
    }
}
