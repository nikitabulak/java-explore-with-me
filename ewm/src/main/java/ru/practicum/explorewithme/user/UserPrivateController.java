package ru.practicum.explorewithme.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.explorewithme.user.dto.UserDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/subscriptions")
public class UserPrivateController {
    private final UserService userService;

    @PatchMapping("/{userId}/subscription_on")
    public UserDto allowSubscription(@PathVariable long userId) {
        return userService.allowSubscription(userId);
    }

    @PatchMapping("/{userId}/subscription_off")
    public UserDto disableSubscription(@PathVariable long userId) {
        return userService.disableSubscription(userId);
    }

    @PatchMapping("/{userId}/subscribe/{author_id}")
    public UserDto subscribe(@PathVariable long userId,
                             @PathVariable long author_id) {
        return userService.subscribe(userId, author_id);
    }

    @PatchMapping("/{userId}/unsubscribe/{author_id}")
    public UserDto unsubscribe(@PathVariable long userId,
                               @PathVariable long author_id) {
        return userService.unsubscribe(userId, author_id);
    }
}
