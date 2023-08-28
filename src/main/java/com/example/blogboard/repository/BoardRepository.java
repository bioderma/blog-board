package com.example.blogboard.repository;


import com.example.blogboard.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {

    Page<Board> findByTitleContaining(String title, Pageable pageable);
}
