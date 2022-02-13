package com.example.mymqapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
public class KmqMessage<T> {

    private HashMap<String,Object> headers;

    private T body;

    private boolean commit;

    public boolean isCommit() {
        return commit;
    }

    public boolean commit() {
        commit = true;
        return true;
    }
}
