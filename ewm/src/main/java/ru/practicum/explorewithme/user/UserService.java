package ru.practicum.explorewithme.user;

import org.springframework.web.bind.annotation.RequestParam;
import ru.practicum.explorewithme.user.dto.NewUserRequest;
import ru.practicum.explorewithme.user.dto.UserDto;

import java.util.List;

public interface UserService {
    //Admin___________________________________________________
    List<UserDto> getAllUsers(List<Long> ids, int from, int size);

    UserDto createUser(NewUserRequest newUserRequest);

    void deleteUser(long userId);
}
