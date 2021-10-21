package com.example.study.ifs;

import com.example.study.model.network.Header;

import org.springframework.web.bind.annotation.RequestBody;

public interface CrudInterface<Req, Res> {

    //todo request object 추가
    public Header<Res> create(Header<Req> request);

    public Header<Res> read(Long id);

    public Header<Res> update(Header<Req> request);

    public Header<Res> delete(Long id);
    
}
