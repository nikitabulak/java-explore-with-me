package ru.practicum.explorewithme.user;

import ru.practicum.explorewithme.user.dto.UserDto;
import ru.practicum.explorewithme.user.dto.UserShortDto;

import java.util.List;

public interface UserService {
    //Admin___________________________________________________
    List<UserShortDto> getAllUsers();
    UserDto createUser(UserDto userDto);
    void deleteUser(long userId);
}
