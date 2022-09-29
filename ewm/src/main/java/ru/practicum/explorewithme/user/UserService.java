package ru.practicum.explorewithme.user;

import ru.practicum.explorewithme.user.dto.UserDto;

import java.util.List;

public interface UserService {
    //Admin___________________________________________________
    List<UserDto> getAllUsers();

    UserDto createUser(UserDto userDto);

    void deleteUser(long userId);
}
