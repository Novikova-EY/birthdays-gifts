package ru.novikova.birthdaysGifts.entities.community;

import ru.novikova.birthdaysGifts.entities.User;

// данный класс является вариантом исполнения структурного паттерна Мост
public class Family extends CommunityMember{

    public Family(User user) {
        super(CommunityMemberType.FAMILY, user);
    }
}
