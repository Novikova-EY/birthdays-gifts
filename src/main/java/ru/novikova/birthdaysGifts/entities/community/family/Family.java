package ru.novikova.birthdaysGifts.entities.community.family;

import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;
import ru.novikova.birthdaysGifts.entities.community.CommunityMemberType;

// данный класс является вариантом исполнения структурного паттерна Мост
public class Family extends CommunityMember {

    public Family(User user) {
        super(CommunityMemberType.FAMILY, user);
    }
}
