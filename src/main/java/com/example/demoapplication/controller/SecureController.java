
package com.example.demoapplication.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @GetMapping("/read-only")
    @Secured("ROLE_READ")
    public String readOnlyEndpoint() {
        return "Access granted to READ role";
    }

    @GetMapping("/write-only")
    @RolesAllowed("ROLE_WRITE")
    public String writeOnlyEndpoint() {
        return "Access granted to WRITE role";
    }

    @GetMapping("/write-or-delete")
    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    public String writeOrDeleteEndpoint() {
        return "Access granted to WRITE or DELETE role";
    }

    @GetMapping("/user-match")
    @PreAuthorize("#username == authentication.name")
    public String usernameMatch(@RequestParam String username) {
        return "Access granted to matching username: " + username;
    }
}
