
/*package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount registerUser(UserAccount userAccount) {
        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return repository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> login(String username, String password) {
        Optional<UserAccount> userOpt = repository.findByUsername(username);

        if (userOpt.isPresent() &&
                passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserAccount> getUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<UserAccount> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }
}
*/
package com.example.demo.service.impl;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.repository.HarmonizedCalendarRepository;
import com.example.demo.service.HarmonizedCalendarService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HarmonizedCalendarServiceImpl implements HarmonizedCalendarService {

    private final HarmonizedCalendarRepository repository;

    public HarmonizedCalendarServiceImpl(HarmonizedCalendarRepository repository) {
        this.repository = repository;
    }

    @Override
    public HarmonizedCalendar generate(HarmonizedCalendar calendar) {

        if (calendar.getEffectiveFrom().isAfter(calendar.getEffectiveTo())) {
            throw new IllegalArgumentException("Invalid effective date range");
        }

        return repository.save(calendar);
    }

    @Override
    public List<HarmonizedCalendar> findActive(LocalDate date) {
        return repository
                .findByEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
                        date, date);
    }
}
