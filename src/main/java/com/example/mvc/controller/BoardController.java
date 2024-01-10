package com.example.mvc.controller;

import com.example.mvc.domain.Board;
import com.example.mvc.parameter.BoardParameter;
import com.example.mvc.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시판 컨트롤러
 */
@RestController
@RequestMapping("/board")
@Api(tags = "게시판 API")
public class BoardController {

    @Autowired
    private BoardService service;

    /**
     * 목록 조회
     * @return
     */
    @GetMapping
    @ApiOperation(value = "목록조회", notes = "목록 정보를 조회할 수 있다.")
    public List<Board> getList(BoardParameter board){
        return service.getList(board);

    }

    /**
     * 단건조회
     * @param boardSeq
     * @return
     */
    @GetMapping("/{boardSeq}")
    @ApiOperation(value = "상세조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "게시물 번호", example = "1")
    })
    public Board get(@PathVariable int boardSeq){
        return service.get(boardSeq);
    }

    /**
     * 저장
     * @param board
     */
    @PostMapping
    @ApiOperation(value = "등록", notes = "신규 게시물 저장.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "제목", example = "제목입니다."),
            @ApiImplicitParam(name = "contents", value = "내용", example = "내용입니다.")
    })
    public void save(BoardParameter board){
        service.save(board);
    }

    /**
     * 수정
     * @param board
     */
    @PutMapping
    @ApiOperation(value = "수정", notes = "등록 내용을 수정할 수 있다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardSeq", value = "수정할 게시물 번호", example = "1"),
            @ApiImplicitParam(name = "title", value = "제목", example = "제목 수정 입니다."),
            @ApiImplicitParam(name = "contents", value = "내용", example = "내용 수정 입니다.")
    })
    public void update(BoardParameter board){
        service.update(board);
    }

    /**
     * 삭제
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "삭제", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있다.")
    public void delete(@PathVariable int boardSeq){
        service.delete(boardSeq);
    }
}
