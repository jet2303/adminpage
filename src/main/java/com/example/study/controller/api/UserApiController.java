package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse>{

    @Autowired
    private UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("")
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
        log.info("{}",userApiRequest);
        return userApiLogicService.create(userApiRequest);
    }


    @Override
    @GetMapping("{id}")
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        log.info("{}", userApiRequest);
        return userApiLogicService.update(userApiRequest);
    }
    
    @Override
    @DeleteMapping("{idx}")
    public Header delete(@PathVariable(name = "idx") Long idx) {
        
        return userApiLogicService.delete(idx);
    }


}
