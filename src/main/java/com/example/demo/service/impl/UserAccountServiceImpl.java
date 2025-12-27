// package com.example.demo.service.impl; // Correct package based on compiler error

// import com.example.demo.entity.UserAccount;
// import com.example.demo.repository.UserAccountRepository;
// import com.example.demo.service.UserAccountService;
// import jakarta.validation.ValidationException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class UserAccountServiceImpl implements UserAccountService {

//     @Autowired
//     private UserAccountRepository userAccountRepository;

//     @Override
//     public UserAccount register(UserAccount user) {
//         // Fixes t73: passwordMinLengthValidation
//         if (user.getPassword() == null || user.getPassword().length() < 8) {
//             throw new ValidationException("Password must be at least 8 characters");
//         }
//         return userAccountRepository.save(user);
//     }

//     @Override
//     public UserAccount findByEmail(String email) {
//         // Added .orElse(null) to handle Optional from repository
//         return userAccountRepository.findByEmail(email).orElse(null);
//     }

//     @Override
//     public UserAccount getUser(Long id) {
//         return userAccountRepository.findById(id).orElse(null);
//     }

//     @Override
//     public List<UserAccount> getAllUsers() {
//         return userAccountRepository.findAll();
//     }
// }

