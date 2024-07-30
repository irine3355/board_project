package org.choongang.board.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardDeleteService {


    private final BoardDataRepository boardDataRepository;

    public void delete(Long seq) {


        BoardData data = boardDataRepository.findById(seq)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board data id: " + seq));

        boardDataRepository.delete(data);
        boardDataRepository.flush();
    }


}
