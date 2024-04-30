package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.dto.Reqdto.UserEntryDto;
import com.example.BookMyShow.models.User;

public class UserTransformer {
    public static User transform(UserEntryDto userEntryDto) {

        User user = User.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .address(userEntryDto.getAddress())
                .gender(userEntryDto.getGender())
                .mobile(userEntryDto.getMobile())
                .email(userEntryDto.getEmail())
                .build();

        return user;
    }
}
