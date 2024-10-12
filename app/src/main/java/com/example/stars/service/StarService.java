package com.example.stars.service;

import com.example.stars.beans.Stars;
import com.example.stars.dao.IDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StarService implements IDao<Stars> {

    private List<Stars> stars;
    private static StarService instance;

    private StarService() {
        this.stars = new ArrayList<>();
    }
    public static StarService getInstance() {
        if(instance == null)
            instance = new StarService();
        return instance;
    }


    @Override
    public boolean create(Stars o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Stars o) {
        for (Stars s : stars) {
            if (s.getStar() == o.getId()){
                s.setImg(o.getImg());
                s.setName(o.getName());
                s.setStar(o.getStar());
            }
        }
        return true;
    }

    @Override
    public boolean delete(Stars o) {
        return stars.remove(o);
    }

    @Override
    public List<Stars> findAll() {
        return stars;
    }

    @Override
    public Stars findById(int id) {
        for(Stars s : stars){
            if(s.getId() == id)
                return s;
        }
        return null;
    }
}
