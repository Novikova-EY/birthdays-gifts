package ru.novikova.birthdaysGifts.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;
import ru.novikova.birthdaysGifts.entities.community.CommunityMemberType;
import ru.novikova.birthdaysGifts.entities.community.Family;
import ru.novikova.birthdaysGifts.entities.community.Friend;
import ru.novikova.birthdaysGifts.repositories.CommunityMembersRepository;
import ru.novikova.birthdaysGifts.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CommunityMembersRepository communityMembersRepository;

    public ResponseEntity<?> createNewUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // реализация паттерна FactoryMethod
    public CommunityMember createNewCommunityMember(CommunityMemberType type, User user) {
        CommunityMember communityMember = null;

        switch (type) {
            case FAMILY:
                communityMember = new Family(user);
            case FRIEND:
                communityMember = new Friend(user);
        }
        return communityMember;
    }
}
