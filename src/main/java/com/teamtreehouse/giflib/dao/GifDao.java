package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import sun.net.www.content.image.gif;

import java.util.List;

/**
 * Created by kylebudd on 6/9/17.
 */

public interface GifDao {
    List<Gif> findAll();
    Gif findById(Long id);
    void save(Gif gif);
    void delete(Gif gif);
}