package com.holy.ws.entities.concretes.message;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.xml.crypto.Data;
import java.util.List;
/**
 * @author Vugar Mammadli
 */
public class Message {
    private long id;

    @Lob @Basic(fetch = FetchType.LAZY)
    private String messageTextContext;

    private Data sendDate;

    private List<String> attachment;
}
