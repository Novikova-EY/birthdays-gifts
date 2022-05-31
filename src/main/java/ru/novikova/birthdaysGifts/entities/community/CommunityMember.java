package ru.novikova.birthdaysGifts.entities.community;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.novikova.birthdaysGifts.entities.User;

import javax.persistence.*;

@Entity
@Table(name = "community_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "community_member_type")
    private CommunityMemberType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CommunityMember(CommunityMemberType type, User user) {
        this.type = type;
        this.user = user;
    }
}