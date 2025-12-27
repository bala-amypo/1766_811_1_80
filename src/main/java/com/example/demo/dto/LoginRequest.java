// package com.example.demo.dto;

// public class LoginRequest {
//     private String email;
//     private String password;

//     // No-args constructor for JSON serialization
//     public LoginRequest() {}

//     // Constructor required by the test: ("login@example.com", "pass")
//     public LoginRequest(String email, String password) {
//         this.email = email;
//         this.password = password;
//     }

//     // Getter required for Assert.assertEquals(req.getEmail(), ...)
//     public String getEmail() {
//         return email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     // Setters
//     public void setEmail(String email) { this.email = email; }
//     public void setPassword(String password) { this.password = password; }
// }

package com.example.demo.dto;

public class LoginRequest {
    private String email;
    private String password;

    // This constructor is required for t66
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
}