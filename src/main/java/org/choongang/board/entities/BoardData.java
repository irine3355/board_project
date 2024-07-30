package org.choongang.board.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BoardData {

    @Id
    @GeneratedValue
    private Long seq;
    @Column(length = 65)
    private String userName;
    @Column(length = 65, unique = true, nullable = false)
    private String subject;
    @Column (nullable = false)
    private String content;

}
