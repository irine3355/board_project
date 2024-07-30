package org.choongang.board.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.BoardData;
import org.choongang.board.repositories.BoardDataRepository;
import org.choongang.board.services.BoardDeleteService;
import org.choongang.board.services.BoardInfoService;
import org.choongang.board.services.BoardSaveService;
import org.choongang.board.validators.BoardValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDataRepository boardDataRepository;
    private final BoardSaveService boardSaveService;
   private final BoardDeleteService boardDeleteService;
   private final BoardInfoService boardInfoService;
private final BoardValidator boardValidator;

    @GetMapping("/write")
    public String writeForm(@ModelAttribute RequestBoard form, Model model, Errors errors) {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@Valid RequestBoard form, Errors errors) {
        if (errors.hasErrors()) {
            return "board/write";
        }

        boardSaveService.save(form);
        return "redirect:/board/read";
    }

//

    @GetMapping("/read")
    public String read(Model model) {
        List<BoardData> items =  boardInfoService.findAll();
        model.addAttribute("items", items);
        return "board/read";
    }

    //

    @PostMapping("/delete/{seq}")
    public String deleteItem(@PathVariable("seq") Long seq) {
        boardDeleteService.delete(seq);
        return "redirect:/board/read";
    }

    //?

    @GetMapping("/update/{seq}")
    public String updateForm(@PathVariable("seq") Long seq, Model model) {
        RequestBoard form = boardInfoService.getForm(seq);
        model.addAttribute("requestBoard", form);
        return "board/update";
    }

    @PostMapping("/update/{seq}")
    public String update(@PathVariable("seq") Long seq, @Valid @ModelAttribute("requestBoard")  RequestBoard form, Errors errors) {
        if (errors.hasErrors()) {
            return "board/update";
        }
        boardSaveService.save(seq, form.getUserName(), form.getSubject(), form.getContent());
        return "redirect:/board/read";
    }


}
