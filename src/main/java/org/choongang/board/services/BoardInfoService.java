package org.choongang.board.services;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardDataRepository boardDataRepository;

    public Optional<BoardData> findById(Long seq) {
        return boardDataRepository.findById(seq);
    }

    public List<BoardData> findAll() {
        return boardDataRepository.findAll();
    }

    //



    public RequestBoard getForm(Long seq) {
        BoardData boardData = boardDataRepository.findById(seq)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board data id: " + seq));
        RequestBoard form = new RequestBoard();
        form.setSeq(boardData.getSeq());
        form.setUserName(boardData.getUserName());
        form.setSubject(boardData.getSubject());
        form.setContent(boardData.getContent());
        return form;
    }

//    public BoardData getBoardDataForUpdate(Long id) {
//        return boardDataRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid board data id: " + id));
//    }
}
