package ru.practicum.explorewithme.user;

import ru.practicum.explorewithme.user.dto.NewUserRequest;
import ru.practicum.explorewithme.user.dto.UserDto;

import java.util.List;

public interface UserService {
    //Admin___________________________________________________
    List<UserDto> getAllUsers(List<Long> ids, int from, int size);

    UserDto createUser(NewUserRequest newUserRequest);

    void deleteUser(long userId);

    UserDto allowSubscription(long userId);

    UserDto disableSubscription(long userId);

    UserDto subscribe(long userId, long author_id);

    UserDto unsubscribe(long userId, long author_id);


}
