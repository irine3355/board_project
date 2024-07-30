package org.choongang.board.controllers;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestBoard {

    private Long seq;
    @Size(min=3)
    private String userName;
    @NotBlank
    @Size(min=3)
    private String subject;
    @NotBlank
    @Lob
    private String content;
}
