package com.blue.service.impl;

import com.blue.mapper.WordMapper;
import com.blue.pojo.Word;
import com.blue.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/24 8:23
 */
@Service
public class WordServiceImp implements WordService {
    @Autowired
    private WordMapper wordMapper;
    @Override
    public int addWord(Word word) {
        return wordMapper.insert(word);
    }

    @Override
    public List<Word> getWordList() {
        return wordMapper.getWordList();
    }
}
