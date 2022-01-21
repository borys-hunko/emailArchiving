package com.hunko.email.model;

import lombok.Data;

@Data
public class EmailMessage {
    private long id;
    private MailingThread thread;
    private long timestamp;
}
