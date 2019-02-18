package com.oj.daoImpl;

import com.oj.dao.MathDao;
import com.oj.entity.MathProblemEntity;
import com.oj.entity.MathSelectorCheckEntity;
import com.oj.utils.Utils;

import java.util.ArrayList;

public class MathDaoImpl implements MathDao {

    @Override
    public ArrayList<MathProblemEntity> getMathProblemList(MathSelectorCheckEntity mathSelector) {

        ArrayList<MathProblemEntity> mathProblemEntityArrayList = new ArrayList<>();

        String expression = "";
        int [] lenArray = {3, 9, 5, 7, 3, 9, 5, 7};
        int expLen = 3, lenArrayIndex = 0;
        ArrayList<String> signArray = new ArrayList<>();
        int signArrayIndex = 0;

        if(mathSelector.getMultiplySelect() != null) signArray.add("*");
        if(mathSelector.getDivideSelect() != null) signArray.add("/");
        if(mathSelector.getPlusSelect() != null) signArray.add("+");
        if(mathSelector.getMinusSelect() != null) signArray.add("-");
        if(mathSelector.getMultiplySelect() != null) signArray.add("*");
        if(mathSelector.getDivideSelect() != null) signArray.add("/");
        if(mathSelector.getPlusSelect() != null) signArray.add("+");
        if(mathSelector.getMinusSelect() != null) signArray.add("-");

        for(int i = 0; i < Integer.parseInt(mathSelector.getNumberSelect()); i++){
            expression = "";
            MathProblemEntity mathProblemEntity = new MathProblemEntity();

            lenArrayIndex = Utils.intRangedRandNum(0, lenArray.length-1);
            expLen = lenArray[lenArrayIndex];

            for(int j = 0; j < expLen; j++){
                if(j%2 == 0)
                    expression += String.valueOf(Utils.intRangedRandNum(1,100));
                else{
                    signArrayIndex = Utils.intRangedRandNum(0, signArray.size()-1);
                    expression += signArray.get(signArrayIndex);
                }
            }

            mathProblemEntity.setProblem(expression);
            String resss = String.valueOf(Utils.getAnsOfAExpression(expression));
            if(resss.endsWith(".0")) resss = resss.substring(0, resss.length()-2);
            mathProblemEntity.setAns(resss);

            mathProblemEntityArrayList.add(mathProblemEntity);
        }

        return mathProblemEntityArrayList;
    }
}
