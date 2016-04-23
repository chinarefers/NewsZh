package com.forezp.newszh.model.bean;

import org.json.JSONArray;

/**
 * Created by b508a on 2016/4/12.
 */
public class Content {

    private String error;
    private int count;
    private JSONArray answers;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JSONArray getAnswers() {
        return answers;
    }

    public void setAnswers(JSONArray answers) {
        this.answers = answers;
    }
}
