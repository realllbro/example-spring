package com.example.mvc.controller;

import com.example.mvc.domain.Board;
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
    public List<Board> getList(){
        return service.getList();

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
    @ApiOperation(value = "상세조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있다.")
    public void save(Board board){
        service.save(board);
    }

    /**
     * 수정
     * @param board
     */
    @PutMapping
    @ApiOperation(value = "상세조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있다.")
    public void update(Board board){
        service.update(board);
    }

    /**
     * 삭제
     * @param boardSeq
     */
    @DeleteMapping("/{boardSeq}")
    @ApiOperation(value = "상세조회", notes = "게시물 번호에 해당하는 상세 정보를 조회할 수 있다.")
    public void delete(@PathVariable int boardSeq){
        service.delete(boardSeq);
    }
}
