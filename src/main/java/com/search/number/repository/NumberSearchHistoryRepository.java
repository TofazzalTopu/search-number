package com.search.number.repository;

import com.search.number.model.NumberSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NumberSearchHistoryRepository extends JpaRepository<NumberSearchHistory, Long> {

    List<NumberSearchHistory> findAllByNumber(int number);
}
