package com.blue.service;

import com.blue.pojo.Word;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/24 8:24
 */
public interface WordService {
    int addWord(Word word);
    List<Word> getWordList();
}
