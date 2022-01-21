package com.hunko.email.model;

import lombok.Data;

@Data
public class MailingThread {
    private long id;
    private User sender;
    private User receiver;
    private Folder folder;
}
