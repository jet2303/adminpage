package com.example.study.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.study.model.entity.User;
import com.example.study.model.enumclass.UserStatus;
import com.example.study.model.network.Header;
import com.example.study.model.network.Pagenation;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService extends BaseService<UserApiRequest, UserApiResponse, User>{

    //1.request data
    //2.user create
    //3.userApiResponse return


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                            .account(userApiRequest.getAccount())
                            .password(userApiRequest.getPassword())
                            .status(UserStatus.REGISTERED)
                            .email(userApiRequest.getEmail())
                            .phoneNumber(userApiRequest.getPhoneNumber())
                            .registeredAt(LocalDateTime.now())
                            .build();
        User newUser = baseRepository.save(user);
        return Header.OK(response(newUser));
    }


    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> optional = baseRepository.findById(id);

        return optional.map(
                            user -> Header.OK(response(user))
                            )
                        .orElseGet(
                            ()->Header.ERROR("not found data")
                        );
   
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        
        return Optional.ofNullable(request.getData())
                        .map(body -> {
                            return baseRepository.findById(body.getId());
                        })
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .map(user -> {
                            UserApiRequest body = request.getData();
                            user.setAccount(body.getAccount())
                                .setPassword(body.getPassword())
                                .setStatus(body.getStatus())
                                .setEmail(body.getEmail())
                                .setPhoneNumber(body.getPhoneNumber());
                            return user;
                        })
                        .map(updateUser -> baseRepository.save(updateUser))
                        .map(updateUser -> Header.OK(response(updateUser)))
                        .orElseGet( () -> Header.ERROR("not found Data"));
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        Optional<User> optional = baseRepository.findById(id);

        return optional.map(deleteUser->{
                        baseRepository.deleteById(deleteUser.getId());
                        return deleteUser;
                        })
                        .map(updateUser-> Header.OK(response(updateUser)))
                        .orElseGet( ()->Header.ERROR("don't delete data"));
    }


    private UserApiResponse response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword())
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .status(UserStatus.REGISTERED)
            .registeredAt(user.getRegisteredAt())
            .unregisteredAt(user.getUnregisteredAt())
            .build();
            
        return userApiResponse;
    }

    // private UserApiResponse pageResponse(User user){
    //     UserApiResponse userApiResponse = UserApiResponse.builder()
    //         .id(user.getId())
    //         .account(user.getAccount())
    //         .password(user.getPassword())
    //         .email(user.getEmail())
    //         .phoneNumber(user.getPhoneNumber())
    //         .status(UserStatus.REGISTERED)
    //         .registeredAt(user.getRegisteredAt())
    //         .unregisteredAt(user.getUnregisteredAt())
    //         .build();
            
    //     return userApiResponse;
    // }


    public Header<List<UserApiResponse>> search(Pageable pageable) {
        Page<User> users = baseRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList = users.stream()
                .map(user -> response(user))
                .collect(Collectors.toList());
        
        Pagenation pagenation = Pagenation.builder()
                                            .totalPages(users.getTotalPages())
                                            .totalElements(users.getTotalElements())
                                            .currentPage(users.getNumber())
                                            .currentElements(users.getNumberOfElements())
                                            .build();



        return Header.OK(userApiResponseList,pagenation);
    }
    
        
 
}
