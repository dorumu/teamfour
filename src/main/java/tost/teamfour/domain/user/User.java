package tost.teamfour.domain.user;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@RequiredArgsConstructor//생성자를 자동으로 생성해줌
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNid;
    private UserRole userRole;

    private String userId;
    private String userPassword;
    private String userName;
    private String phone;
    private String email;

    private String birthday;
    private Gender gender;
    private char attend;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seat_nid")
    private Seat seat;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_nid")
    @ToString.Exclude
    private List<Address> address;
    private boolean cabinetYn;

    /* 서비스, 정보이용 yn은 각 번호를 array로 갖고있다가 프론트에서 처리해야하는게 맞을듯.
     * 서비스는 지금만 봐도 SMS, 수면관리 등 4개가 있고 정보이용도 이메일, 휴대폰, 우편 3개임
     * 디비에 저장할떈 JSON.stringify로 가져가야함
     */
    private String useService;
    //정보이용제공동의 array
    private String permitInfo;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "promotion_nid")
    @ToString.Exclude
    private List<Promotion> promotion;

    private boolean deleteYn;


    public User(Long userNid, UserRole userRole, String userId, String userPassword, String userName, String phone, String email, String birthday, Gender gender, char attend, List<Address> address, boolean cabinetYn, String useService, String permitInfo, List<Promotion> promotion, boolean deleteYn) {
        this.userNid = userNid;
        this.userRole = userRole;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
        this.attend = attend;
        this.address = address;
        this.cabinetYn = cabinetYn;
        this.useService = useService;
        this.permitInfo = permitInfo;
        this.promotion = promotion;
        this.deleteYn = deleteYn;

    }
}

