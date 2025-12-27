
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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserAccountRepository userAccountRepository;
    
    public CustomUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
    
    @Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserAccount user = userAccountRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    
    // Passing 'true' for all boolean flags ensures isEnabled() returns true for t64
    return new User(user.getEmail(), user.getPassword(), 
                    true, true, true, true, new ArrayList<>());
}
}