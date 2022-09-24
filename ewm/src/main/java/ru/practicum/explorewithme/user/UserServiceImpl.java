package ru.practicum.explorewithme.user;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.user.dto.UserDto;
import ru.practicum.explorewithme.user.dto.UserShortDto;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public List<UserShortDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(long userId) {

    }
}
