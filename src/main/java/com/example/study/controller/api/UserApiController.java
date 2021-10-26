package com.example.study.controller.api;


import java.util.List;

import com.example.study.controller.CrudController;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User>{

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 15) Pageable pageable){
        log.info("{}", pageable);
        
        return userApiLogicService.search(pageable);
    }

    // @PostConstruct
    // public void init(){
    //     this.baseService = userApiLogicService;
    // }






    // @Override
    // @PostMapping("")
    // public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
    //     log.info("{}",userApiRequest);
    //     return userApiLogicService.create(userApiRequest);
    // }


    // @Override
    // @GetMapping("{id}")
    // public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        
    //     return userApiLogicService.read(id);
    // }

    // @Override
    // @PutMapping("")
    // public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
    //     log.info("{}", userApiRequest);
    //     return userApiLogicService.update(userApiRequest);
    // }
    
    // @Override
    // @DeleteMapping("{idx}")
    // public Header delete(@PathVariable(name = "idx") Long idx) {
        
    //     return userApiLogicService.delete(idx);
    // }

    // public String presentDate(){
    //     DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    //     String dateStr = format.format(Calendar.getInstance().getTime());
    //     return dateStr;
    // }

}
