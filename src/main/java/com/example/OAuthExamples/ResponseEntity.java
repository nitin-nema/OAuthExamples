package com.example.OAuthExamples;

@PreAuthorize("hasAuthority('SCOPE_read')") // Requires the 'read' scope
@GetMapping("/secure-data")
public ResponseEntity<String> getSecureData() {
    return ResponseEntity.ok("Secure Data");
}

