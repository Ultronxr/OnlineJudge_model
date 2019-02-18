package com.oj.entity;

public class MathProblemEntity {

    private String problem;
    private String ans;

    public MathProblemEntity() {
    }

    public MathProblemEntity(String problem, String ans) {
        this.problem = problem;
        this.ans = ans;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "MathProblemEntity{" +
                "problem='" + problem + '\'' +
                ", ans='" + ans + '\'' +
                '}';
    }
}
