package com.example.mvc.repository;

import com.example.mvc.domain.Board;
import com.example.mvc.parameter.BoardParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 */
@Repository
public interface BoardRepository {

    // 목록조회
    List<Board> getList(BoardParameter board);

    // 단건조회
    Board get(int boardSeq);

    // 저장
    void save(BoardParameter board);

    // 수정
    void update(BoardParameter board);

    // 삭제
    void delete(int boardSeq);
}
