@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return userAccountService.register(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {
        return userAccountService.login(request);
    }

    @GetMapping("/users")
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return userAccountService.getUserById(id);
    }
}
