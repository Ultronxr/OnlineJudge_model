package com.oj.dao;

import com.oj.entity.MathProblemEntity;
import com.oj.entity.MathSelectorCheckEntity;

import java.util.ArrayList;

public interface MathDao {

    ArrayList<MathProblemEntity> getMathProblemList(MathSelectorCheckEntity mathSelector);

}
