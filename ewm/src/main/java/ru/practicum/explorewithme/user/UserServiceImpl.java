package ru.practicum.explorewithme.user;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.user.dto.UserDto;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDto> getAllUsers() {
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
