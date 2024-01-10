package com.example.mvc.service;

import com.example.mvc.domain.Board;
import com.example.mvc.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시판 서비스
 */
@Service
public class BoardService {

    @Autowired
    private BoardRepository repository;

    /**
     * 목록 조회
     * @return
     */
    public List<Board> getList(){
        return repository.getList();

    }

    /**
     * 단건조회
     * @param boardSeq
     * @return
     */
    public Board get(int boardSeq){
        return repository.get(boardSeq);
    }

    /**
     * 저장
     * @param board
     */
    public void save(Board board){
        repository.save(board);
    }

    /**
     * 수정
     * @param board
     */
    public void update(Board board){
        repository.update(board);
    }

    /**
     * 삭제
     * @param boardSeq
     */
    public void delete(int boardSeq){
        repository.delete(boardSeq);
    }
}



