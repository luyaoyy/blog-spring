package com.blue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blue.mapper.MusicMapper;
import com.blue.pojo.Music;
import com.blue.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/21 10:00
 */
@Service
public class MusicServiceImp implements MusicService {
    @Autowired
    private MusicMapper musicMapper;

    @Override
    public List<Music> getMusicListById(Integer userId) {//用户进入页面后，根据用户是否登入状态获取音乐列表
        QueryWrapper<Music> nullId = new QueryWrapper<>();
        QueryWrapper<Music> notNullId = new QueryWrapper<>();
        List<Music> musicList;
        if (userId != null) {
            notNullId.eq("user_id", userId).or().eq("is_sys", 1);
            musicList = musicMapper.selectList(notNullId);
        } else {
            nullId.eq("is_sys", 1);
            musicList = musicMapper.selectList(nullId);
        }
        return musicList;
    }

    @Override
    public List<Music> getSysMusic() {
        QueryWrapper<Music> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_sys", 1);
        return musicMapper.selectList(queryWrapper);
    }

    @Override
    public List<Music> getMyMusicList(Integer userId) {
        QueryWrapper<Music> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return musicMapper.selectList(queryWrapper);
    }

    @Override
    public int delMyMusic(int musicId) {
        QueryWrapper<Music> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("music_id", musicId);
        int row = musicMapper.delete(queryWrapper);
        return row;
    }

    @Override
    public int addMusic(Music music) {
        return musicMapper.insert(music);
    }

}
