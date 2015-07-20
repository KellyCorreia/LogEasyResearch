package com.example.kelly.logeasyresearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MySQLiteHelper extends SQLiteOpenHelper {

    //Declaration of Table Questions
    public static final String TABLE_QUESTIONS = "table_questions";
    public static final String COLUMN_QUESTION_ID = "Q_id";
    public static final String COLUMN_QUESTION_TEXT = "Q_text";
    public static final String COLUMN_LEVEL_ID = "L_id";
    private static final String QUESTIONS_DATABASE_CREATE = "create table "
            + TABLE_QUESTIONS + "(" + COLUMN_QUESTION_ID
            + " text primary key, " + COLUMN_QUESTION_TEXT
            + " text not null, " + COLUMN_LEVEL_ID
            + " integer not null);";


    //Declaration of Table ANSWERS
    public static final String TABLE_ANSWERS = "table_answers";
    public static final String COLUMN_ANSWER_ID = "A_id";
    public static final String COLUMN_ANSWER_TEXT = "A_text";
    public static final String COLUMN_ANSWER_STATE = "A_State";
    private static final String ANSWERS_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_ANSWERS + "(" + COLUMN_ANSWER_ID
            + " text primary key, " + COLUMN_ANSWER_TEXT
            + " text not null, " + COLUMN_QUESTION_ID
            + " text not null," + COLUMN_ANSWER_STATE
            + " integer not null);";


    //Declaration of Table USERS
    public static final String TABLE_USERS = "table_users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_AVATAR = "avatar";
    private static final String USERS_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_USERS + "(" + COLUMN_USER_ID
            + " integer primary key autoincrement, " + COLUMN_USERNAME
            + " text not null, " + COLUMN_EMAIL
            + " text not null, " + COLUMN_PASS
            + " text not null, " + COLUMN_AVATAR
            + " text);";


    //Declaration of Table SCOREBOARD
    public static final String TABLE_SCOREBOARD = "table_scoreboard";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_WRONG_NUMBER = "wrong_number";
    private static final String SCOREBOARD_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_SCOREBOARD + "(" + COLUMN_USER_ID
            + " integer primary key, " + COLUMN_POINTS
            + " integer, " + COLUMN_WRONG_NUMBER
            + " integer, " + COLUMN_LEVEL_ID
            + " integer);";

    //Declaration of Table LEVEL
    public static final String TABLE_LEVEL = "table_level";
    public static final String COLUMN_LEVEL_NAME = "l_name";
    public static final String COLUMN_LESSON = "lesson";
    public static final String COLUMN_TIP = "tip";
    private static final String LEVEL_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_LEVEL + "(" + COLUMN_LEVEL_ID
            + " integer primary key autoincrement, " + COLUMN_LEVEL_NAME
            + " text not null, " + COLUMN_LESSON
            + " text," + COLUMN_TIP
            + " text);";


    //ver se ainda precisa dessa tabela ou faze-la por meio de consulta
    //Declaration of Table SCOREBOARD_SCREEN
    public static final String TABLE_SCOREBOARD_SCREEN = "table_scoreboard_screen";
    private static final String SCOREBOARD_SCREEN_DATABASE_CREATE = "create table "
            + TABLE_SCOREBOARD_SCREEN + "(" + COLUMN_USERNAME
            + " text primary key, " + COLUMN_LEVEL_NAME
            + " text, " + COLUMN_POINTS
            + " text, " + COLUMN_WRONG_NUMBER
            + " text);";

    private static final String DATABASE_NAME = "ActivityLogEasy.db";
    private static final int DATABASE_VERSION = 2;
    //OR:     private SQLiteDatabase dbase;

    public SQLiteDatabase database = this.getWritableDatabase();

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        db.execSQL(QUESTIONS_DATABASE_CREATE);
        db.execSQL(USERS_DATABASE_CREATE);
        db.execSQL(ANSWERS_DATABASE_CREATE);
        db.execSQL(SCOREBOARD_DATABASE_CREATE);
        db.execSQL(LEVEL_DATABASE_CREATE);
        db.execSQL(SCOREBOARD_SCREEN_DATABASE_CREATE);
        InsertValues data = new InsertValues(this);
        data.insertAllValues();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }

    /*
     All methods to add values to the database.
                                               */

    public void addLevel(ClassLevel l) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEVEL_ID, l.getLevel_id());
        values.put(COLUMN_LEVEL_NAME, l.getLevelname());
        values.put(COLUMN_LESSON, l.getLesson());
        values.put(COLUMN_TIP, l.getTip());
        database.insert(TABLE_LEVEL, null, values);
    }

    public void addQuestion(ClassQuestion q) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_ID, q.getQuestion_id());
        values.put(COLUMN_QUESTION_TEXT, q.getQuestion_text());
        values.put(COLUMN_LEVEL_ID, q.getLevel_id());
        database.insert(TABLE_QUESTIONS, null, values);
    }

    public void addAnswer(ClassAnswer a) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ANSWER_ID, a.getAnswer_id());
        values.put(COLUMN_ANSWER_TEXT, a.getAnswer_text());
        values.put(COLUMN_QUESTION_ID, a.getQuestion_id());
        values.put(COLUMN_ANSWER_STATE, a.getAnswer_state());
        database.insert(TABLE_ANSWERS, null, values);
    }

    public long addUser(ClassUser user) {
        long iduser = 0;

        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASS, user.getPass());
        values.put(COLUMN_AVATAR, user.getAvatar());

        iduser = database.insert(TABLE_USERS, null, values);

        ClassScoreboard score = new ClassScoreboard(iduser, 0, 0, 1);
        this.addScore(score);

        return iduser;
    }

    public boolean addScore(ClassScoreboard score) {

        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USER_ID, score.getUser_id());
        values.put(COLUMN_POINTS, score.getPoints());
        values.put(COLUMN_WRONG_NUMBER, score.getWrong_number());
        values.put(COLUMN_LEVEL_ID, score.getLevel_id());
        database.insert(TABLE_SCOREBOARD, null, values);

        return true;
    }
    //Ver o uso desse method.
    public boolean addScoreboardScreen(ScoreboardScreen scoreboard) {
        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USERNAME, scoreboard.getUserName());
        values.put(COLUMN_LEVEL_NAME, scoreboard.getLevelName());
        values.put(COLUMN_POINTS, scoreboard.getPoints());
        values.put(COLUMN_WRONG_NUMBER, scoreboard.getWrongPerc());
        database.insert(TABLE_SCOREBOARD_SCREEN, null, values);
        return true;
    }

    /*
       All methods to recovery information from the database.
                                                             */
    public List<ClassQuestion> levelQuestion(int levelID) {
        List<ClassQuestion> questionsList = new ArrayList<>();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_LEVEL_ID + " = '" + Integer.toString(levelID) + "' ; ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                ClassQuestion levelQuestion = new ClassQuestion();
                levelQuestion.setQuestion_id(cursor.getString(0));
                levelQuestion.setQuestion_text(cursor.getString(1));
                levelQuestion.setLevel_id(cursor.getInt(2));
                questionsList.add(levelQuestion);
            } while (cursor.moveToNext());
        }

        return questionsList;
    }

    public List<ClassAnswer> getAnswer(String qid) {
        List<ClassAnswer> Answerlist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ANSWERS + " WHERE " + COLUMN_QUESTION_ID + " = '" + qid + "' ;";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ClassAnswer answers = new ClassAnswer();
                answers.setAnswer_id(cursor.getString(0));
                answers.setAnswer_text(cursor.getString(1));
                answers.setQuestion_id(cursor.getString(2));
                answers.setAnswer_state(cursor.getInt(3));
                Answerlist.add(answers);
            } while (cursor.moveToNext());
        }
        return Answerlist;
    }

    public List<ClassUser> getAllUsers() {
        List<ClassUser> usersList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS + ";";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ClassUser user = new ClassUser();
                user.setUser_id(cursor.getLong(0));
                user.setUsername(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPass(cursor.getString(3));
                user.setAvatar(cursor.getString(4));
                usersList.add(user);
            } while (cursor.moveToNext());
        }
        return usersList;
    }

    public ClassScoreboard getScore(long UserID) {
        ClassScoreboard scoreobj = new ClassScoreboard();
        Cursor cursor;
        String UserString = Integer.toString((int) UserID);
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ;";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            scoreobj.setUser_id(cursor.getInt(0));
            scoreobj.setPoints(cursor.getInt(1));
            scoreobj.setWrong_number(cursor.getInt(2));
            scoreobj.setLevel_id(cursor.getInt(3));
        }
        return scoreobj;
    }

    public ClassLevel getLevel(int levelID) {
        ClassLevel levelobj = new ClassLevel();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_LEVEL + " WHERE " + COLUMN_LEVEL_ID + " = '" + Integer.toString(levelID) + "' ; ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            levelobj.setLevel_id(cursor.getInt(0));
            levelobj.setLevelname(cursor.getString(1));
            levelobj.setLesson(cursor.getString(2));
            levelobj.setTip(cursor.getString(3));
        }
        return levelobj;
    }

    //Ver o uso desse method.
    public ArrayList<ScoreboardScreen> getScoreboardTable() {
        ArrayList<ScoreboardScreen> scoreList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD_SCREEN + " ORDER BY " + COLUMN_POINTS + " DESC, " + COLUMN_WRONG_NUMBER + " ASC ;";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ScoreboardScreen scoreboard = new ScoreboardScreen();
                scoreboard.setUserName(cursor.getString(0));
                scoreboard.setLevelName(cursor.getString(1));
                scoreboard.setPoints(Integer.parseInt(cursor.getString(2)));
                scoreboard.setWrongPerc(Double.parseDouble(cursor.getString(3)));
                scoreList.add(scoreboard);
            } while (cursor.moveToNext());
        }
        return scoreList;
    }


    /*
     All methods to update the information in the database.
                                                            */
    public boolean updatingScore(int score, ClassUser User, int levelID) {
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + Long.toString(User.getUser_id()) + "' ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        ContentValues values;
        values = new ContentValues();
        if (cursor.moveToFirst()) {
            values.put(COLUMN_USER_ID, cursor.getInt(0));
            values.put(COLUMN_POINTS, score);
            values.put(COLUMN_WRONG_NUMBER, cursor.getInt(2));
            values.put(COLUMN_LEVEL_ID, levelID);
        }

        database = this.getWritableDatabase();
        database.update(TABLE_SCOREBOARD, values, COLUMN_USER_ID + "= ?", new String[]{Integer.toString((int) User.getUser_id())});
        return true;
    }

    public boolean updatingWrongScore(Integer wScore, ClassUser User) {
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + Long.toString(User.getUser_id()) + "' ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        ContentValues values;
        values = new ContentValues();
        if (cursor.moveToFirst()) {
            values.put(COLUMN_USER_ID, cursor.getInt(0));
            values.put(COLUMN_POINTS, cursor.getInt(1));
            values.put(COLUMN_WRONG_NUMBER, wScore);
            values.put(COLUMN_LEVEL_ID, cursor.getInt(3));
        }

        database = this.getWritableDatabase();
        database.update(TABLE_SCOREBOARD, values, COLUMN_USER_ID + "= ?", new String[]{Integer.toString((int) User.getUser_id())});
        return true;

    }


    //Ver o uso desse method.
    public boolean deleteScoreboardTable() {
        database.delete(TABLE_SCOREBOARD_SCREEN, null, null);
        return true;
    }

    /*
        public String getUserLevel(Long userID) {
        String selectQuery = "SELECT " + COLUMN_LEVEL_NAME + " FROM " + TABLE_LEVEL + " WHERE " + COLUMN_LEVEL_ID + " IN ( SELECT " + COLUMN_LEVEL_ID + " FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + userID.toString() + "' );";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        String levelName = "vazio";
        if (cursor.moveToFirst()) {
            levelName = cursor.getString(0);
        }
        return levelName;
    }
    public boolean lessonStart(String chosenLevelID, Long userID) {
        String selectQuery = "SELECT u." + COLUMN_ID + " FROM " + TABLE_USERS_ACT
                + " AS u INNER JOIN " + TABLE_QUESTIONS + " AS q ON u."
                + COLUMN_QUESTION_ID + " = q." + COLUMN_QUESTION_ID
                + " INNER JOIN " + TABLE_LEVEL + " AS l ON q."
                + COLUMN_LEVEL_ID + " = l." + COLUMN_LEVEL_ID
                + " WHERE u." + COLUMN_USER_ID + " = " + userID.toString() + " AND l." + COLUMN_LEVEL_ID + " = '" + chosenLevelID + "' ;";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.getCount() > 0) {
            return true;
        }
        return false;
    }*/

}

