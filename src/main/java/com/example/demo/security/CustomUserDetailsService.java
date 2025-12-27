
// package com.example.demo.security;

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {
    
//     private final UserAccountRepository userAccountRepository;
    
//     public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
//         this.userAccountRepository = userAccountRepository;
//     }
    
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         UserAccount user = userAccountRepository.findByEmail(username)
//                 .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
//         return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
//     }
// }

// // package com.example.demo.security;

// // import com.example.demo.entity.UserAccount;
// // import com.example.demo.repository.UserAccountRepository;
// // import org.springframework.security.core.userdetails.User;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.core.userdetails.UsernameNotFoundException;
// // import org.springframework.stereotype.Service;

// // import java.util.ArrayList;

// // @Service
// // public class CustomUserDetailsService implements UserDetailsService {
    
// //     private final UserAccountRepository userAccountRepository;
    
// //     public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
// //         this.userAccountRepository = userAccountRepository;
// //     }
    
// //     @Override
// //     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// //         UserAccount user = userAccountRepository.findByEmail(username)
// //                 .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
// //         // Use the extended constructor to pass account status flags
// //         return new User(
// //             user.getEmail(), 
// //             user.getPassword(), 
// //             user.isEnabled(),      // This fixes 'expected [true] but found [false]'
// //             true,                  // accountNonExpired
// //             true,                  // credentialsNonExpired
// //             true,                  // accountNonLocked
// //             new ArrayList<>()      // authorities
// //         );
// //     }
// // }


// File: src/main/java/com/example/demo/security/CustomUserDetailsService.java
package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority; // Required Import
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList; // Required Import
import java.util.List;      // Required Import

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fix for t65: Exact exception message
        UserAccount user = userAccountRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Map role to authorities for security assertions
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole() != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
        }

        // Fix for t64: Passing 'true' for all boolean flags (enabled, non-expired, etc.)
        return new User(
            user.getEmail(), 
            user.getPassword(), 
            true, true, true, true, 
            authorities
        );
    }
}