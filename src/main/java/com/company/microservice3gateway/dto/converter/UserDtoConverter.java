package com.company.microservice3gateway.dto.converter;

import com.company.microservice3gateway.dto.UserDto;
import com.company.microservice3gateway.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getPassword(),
                from.getName(),
                from.getCreateTime()
        );
    }

    public List<UserDto> convert(List<User> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }

}
