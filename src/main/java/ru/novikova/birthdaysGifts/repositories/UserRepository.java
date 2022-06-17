package ru.novikova.birthdaysGifts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.novikova.birthdaysGifts.entities.User;
import ru.novikova.birthdaysGifts.entities.gift.Gift;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM Gift g JOIN g.userList u")
    List<Gift> findAllGifts();
}
