package ru.novikova.birthdaysGifts.entities.community;

import ru.novikova.birthdaysGifts.entities.User;

public class Family extends CommunityMember{

    public Family(User user) {
        super(CommunityMemberType.FAMILY, user);
    }
}
