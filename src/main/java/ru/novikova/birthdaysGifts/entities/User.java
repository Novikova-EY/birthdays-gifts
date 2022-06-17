package ru.novikova.birthdaysGifts.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.novikova.birthdaysGifts.entities.community.CommunityMember;
import ru.novikova.birthdaysGifts.entities.gift.Gift;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "user")
    private List<CommunityMember> communityMemberList;

    @ManyToMany
    @JoinTable(name = "user_gift",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "gift_id")
    )
    private List<Gift> gifts;
}
