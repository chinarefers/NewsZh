package com.forezp.newszh.model.bean;

/**
 * Created by b508a on 2016/4/12.
 */
public class News {
    private static String QUESTION_URL_PREFIX = "http://www.zhihu.com/question/";
    private static String ANSWER_URL_POSTFIX = "/answer/";
    // private static String USER_URL_PREFIX = "http://www.zhihu.com/people/";
    private static String USER_URL_PREFIX = "http://api.kanzhihu.com/userdetail2/";
    private String title;
    private String time;
    private String summary;
    private String questionid;
    private String answerid;
    private String authorname;
    private String authorhash;
    private String avatar;
    private String vote;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthorhash() {
        return authorhash;
    }

    public void setAuthorhash(String authorhash) {
        this.authorhash = authorhash;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }
    public String getQuestionUrl() {
        return QUESTION_URL_PREFIX + questionid;
    }

    public String getAnswerUrl() {
        return QUESTION_URL_PREFIX + questionid + ANSWER_URL_POSTFIX + answerid;
    }

    public String getUserUrl() {
        return USER_URL_PREFIX + authorhash;
    }

    public static String getQuestionUrlPrefix() {
        return QUESTION_URL_PREFIX;
    }

    public static void setQuestionUrlPrefix(String questionUrlPrefix) {
        QUESTION_URL_PREFIX = questionUrlPrefix;
    }
}
