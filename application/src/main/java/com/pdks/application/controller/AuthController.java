package com.pdks.application.controller;

import com.pdks.application.model.DefaultUserDetails;
import com.pdks.application.security.JwtResponse;
import com.pdks.application.security.LoginRequest;
import com.pdks.common.data.model.User;
import com.pdks.common.data.model.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api")
public class AuthController extends BaseController {

    @PostConstruct
    private void asd() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword(encoder.encode("1234"));
        user.setEmail("asd@asd.com");
        user.setFirstName("A");
        user.setLastName("B");
        user.setRoles(new HashSet<>(Arrays.asList(UserRole.ADMIN, UserRole.USER)));
        userService.save(user);
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<JwtResponse> signIn(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        DefaultUserDetails userDetails = (DefaultUserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUser().getId().getId(),
                userDetails.getUsername(),
                userDetails.getUser().getEmail(),
                roles));
    }
}
