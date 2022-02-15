package com.search.number;

import com.search.number.model.NumberSearchHistory;
import com.search.number.service.NumberSearchHistoryService;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@NoArgsConstructor
@AutoConfigureMockMvc
class NumberApplicationTests {

    @Autowired
    NumberSearchHistoryService numberSearchHistoryService;

    @Test
    public void search() {
        int number = 5;
        NumberSearchHistory history = numberSearchHistoryService.search(number);
        Assert.assertEquals(true, history.isResult());
    }


    @Test
    public void findNumber() {
        Assert.assertEquals(true, searchNumber(5));
    }

    static boolean searchNumber(int number) {
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
