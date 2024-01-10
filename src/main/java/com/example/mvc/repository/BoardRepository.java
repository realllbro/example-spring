package com.example.mvc.repository;

import com.example.mvc.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 게시판 repository
 */
@Repository
public interface BoardRepository {

    // 목록조회
    List<Board> getList();

    // 단건조회
    Board get(int boardSeq);

    // 저장
    void save(Board board);
    
    // 수정
    void update(Board board);

    // 삭제
    void delete(int boardSeq);
}
