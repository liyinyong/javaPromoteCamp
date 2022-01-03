package io.kimmking.rpcfx.demo.api;

import io.kimmking.rpcfx.api.Client;
import org.springframework.stereotype.Component;

@Client
public interface UserService {

    User findById(int id);

}
