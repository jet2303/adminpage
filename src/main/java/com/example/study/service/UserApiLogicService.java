package com.example.study.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse>{

    @Autowired
    private UserRepository userRepository;

    //1.request data
    //2.user create
    //3.userApiResponse return


    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();

        User user = User.builder()
                            .account(userApiRequest.getAccount())
                            .password(userApiRequest.getPassword())
                            .status(userApiRequest.getStatus())
                            .email(userApiRequest.getEmail())
                            .phoneNumber(userApiRequest.getPhoneNumber())
                            .registeredAt(LocalDateTime.now())
                            .build();
        User newUser = userRepository.save(user);
        return response(newUser);
    }


    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional.map(
                            user -> response(user)
                            )
                        .orElseGet(
                            ()->Header.ERROR("not found data")
                        );
   
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1.data get
        UserApiRequest userRequest = request.getData();
        //2.id -> user find
        Optional<User> optional = userRepository.findById(userRequest.getId());


    
        
        return optional.map(
            user -> {
                user.setAccount(userRequest.getAccount())
                    .setPassword(userRequest.getPassword())
                    .setStatus(userRequest.getStatus())
                    .setPhoneNumber(userRequest.getPhoneNumber())
                    .setEmail(userRequest.getEmail());
                    // .setRegisteredAt(userRequest.getRegisteredAt())
                    // .setUnregisteredAt(userRequest.getUnregisteredAt());
                return user;    
            }
        )
            .map(user -> userRepository.save(user))
            .map(updateUser -> response(updateUser))
            .orElseGet( 
                () -> Header.ERROR("not found id")
                );

        //3. update


        //4. make userApiResponse 
       
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional.map(deleteUser->{
                        userRepository.deleteById(deleteUser.getId());
                        return deleteUser;
                        })
                        .map(updateUser->response(updateUser))
                        .orElseGet( ()->Header.ERROR("don't delete data"));
    }


    private Header<UserApiResponse> response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
            .id(user.getId())
            .account(user.getAccount())
            .password(user.getPassword())
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .status(user.getStatus())
            .registeredAt(user.getRegisteredAt())
            .unregisteredAt(user.getUnregisteredAt())
            .build();
            
        return Header.OK(userApiResponse);
    }
    
        
 
}
