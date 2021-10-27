package com.example.study.controller;

import com.example.study.model.SearchParam;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class PostController {

   //POST 사용예
    //HTML <FORM>태그 사용 = 검색 파라미터가 많다.
    //ajax (비동기) 검색할때 사용
    //HTTP 통신시 POST BODY에 data를 넣어서 주겟다
    //POST방식에서 지원 : JSON, XML, multipart-form(파일 올릴때 쓰는 형태)/text-plain 형태

    //@RequestMapping(method = RequestMethod.POST, path = "/postMethod"); 같은 의미
    //@PostMapping(value = "/postMethod",produces = {"application/json"})
    @PostMapping(value = "/postMethod") //JSON 방식을 쓸것이므로 produce 생략 가능. = 어떠한 방식으로 받아주겠다다
   public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    @PutMapping("/putMethod")
    public void put(){

    }

    @PatchMapping("/patchMethod")
    public void patch(){

    }
    
}
