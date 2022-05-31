package ru.novikova.birthdaysGifts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.novikova.birthdaysGifts.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
