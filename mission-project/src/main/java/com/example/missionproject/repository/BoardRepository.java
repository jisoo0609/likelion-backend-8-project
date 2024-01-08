package com.example.missionproject.repository;

import com.example.missionproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository <Board, Long> {
}
