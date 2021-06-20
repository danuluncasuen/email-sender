package com.utm.emailsender;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailRestController {

    private final LocalEmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<?> testEmailSend(@RequestBody MailEntity mailEntity) {
        try {
            emailService.sendEmail(mailEntity);
            return new ResponseEntity<>("Mail sent", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
