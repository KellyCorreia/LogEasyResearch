package com.example.kelly.logeasyresearch;

/**
 * Created by Kelly on 03/04/2015.
 */
public class QuestionClass {

    private String question_id;
    private String question_text;
    private String right_answer;
    private String level_id;

    public QuestionClass(){
        question_id = "";
        question_text="";
        right_answer="";
        level_id="";
    }

    public QuestionClass(String q_id, String q_text, String l_id, String r_answer){
        question_text=q_text;
        right_answer=r_answer;
        level_id=l_id;
        question_id=q_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public void setRight_answer(String right_answer){
        this.right_answer = right_answer;
    }

    public String getRight_answer(){
        return right_answer;
    }

    public void setLevel_id(String level_id){
        this.level_id=level_id;
    }

    public String getLevel_id(){
        return level_id;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return question_text;
    }
}




