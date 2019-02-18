package com.oj.dao;

import com.oj.entity.PoetryEntity;
import com.oj.entity.PoetrySubEntity;

import java.util.ArrayList;

public interface PoetryDao {

    boolean insertPoetry(PoetryEntity poetryEntity);

    ArrayList<PoetryEntity> getPoetryList();

    ArrayList<PoetrySubEntity> getPoetrySubList(ArrayList<PoetryEntity> poetryEntityArrayList, int num);

}
