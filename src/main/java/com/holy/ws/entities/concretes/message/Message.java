package com.holy.ws.entities.concretes.message;

import javax.xml.crypto.Data;
import java.util.List;

public class Message {
    private long id;

    private String messageTextContext;

    private Data sendDate;

    private List<String> attachment;
}
