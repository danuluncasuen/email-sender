package com.utm.emailsender;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MailEntity {

    private String title;
    private String content;
    private String to;

}
