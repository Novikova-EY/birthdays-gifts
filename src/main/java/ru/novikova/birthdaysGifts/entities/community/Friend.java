package ru.novikova.birthdaysGifts.entities.community;

import ru.novikova.birthdaysGifts.entities.User;

public class Friend extends CommunityMember{
    public Friend(User user) {
        super(CommunityMemberType.FRIEND, user);
    }
}
