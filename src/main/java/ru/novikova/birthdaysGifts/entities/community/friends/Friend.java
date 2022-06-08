package ru.novikova.birthdaysGifts.entities.community.friends;

import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;
import ru.novikova.birthdaysGifts.entities.community.CommunityMemberType;

public class Friend extends CommunityMember {
    public Friend(User user) {
        super(CommunityMemberType.FRIEND, user);
    }
}
