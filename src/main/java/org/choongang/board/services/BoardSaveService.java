package org.choongang.board.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardSaveService {

    private final BoardDataRepository boardDataRepository;

    public BoardData save(RequestBoard form) {
        BoardData boardData = BoardData.builder()
                .seq(form.getSeq())
                .userName(form.getUserName())
                .subject(form.getSubject())
                .content(form.getContent())
                .build();
        boardDataRepository.save(boardData);
        return boardData;
    }

    public void save(Long seq, String userName, String subject, String content) {
        BoardData boardData = boardDataRepository.findById(seq)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board data id: " + seq));
        boardData.setUserName(userName);
        boardData.setSubject(subject);
        boardData.setContent(content);
        boardDataRepository.save(boardData);
    }

    //

//    public void save(RequestBoard form){
//        Long seq = Object.requireNonNullElse(form.getSeq(), 0L);
//
//        BoardData boardData = boardDataRepository.findById(seq).orElseGet(BoardData::new);
//        boardData.setUserName(form.getUserName());
//        boardData.setSubject(form.getSubject());
//        boardData.setContent(form.getContent());
//
//        boardDataRepository.saveAndFlush(boardData);
//
//    }


}
