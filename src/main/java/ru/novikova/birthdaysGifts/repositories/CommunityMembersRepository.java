package ru.novikova.birthdaysGifts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;

public interface CommunityMembersRepository extends JpaRepository<CommunityMember, Long> {
}
