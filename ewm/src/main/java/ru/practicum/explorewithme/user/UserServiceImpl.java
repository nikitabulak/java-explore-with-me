package ru.practicum.explorewithme.user;

import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.pageable.OffsetLimitPageable;
import ru.practicum.explorewithme.user.dto.NewUserRequest;
import ru.practicum.explorewithme.user.dto.UserDto;
import ru.practicum.explorewithme.user.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers(List<Long> ids, int from, int size) {
        List<User> users = userRepository.findUsersByIdIn(ids, OffsetLimitPageable.of(from, size));
        return users.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(NewUserRequest newUserRequest) {
        User user = UserMapper.toNewUser(newUserRequest);
        user = userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        }
    }
}
