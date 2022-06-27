package ru.novikova.birthdaysGifts.services;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.novikova.birthdaysGifts.IdentityMapUsers;
import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;
import ru.novikova.birthdaysGifts.entities.community.CommunityMemberType;
import ru.novikova.birthdaysGifts.entities.community.family.Family;
import ru.novikova.birthdaysGifts.entities.community.friends.Friend;
import ru.novikova.birthdaysGifts.entities.gift.Gift;
import ru.novikova.birthdaysGifts.mappers.UserMapper;
import ru.novikova.birthdaysGifts.repositories.CommunityMembersRepository;
import ru.novikova.birthdaysGifts.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CommunityMembersRepository communityMembersRepository;

    private final UserMapper userMapper = new UserMapper(datasourse);
    private final IdentityMapUsers mapUsers;

    public ResponseEntity<?> createNewUser(User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void createNewUserWithMapper(User user) throws SQLException {
        if (mapUsers.getUser(user.getId()).equals(user)) {
            System.out.println("Such user is already exists");
        } else {
            userMapper.insert(user);
        }
    }

    public void updateUserWithMapper(User user) throws SQLException {
        if (mapUsers.getUser(user.getId()).equals(user)) {
            System.out.println("Such user is already exists");
        } else {
            userMapper.update(user);
        }
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

    public List<Gift> findAllGifts() {
        return userRepository.findAllGifts();
    }
}
