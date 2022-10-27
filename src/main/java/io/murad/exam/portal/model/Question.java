package io.murad.exam.portal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column
    private String image;

    @Column
    private String optionOne;

    @Column
    private String optionTwo;

    @Column
    private String optionThree;

    @Column
    private String optionFour;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

}