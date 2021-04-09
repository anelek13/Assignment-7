package edu.education.syslib.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "details_id")
    private Long id;
    @Column(name = "date_of_join")
    private LocalDate dateOfJoin;
    @Column(name = "address")
    private String address;
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "member_id")
    private Member member;
}
