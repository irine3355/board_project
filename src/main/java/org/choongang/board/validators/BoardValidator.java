package org.choongang.board.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.board.controllers.RequestBoard;
import org.choongang.board.repositories.BoardDataRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class BoardValidator implements Validator {

    private final BoardDataRepository boardDataRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestBoard.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        RequestBoard form=(RequestBoard) target;
        String subject = form.getSubject();


        // 같은 제목 있으면 오류
        if (boardDataRepository.equals(subject)) {
            errors.rejectValue("email", "Duplicated");
        }

    }
}
