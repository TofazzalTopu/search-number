package com.search.number.service.impl;

import com.search.number.model.NumberSearchHistory;
import com.search.number.repository.NumberSearchHistoryRepository;
import com.search.number.service.NumberSearchHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

@Service
@Transactional
@RequiredArgsConstructor
public class NumberSearchHistoryServiceImpl implements NumberSearchHistoryService {

    private final NumberSearchHistoryRepository numberSearchHistoryRepository;

    @Override
    public NumberSearchHistory search(int number) {
        boolean result = searchNumber(number);
        NumberSearchHistory history = new NumberSearchHistory();
        if (result) history = save(result, number);
        return history;
    }

    private NumberSearchHistory save(boolean result, int number) {
        NumberSearchHistory history = new NumberSearchHistory();
        history.setNumber(number);
        history.setResult(result);
        Optional<NumberSearchHistory> searchHistory = numberSearchHistoryRepository.findAllByNumber(number).stream().findFirst();
        if (searchHistory.isPresent()) {
            history = searchHistory.get();
            history = getNumberSearchHistory(history);
        } else {
            history.setFirstInsertDateTime(Instant.now().toEpochMilli());
            history.setCount(1);
            history.setSearchCount(history.getCount() + "");
        }
        return numberSearchHistoryRepository.save(history);
    }

    private NumberSearchHistory getNumberSearchHistory(NumberSearchHistory history) {
        history.setLastSearchDateDime(Instant.now().toEpochMilli());
        int count = history.getCount() + 1;
        history.setCount(count);
        if (count == 1) {
            history.setSearchCount(history.getCount() + "");
        } else {
            StringJoiner joiner = new StringJoiner("..");
            for (int j = 2; j <= count; j++) {
                joiner.add(j + "");
            }
            history.setSearchCount(joiner.toString());
        }
        return history;
    }

    private static boolean searchNumber(int number) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (list.get(middle) == number)
                return true;

            if (list.get(middle) < number)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return false;
    }
}
