package com.blue.service;

import com.blue.pojo.Music;
import com.blue.utils.Response;

import java.util.List;

/**
 * @author smily
 * @Description
 * @date 2023/5/21 10:00
 */
public interface MusicService {
    List<Music> getMusicListById(Integer userId);

    List<Music> getSysMusic();

    List<Music> getMyMusicList(Integer userId);

    int delMyMusic(int musicId);

    int addMusic(Music music);
}
