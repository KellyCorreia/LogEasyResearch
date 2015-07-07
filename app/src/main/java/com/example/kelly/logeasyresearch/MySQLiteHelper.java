package com.example.kelly.logeasyresearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 03/04/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_QUESTIONS = "table_questions";
    public static final String COLUMN_QUESTION_ID = "Q_id";
    public static final String COLUMN_QUESTION_TEXT = "Q_text";
    public static final String COLUMN_RIGHT_ANSWER = "right_A";
    public static final String COLUMN_LEVEL_ID = "L_id";
    private static final String QUESTIONS_DATABASE_CREATE = "create table "
            + TABLE_QUESTIONS + "(" + COLUMN_QUESTION_ID
            + " text primary key, " + COLUMN_QUESTION_TEXT
            + " text not null, " + COLUMN_LEVEL_ID
            + " text not null, " + COLUMN_RIGHT_ANSWER
            + " text not null);";
    public static final String TABLE_USERS_ACT = "users_activity";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER_ID = "user_id";
    // + Q_id
    public static final String COLUMN_WRONG_YN = "wrong_YN";
    public static final String COLUMN_DATE = "date";
    public static final String TABLE_ANSWERS = "table_answers";
    public static final String COLUMN_ANSWER_ID = "A_id";
    private static final String USERS_ACT_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_USERS_ACT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_USER_ID
            + " integer not null, " + COLUMN_QUESTION_ID
            + " text, " + COLUMN_ANSWER_ID
            + " text, " + COLUMN_DATE
            + " text);";
    // + Q_id
    public static final String COLUMN_ANSWER_TEXT = "A_text";
    private static final String ANSWERS_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_ANSWERS + "(" + COLUMN_ANSWER_ID
            + " text primary key, " + COLUMN_ANSWER_TEXT
            + " text not null, " + COLUMN_QUESTION_ID
            + " text not null);";
    public static final String TABLE_USERS = "table_users";
    //user_id;
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "password";
    public static final String COLUMN_POINTS = "points";
    public static final String COLUMN_WRONG_PERCENT = "wrong_percent";
    public static final String COLUMN_AVATAR = "avatar";
    private static final String USERS_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_USERS + "(" + COLUMN_USER_ID
            + " integer primary key autoincrement, " + COLUMN_USERNAME
            + " text not null, " + COLUMN_EMAIL
            + " text not null, " + COLUMN_PASS
            + " text not null, " + COLUMN_AVATAR
            + " text);";
    public static final String TABLE_SCOREBOARD = "table_scoreboard";
    private static final String SCOREBOARD_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_SCOREBOARD + "(" + COLUMN_USER_ID
            + " integer primary key, " + COLUMN_POINTS
            + " integer, " + COLUMN_WRONG_PERCENT
            + " integer, " + COLUMN_LEVEL_ID
            + " text);";
    public static final String TABLE_LEVEL = "table_level";
    public static final String COLUMN_LEVEL_NAME = "l_name";
    public static final String COLUMN_LESSON = "lesson";
    public static final String COLUMN_TIP = "tip";
    private static final String LEVEL_DATABASE_CREATE = "CREATE TABLE "
            + TABLE_LEVEL + "(" + COLUMN_LEVEL_ID
            + " text primary key, " + COLUMN_LEVEL_NAME
            + " text not null, " + COLUMN_LESSON
            + " text," + COLUMN_TIP
            + " text);";
    public static final String TABLE_SCOREBOARD_SCREEN = "table_scoreboard_screen";

    // Database creation sql statement
    public static final String COLUMN_USERNAME_SCOREBOARD = "user_name";
    public static final String COLUMN_LEVELNAME_SCOREBOARD = "level_name";
    public static final String COLUMN_POINTS_SCOREBOARD = "user_points";
    public static final String COLUMN_WRONGPERC_SCOREBOARD = "user_wrongperc";
    private static final String SCOREBOARD_SCREEN_DATABASE_CREATE = "create table "
            + TABLE_SCOREBOARD_SCREEN + "(" + COLUMN_USERNAME_SCOREBOARD
            + " text primary key, " + COLUMN_LEVELNAME_SCOREBOARD
            + " text, " + COLUMN_POINTS_SCOREBOARD
            + " text, " + COLUMN_WRONGPERC_SCOREBOARD
            + " text);";
    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;
    //OR:     private SQLiteDatabase dbase;
    public SQLiteDatabase database = this.getWritableDatabase();


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        db.execSQL(QUESTIONS_DATABASE_CREATE);
        db.execSQL(USERS_ACT_DATABASE_CREATE);
        db.execSQL(USERS_DATABASE_CREATE);
        db.execSQL(ANSWERS_DATABASE_CREATE);
        db.execSQL(SCOREBOARD_DATABASE_CREATE);
        db.execSQL(LEVEL_DATABASE_CREATE);
        db.execSQL(SCOREBOARD_SCREEN_DATABASE_CREATE);
        addQuestions();
        addAnswers();
        addLevels();
    }

    private void addQuestions() {
        QuestionClass q1 = new QuestionClass("Q001", "Which one is the contradictory of the " +
                "following claim: \n “Sometimes the wind is blowing hard.”", "L01", "A001c");
        this.addQuestion(q1);

        QuestionClass q2 = new QuestionClass("Q002", "Which one is the contradictory of the " +
                "following statement: \n “The wind is blowing all the time.”", "L01", "A002b");
        this.addQuestion(q2);

        QuestionClass q3 = new QuestionClass("Q003", "Which one of the following sentences becomes " +
                "true after applying the NOT operator.", "L01", "A003c");
        this.addQuestion(q3);

        QuestionClass q4 = new QuestionClass("Q004", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A004b");
        this.addQuestion(q4);

        QuestionClass q5 = new QuestionClass("Q005", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A005b");
        this.addQuestion(q5);

        QuestionClass q6 = new QuestionClass("Q006", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A006a");
        this.addQuestion(q6);

        QuestionClass q7 = new QuestionClass("Q007", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A007a");
        this.addQuestion(q7);

        QuestionClass q8 = new QuestionClass("Q008", "Which one is the contradictory of the following" +
                " statement: \n “The wind has no direction.”", "L01", "A008a");
        this.addQuestion(q8);

        QuestionClass q9 = new QuestionClass("Q009", "Which one is the contradictory of the following" +
                " claim: \n “The wind’s direction is North.”", "L01", "A009b");
        this.addQuestion(q9);

        QuestionClass q10 = new QuestionClass("Q010", "Which one is the contradictory of the following" +
                " sentence: \n “Some breeze is a light wind.”", "L01", "A010a");
        this.addQuestion(q10);

        QuestionClass q11 = new QuestionClass("Q011", "Given: a = “The sound is a vibration” is  " +
                "true and b = “The sound is not a wave” is false. Which of the following is true:", "L02", "A011c");
        this.addQuestion(q11);

        QuestionClass q12 = new QuestionClass("Q012", "Given: a = “The sound propagates through the air”" +
                " is true. Which of the following is false:", "L02", "A012b");
        this.addQuestion(q12);

        QuestionClass q13 = new QuestionClass("Q013", "Given: a = “The sound propagates through solids”" +
                " is true and b = “The sound is not a vibration” is false. Which of the following is true:", "L02", "A013b");
        this.addQuestion(q13);

        QuestionClass q14 = new QuestionClass("Q014", "Given: “The speed of the sound is 972m/s” is " +
                "true and “Sound propagates through the air”. Considering the exclusive “or”. Which " +
                "of the following is true:", "L02", "A014c");
        this.addQuestion(q14);

        QuestionClass q15 = new QuestionClass("Q015", "Given: a = “All sound come from a vibrating " +
                "source” is true and b = “Sound can be heard” is true. Which os the following is true:", "L02", "A015a");
        this.addQuestion(q15);

        QuestionClass q16 = new QuestionClass("Q016", "Given: a = “Sound cannot be heard” is false " +
                "and b = “Sound is a current of air” is false. Which os the following is false:", "L02", "A016c");
        this.addQuestion(q16);

        QuestionClass q17 = new QuestionClass("Q017", "Given: a = “Music is a combination of sounds”" +
                " is true. Which os the following is false:", "L02", "A017b");
        this.addQuestion(q17);

        QuestionClass q18 = new QuestionClass("Q018", "Given: a = “Music is a combination of sounds”" +
                " is true,  b = “Sound is a current of air” is false and c = “All sound come from a" +
                " vibrating source” is true. Which one of the following is true:", "L02", "A018b");
        this.addQuestion(q18);

        QuestionClass q19 = new QuestionClass("Q019", "Given: a = “Sound cannot be heard” is false" +
                " and b = “All sound come from a vibrating source” is true. Which of the following " +
                "is true:", "L02", "A019c");
        this.addQuestion(q19);

        QuestionClass q20 = new QuestionClass("Q020", "Given: a = “Music is a combination of sound " +
                "and silence” is true, b = “A very strong sound forms a tornado” is false and c = " +
                "“Sound is not a wave” is false. Which of the following is true:", "L02", "A020a");
        this.addQuestion(q20);

        QuestionClass q21 = new QuestionClass("Q021", "Given:  a = “The earth is full of metals” is" +
                " true and b = “Gold is a metal” is true.  Which of the following is false:", "L03", "A021c");
        this.addQuestion(q21);

        QuestionClass q22 = new QuestionClass("Q022", "Which one of the following propositions is true:", "L03", "A022b");
        this.addQuestion(q22);

        QuestionClass q23 = new QuestionClass("Q023", "Given: a = “All metals are found in the earth”" +
                " is true and b = “Silver is a crystal” is false. Which one of the following is false.", "L03", "A023b");
        this.addQuestion(q23);

        QuestionClass q24 = new QuestionClass("Q024", "Given: a = “Gold is more expensive than silver”" +
                " is true and b = “Both gold and silver are metals” is true. Which one of the following" +
                " is true.", "L03", "A024b");
        this.addQuestion(q24);

        QuestionClass q25 = new QuestionClass("Q025", "Given: a = “Gold is a gemstone” and  b = “Ruby" +
                " is a metal” both are false. Which one of the following is true:", "L03", "A025a");
        this.addQuestion(q25);

        QuestionClass q26 = new QuestionClass("Q026", "Given: a = “Silver is a stone” is false and b" +
                " = “All metals are found in the earth” is true. Which one of the following is false:", "L03", "A026c");
        this.addQuestion(q26);

        QuestionClass q27 = new QuestionClass("Q027", "Given: “All metals are found in the earth and " +
                "gold is a metal” is true and “Ruby is a stone or gold is a stone” is true. Which one of " +
                "the following is true:", "L03", "A027b");
        this.addQuestion(q27);

        QuestionClass q28 = new QuestionClass("Q028", "Given: “Silver is a precious metal and gold is not" +
                " a stone” is true. Which one of the following is true:", "L03", "A028a");
        this.addQuestion(q28);

        QuestionClass q29 = new QuestionClass("Q029", "Given: “Iron is a metal”  is true. Which one of the following is false:", "L03", "A029a");
        this.addQuestion(q29);

        QuestionClass q30 = new QuestionClass("Q030", "Given: “Gold is the most expensive metal” is true " +
                "and “Silver is a metal” is true. Which one of the following is false:", "L03", "A030c");
        this.addQuestion(q30);

        QuestionClass q31 = new QuestionClass("Q031", "Which one of the following is the contradictory" +
                " of A: Sandy soil is ideal for crops and farming.", "L04", "A031a");
        this.addQuestion(q31);

        QuestionClass q32 = new QuestionClass("Q032", "Which one of the following is the contradictory " +
                "of A: Wild beaches are undiscovered and you can’t find any hotels nearby.", "L04", "A032b");
        this.addQuestion(q32);

        QuestionClass q33 = new QuestionClass("Q033", "Which one of the following is the contradictory" +
                " of A: Some beaches are formed along an ocean and they don’t have life guards posts.", "L04", "A033c");
        this.addQuestion(q33);

        QuestionClass q34 = new QuestionClass("Q034", "Which of the following is the contradictory of A:" +
                " Performance artists draw images in sand and this type of art is called sand animation.", "L04", "A034a");
        this.addQuestion(q34);

        QuestionClass q35 = new QuestionClass("Q035", "Which of the following is the contradictory" +
                " of A: Sand is composed by rock and mineral particles.\n", "L04", "A035c");
        this.addQuestion(q35);

        QuestionClass q36 = new QuestionClass("Q036", "Given A: Only the sandy beaches are visited by" +
                " tourist and this is a fact. - true. Which one is the contradictory of A from the following:", "L04", "A036b");
        this.addQuestion(q36);

        QuestionClass q37 = new QuestionClass("Q037", "Given A: Sand is finer than gravel and coarser " +
                "than silt. Which one is the contradictory of A from the following compound claims:", "L04", "A037c");
        this.addQuestion(q37);

        QuestionClass q38 = new QuestionClass("Q038", "Given the contradictory of A: A common type of " +
                "sand was not created by coral or shellfish. Please choose A from the following:", "L04", "A038b");
        this.addQuestion(q38);

        QuestionClass q39 = new QuestionClass("Q039", "Given the contradictory of B: Sand and water table " +
                "are fun in the back garden or in the livingroom . Find the compound claim B:", "L04", "A039b");
        this.addQuestion(q39);

        QuestionClass q40 = new QuestionClass("Q040", "Given the contradictory of B: In the back garden, " +
                "children cannot play with sand or water. Find the compound claim B:", "L04", "A040a");
        this.addQuestion(q40);

        QuestionClass q41 = new QuestionClass("Q041", "Which one of the following is the contradictory " +
                "of A: Precipitations can fall in form of ice crystals or in snow.", "L05", "A041a");
        this.addQuestion(q41);

        QuestionClass q42 = new QuestionClass("Q042", "Which one of the following is the contradictory " +
                "of C: not (A or B). A: Snow has a fluffy structure. B: Snow is composed of small ice particles.", "L05", "A042b");
        this.addQuestion(q42);

        QuestionClass q43 = new QuestionClass("Q043", "Given: A: Snow has an open and soft structure." +
                " Which one of the following is the contradictory of A:", "L05", "A043c");
        this.addQuestion(q43);

        QuestionClass q44 = new QuestionClass("Q044", "Given: A: not (B or C); B: Snow is precipitation in form of " +
                "ice flakes; C: Snow has a soft structure.  Which one of the following represents A:", "L05", "A044c");
        this.addQuestion(q44);

        QuestionClass q45 = new QuestionClass("Q045", "Given: ¬(A v B): Water cannot fall from the clouds in form of " +
                "snow neither ice crystals. Which of the following represents A and B:", "L05", "A045a");
        this.addQuestion(q45);

        QuestionClass q46 = new QuestionClass("Q046", "Which one of the following is the contradictory of AvB. " +
                "Given: A: Snow is formed by small ice particles; B: Snowflakes come in a variety of sizes and shapes.", "L05", "A046a");
        this.addQuestion(q46);

        QuestionClass q47 = new QuestionClass("Q047", "Which one of the following is the contradictory " +
                "of A. Given: A: Snow has an open or soft structure.", "L05", "A047c");
        this.addQuestion(q47);

        QuestionClass q48 = new QuestionClass("Q048", "Which one of the following is the contradictory of A: " +
                "Snow falls from the clouds or the process of precipitating snow is called snowfall.", "L05", "A048a");
        this.addQuestion(q48);

        QuestionClass q49 = new QuestionClass("Q049", "Which one of the following is the contradictory of A: " +
                "Snow does not fall from the clouds or the process of precipitating snow is not called snowfall.", "L05", "A049b");
        this.addQuestion(q49);

        QuestionClass q50 = new QuestionClass("Q050", "Which one of the following is the contradictory A: " +
                "Snow has a fluffy structure or it is composed of small ice particles.", "L05", "A050c");
        this.addQuestion(q50);

        QuestionClass q51 = new QuestionClass("Q051", "Given: A: The plants grow fast. and B: Amy waters" +
                " the plants everyday. Which of the following represents if A then B:", "L06", "A051c");
        this.addQuestion(q51);

        QuestionClass q52 = new QuestionClass("Q052", "Given: A: If flowers grow from seeds then they are plants " +
                ": True. Which one of the following is false:", "L06", "A052a");
        this.addQuestion(q52);

        QuestionClass q53 = new QuestionClass("Q053", "Consider A: Plants obtain energy if exposed to " +
                "sunlight. Please select the false statement from the following:", "L06", "A053c");
        this.addQuestion(q53);

        QuestionClass q54 = new QuestionClass("Q054", "Please select the antecedent from the following" +
                " claim: B = Otherwise, plants will not survive on this planet.", "L06", "A054b");
        this.addQuestion(q54);

        QuestionClass q55 = new QuestionClass("Q055", "Please select the antecedent from the following" +
                " claim: C = Don’t water the flowers for a month and you won’t have them anymore.", "L06", "A055c");
        this.addQuestion(q55);

        QuestionClass q56 = new QuestionClass("Q056", "Please select the consequent from the following" +
                " claim: A = Anyone who loves plants deserves a planthouse.", "L06", "A056b");
        this.addQuestion(q56);

        QuestionClass q57 = new QuestionClass("Q057", "Please select the consequent from the following" +
                " claim: B = Visit us and you will get a free green plant pot.", "L06", "A057a");
        this.addQuestion(q57);

        QuestionClass q58 = new QuestionClass("Q058", "Consider A: House plants won’t grow if over-watered" +
                " or under-watered. Please select the false statement from the following:", "L06", "A058a");
        this.addQuestion(q58);
        //two questions skipped

        QuestionClass q61 = new QuestionClass("Q061", "Please select the contradictory of A: If lightning" +
                " strikes then you can hear it.", "L07", "A061a");
        this.addQuestion(q61);

        QuestionClass q62 = new QuestionClass("Q062", "Please select the contradictory of A: If the electric" +
                " field is strong enough, a positive streamer can develop from those points.", "L07", "A062b");
        this.addQuestion(q62);

        QuestionClass q63 = new QuestionClass("Q063", "Which one of the following is the contradictory of C:" +
                " If a lightning hits an object on the ground it is called a strike.", "L07", "A063a");
        this.addQuestion(q63);

        QuestionClass q64 = new QuestionClass("Q064", "Which one of the following is the contradictory" +
                " of A: If a lightning hits an object, the object will burn.", "L07", "A064c");
        this.addQuestion(q64);

        QuestionClass q65 = new QuestionClass("Q065", "Which one of the following is the contradictory" +
                " of B: If the house is on fire then only fire department can save lives.", "L07", "A065c");
        this.addQuestion(q65);

        QuestionClass q66 = new QuestionClass("Q066", "Which one of the following is the contradictory " +
                "of C: If there is a storm then some lightnings are pretty spectacular.", "L07", "A066c");
        this.addQuestion(q66);

        QuestionClass q67 = new QuestionClass("Q067", "Which one of the following is the contradictory of " +
                "B: If lightning strikes a person, it is usually fatal.", "L07", "A067a");
        this.addQuestion(q67);

        QuestionClass q68 = new QuestionClass("Q068", "Which one of the following is the contradictory " +
                "of A: If somebody has a fear of thunder or lightning, they may have astraphobia.", "L07", "A068b");
        this.addQuestion(q68);

        QuestionClass q69 = new QuestionClass("Q069", "Which one of the following is the contradictory of " +
                "C: You will learn more about lightning if you study fulminology.", "L07", "A069c");
        this.addQuestion(q69);

        QuestionClass q70 = new QuestionClass("Q070", "Which one of the following is the contradictory " +
                "of A: Some people can hear the thunder if the distance is less than 20 kilometres.", "L07", "A070a");
        this.addQuestion(q70);

        QuestionClass q71 = new QuestionClass("Q071", "Please select the false relationship for the following " +
                "compound claim: Lava is expelled only if a volcano erupts.", "L08", "A071b");
        this.addQuestion(q71);

        QuestionClass q72 = new QuestionClass("Q072", "Please select the false relationship for the following" +
                " compound claim: Lava stops moving if and only if it solidifies.", "L08", "A072c");
        this.addQuestion(q72);

        QuestionClass q73 = new QuestionClass("Q073", "Please select the true relationship for the following" +
                " compound claim: The speed of the lava is higher if and only if the viscosity is lower.", "L08", "A073a");
        this.addQuestion(q73);

        QuestionClass q74 = new QuestionClass("Q074", "Given: Magma becomes lava if and only if it is exposed" +
                " to the surface. Please fill in the dots with the adecvate statement. \n \tIf magma becomes" +
                " lava then it is exposed to the surface and …", "L08", "A074a");
        this.addQuestion(q74);

        QuestionClass q75 = new QuestionClass("Q075", "Please select the equivalence statement:\n" +
                "\tRocks melt if they reach the melting point and when they reach the melting point, rocks melt.", "L08", "A075a");
        this.addQuestion(q75);
        //5 questions skipped

        QuestionClass q81 = new QuestionClass("Q081", "Please select the contrapositive for the following " +
                "statement: In order to save the forest you must stop the wildfire spreading. ", "L09", "A081c");
        this.addQuestion(q81);

        QuestionClass q82 = new QuestionClass("Q082", "Please select the statement that has the following" +
                " contrapositive: If predators did not existed then the village would have been safe.", "L09", "A082a");
        this.addQuestion(q82);

        QuestionClass q83 = new QuestionClass("Q083", "Please select the contrapositive for the following statement:" +
                " Battle training is crucial in order to win the war.", "L09", "A083a");
        this.addQuestion(q83);

        QuestionClass q84 = new QuestionClass("Q084", "Please select the statement that has the following contrapositive:" +
                " If no flooding occurred then the village is not in danger.", "L09", "A084b");
        this.addQuestion(q84);

        QuestionClass q85 = new QuestionClass("Q085", "Please select the statement that has the following contrapositive:" +
                " If some villages are not under attack then the world is safe.", "L09", "A085a");
        this.addQuestion(q85);

        QuestionClass q86 = new QuestionClass("Q086", "Please select the contrapositive for the following statement:" +
                " If somebody will help them, the village people won’t lose everything.", "L09", "A086c");
        this.addQuestion(q86);
        //4 questions skipped

        QuestionClass q91 = new QuestionClass("Q091", "Please select the inference that derive from the following premises:\n" +
                "p: Heroes are people.\n" + "q: People are giving random acts of kindness.", "L10", "A091a");
        this.addQuestion(q91);

        QuestionClass q92 = new QuestionClass("Q092", "Please select the inference that derive from the following premises:\n" +
                "p: In order to save the world you need to be a hero.\n" + "q. Everyone can be a hero", "L10", "A092b");
        this.addQuestion(q92);

        QuestionClass q93 = new QuestionClass("Q093", "Please select the inference that derive from the following premises:\n" +
                "p: If the world is threatened then superheroes will react.\n" + "q: Superheroes are not reacting.\n", "L10", "A093c");
        this.addQuestion(q93);

        QuestionClass q94 = new QuestionClass("Q094", "Please select the inference that derive from the following premises:\n" +
                "p: If you have super powers you are a superhero.\n" + "q: If you don’t have super powers than you are human.\n" +
                "r: If you are a superhero then you need to save the world.", "L10", "A094b");
        this.addQuestion(q94);


    }

    private void addAnswers() {
        AnswerClass a1 = new AnswerClass("A001a", "The wind is not blowing hard.", "Q001");
        this.addAnswer(a1);

        AnswerClass a2 = new AnswerClass("A001b", "Sometimes the wind is not blowing hard.", "Q001");
        this.addAnswer(a2);

        AnswerClass a3 = new AnswerClass("A001c", "The wind is never blowing hard.", "Q001");
        this.addAnswer(a3);

        AnswerClass a4 = new AnswerClass("A002a", "The wind is not blowing.", "Q002");
        this.addAnswer(a4);

        AnswerClass a5 = new AnswerClass("A002b", "Sometimes the wind is not blowing.", "Q002");
        this.addAnswer(a5);

        AnswerClass a6 = new AnswerClass("A002c", "The wind is never blowing.", "Q002");
        this.addAnswer(a6);

        AnswerClass a7 = new AnswerClass("A003a", "The wind can change directions.", "Q003");
        this.addAnswer(a7);

        AnswerClass a8 = new AnswerClass("A003b", "The wind is blowing in the same direction.", "Q003");
        this.addAnswer(a8);

        AnswerClass a9 = new AnswerClass("A003c", "The wind can never change directions.", "Q003");
        this.addAnswer(a9);

        AnswerClass a10 = new AnswerClass("A004a", "The wind has the power to destroy houses", "Q004");
        this.addAnswer(a10);

        AnswerClass a11 = new AnswerClass("A004b", "The wind can sometimes destroy houses.", "Q004");
        this.addAnswer(a11);

        AnswerClass a12 = new AnswerClass("A004c", "The wind can destroy houses.", "Q004");
        this.addAnswer(a12);

        AnswerClass a13 = new AnswerClass("A005a", "The wind can blow hard.", "Q005");
        this.addAnswer(a13);

        AnswerClass a14 = new AnswerClass("A005b", "The wind blows hard all the time.", "Q005");
        this.addAnswer(a14);

        AnswerClass a15 = new AnswerClass("A005c", "The wind is not blowing hard.", "Q005");
        this.addAnswer(a15);

        AnswerClass a16 = new AnswerClass("A006a", "The houses may be destroyed by the wind.", "Q006");
        this.addAnswer(a16);

        AnswerClass a17 = new AnswerClass("A006b", "Some houses may be destroyed by the wind.", "Q006");
        this.addAnswer(a17);

        AnswerClass a18 = new AnswerClass("A006c", "Not all the houses can be destroyed by the wind.", "Q006");
        this.addAnswer(a18);

        AnswerClass a19 = new AnswerClass("A007a", "The wind’s direction never changes.", "Q007");
        this.addAnswer(a19);

        AnswerClass a20 = new AnswerClass("A007b", "The wind’s direction can change.", "Q007");
        this.addAnswer(a20);

        AnswerClass a21 = new AnswerClass("A007c", "The wind’s direction can change sometimes.", "Q007");
        this.addAnswer(a21);

        AnswerClass a22 = new AnswerClass("A008a", "The wind sometimes has a direction.", "Q008");
        this.addAnswer(a22);

        AnswerClass a23 = new AnswerClass("A008b", "The wind doesn’t have a direction.", "Q008");
        this.addAnswer(a23);

        AnswerClass a24 = new AnswerClass("A008c", "The wind’s direction exists.", "Q008");
        this.addAnswer(a24);

        AnswerClass a25 = new AnswerClass("A009a", "The wind’s direction is South.", "Q009");
        this.addAnswer(a25);

        AnswerClass a26 = new AnswerClass("A009b", "Sometimes the wind’s direction is not North.", "Q009");
        this.addAnswer(a26);

        AnswerClass a27 = new AnswerClass("A009c", "The wind’s direction is different.", "Q009");
        this.addAnswer(a27);

        AnswerClass a28 = new AnswerClass("A010a", "No breeze is a light wind.", "Q010");
        this.addAnswer(a28);

        AnswerClass a29 = new AnswerClass("A010b", "A breeze is sometimes a light wind.", "Q010");
        this.addAnswer(a29);

        AnswerClass a30 = new AnswerClass("A010c", "All breezes are light.", "Q010");
        this.addAnswer(a30);

        AnswerClass a31 = new AnswerClass("A011a", "The sound is a vibration and it is not a wave.", "Q011");
        this.addAnswer(a31);

        AnswerClass a32 = new AnswerClass("A011b", "The sound is not a vibration, but it is a wave.", "Q011");
        this.addAnswer(a32);

        AnswerClass a33 = new AnswerClass("A011c", "The sound is a vibration and it is a wave.", "Q011");
        this.addAnswer(a33);

        AnswerClass a34 = new AnswerClass("A012a", "The sound propagates through the air or it is not a wave.", "Q012");
        this.addAnswer(a34);

        AnswerClass a35 = new AnswerClass("A012b", "The sound doesn’t propagates through the air and it is a wave.", "Q012");
        this.addAnswer(a35);

        AnswerClass a36 = new AnswerClass("A012c", "The sound propagates through the air and it is a vibration.", "Q012");
        this.addAnswer(a36);

        AnswerClass a37 = new AnswerClass("A013a", "a ^ b", "Q013");
        this.addAnswer(a37);

        AnswerClass a38 = new AnswerClass("A013b", "a ^ ¬b", "Q013");
        this.addAnswer(a38);

        AnswerClass a39 = new AnswerClass("A013c", "¬a ^ b", "Q013");
        this.addAnswer(a39);

        AnswerClass a40 = new AnswerClass("A014a", "The speed of the sound is 972m/s or it propagates through the air.", "Q014");
        this.addAnswer(a40);

        AnswerClass a41 = new AnswerClass("A014b", "The speed of the sound is not 972m/s or it does not propagates through the air.", "Q014");
        this.addAnswer(a41);

        AnswerClass a42 = new AnswerClass("A014c", "The speed of the sound is 972m/s or it does not propagates through the air.", "Q014");
        this.addAnswer(a42);

        AnswerClass a43 = new AnswerClass("A015a", "a ^ b", "Q015");
        this.addAnswer(a43);

        AnswerClass a44 = new AnswerClass("A015b", "¬a ^ b", "Q015");
        this.addAnswer(a44);

        AnswerClass a45 = new AnswerClass("A015c", "a ^ ¬b", "Q015");
        this.addAnswer(a45);

        AnswerClass a46 = new AnswerClass("A016a", "a ^ b", "Q016");
        this.addAnswer(a46);

        AnswerClass a47 = new AnswerClass("A016b", "¬a ^ b", "Q016");
        this.addAnswer(a47);

        AnswerClass a48 = new AnswerClass("A016c", "¬a ^ ¬b", "Q016");
        this.addAnswer(a48);

        AnswerClass a49 = new AnswerClass("A017a", "Music is a combination of sounds and sound is a current of air.", "Q017");
        this.addAnswer(a49);

        AnswerClass a50 = new AnswerClass("A017b", "Music is not a combination of sounds and sound is a vibration. ", "Q017");
        this.addAnswer(a50);

        AnswerClass a51 = new AnswerClass("A017c", "Music is a combination of sounds and sound cannot be heard.", "Q017");
        this.addAnswer(a51);

        AnswerClass a52 = new AnswerClass("A018a", "a ^ b ^ c", "Q018");
        this.addAnswer(a52);

        AnswerClass a53 = new AnswerClass("A018b", "a ^ ¬b ^ c", "Q018");
        this.addAnswer(a53);

        AnswerClass a54 = new AnswerClass("A018c", "a ^ b ^ ¬c", "Q018");
        this.addAnswer(a54);

        AnswerClass a55 = new AnswerClass("A019a", "Sound can be heard and some sounds do not come from a vibrating source.", "Q019");
        this.addAnswer(a55);

        AnswerClass a56 = new AnswerClass("A019b", "All sound come from a vibrating source and sound cannot be heard.", "Q019");
        this.addAnswer(a56);

        AnswerClass a57 = new AnswerClass("A019c", "All sound come from a vibrating source and sound can be heard.", "Q019");
        this.addAnswer(a57);

        AnswerClass a58 = new AnswerClass("A020a", "Sound is a wave and a very strong sound does not form a tornado. ", "Q020");
        this.addAnswer(a58);

        AnswerClass a59 = new AnswerClass("A020b", "Music is a combination of sound and silence and a very strong sound forms a tornado.", "Q020");
        this.addAnswer(a59);

        AnswerClass a60 = new AnswerClass("A020c", "Sound is not a wave and music is a combination of sound and silence.", "Q020");
        this.addAnswer(a60);

        AnswerClass a61 = new AnswerClass("A021a", "a v b", "Q021");
        this.addAnswer(a61);

        AnswerClass a62 = new AnswerClass("A021b", "a v ¬b", "Q021");
        this.addAnswer(a62);

        AnswerClass a63 = new AnswerClass("A021c", "¬a v ¬b", "Q021");
        this.addAnswer(a63);

        AnswerClass a64 = new AnswerClass("A022a", "Gold is a metal and silver is not a metal.", "Q022");
        this.addAnswer(a64);

        AnswerClass a65 = new AnswerClass("A022b", "Gold is a metal or silver is not a metal.", "Q022");
        this.addAnswer(a65);

        AnswerClass a66 = new AnswerClass("A022c", "Gold is not a metal or silver is not a metal.", "Q022");
        this.addAnswer(a66);

        AnswerClass a67 = new AnswerClass("A023a", "Some metals are not found in the earth or silver is not a crystal.", "Q023");
        this.addAnswer(a67);

        AnswerClass a68 = new AnswerClass("A023b", "Some metals are not found in the earth or silver is a crystal. ", "Q023");
        this.addAnswer(a68);

        AnswerClass a69 = new AnswerClass("A023c", "Silver is a metal and all metal are found in the earth.", "Q023");
        this.addAnswer(a69);

        AnswerClass a70 = new AnswerClass("A024a", "Gold and silver are metals and silver is more expensive than gold.", "Q024");
        this.addAnswer(a70);

        AnswerClass a71 = new AnswerClass("A024b", "Gold is more expensive than silver or silver is not a metal.", "Q024");
        this.addAnswer(a71);

        AnswerClass a72 = new AnswerClass("A024c", "Silver is more expensive than gold or gold is not a metal.", "Q024");
        this.addAnswer(a72);

        AnswerClass a73 = new AnswerClass("A025a", "Gold is not a gemstone or ruby is a metal.", "Q025");
        this.addAnswer(a73);

        AnswerClass a74 = new AnswerClass("A025b", "Gold is a gemstone or ruby is a metal.", "Q025");
        this.addAnswer(a74);

        AnswerClass a75 = new AnswerClass("A025c", "Gold and Ruby are metals.", "Q025");
        this.addAnswer(a75);

        AnswerClass a76 = new AnswerClass("A026a", "¬a ^ b", "Q026");
        this.addAnswer(a76);

        AnswerClass a77 = new AnswerClass("A026b", "a v b", "Q026");
        this.addAnswer(a77);

        AnswerClass a78 = new AnswerClass("A026c", "a ^ b", "Q026");
        this.addAnswer(a78);

        AnswerClass a79 = new AnswerClass("A027a", "All metals are found in the earth and ruby is a stone.\n", "Q027");
        this.addAnswer(a79);

        AnswerClass a80 = new AnswerClass("A027b", "Gold is a metal or gold is stone.", "Q027");
        this.addAnswer(a80);

        AnswerClass a81 = new AnswerClass("A027c", "Gold is not a metal or a stone.", "Q027");
        this.addAnswer(a81);

        AnswerClass a82 = new AnswerClass("A028a", "Silver is a precious metal or gold is a stone.", "Q028");
        this.addAnswer(a82);

        AnswerClass a83 = new AnswerClass("A028b", "Silver is not a metal or gold is a stone.", "Q028");
        this.addAnswer(a83);

        AnswerClass a84 = new AnswerClass("A028c", "Gold and silver are metals.", "Q028");
        this.addAnswer(a84);

        AnswerClass a85 = new AnswerClass("A029a", "Gold is a metal, but iron is not.", "Q029");
        this.addAnswer(a85);

        AnswerClass a86 = new AnswerClass("A029b", "Iron is not a metal or gold is a metal", "Q029");
        this.addAnswer(a86);

        AnswerClass a87 = new AnswerClass("A029c", "Iron is a metal or gold is a metal.", "Q029");
        this.addAnswer(a87);

        AnswerClass a88 = new AnswerClass("A030a", "Or silver or gold is the most expensive metal.", "Q030");
        this.addAnswer(a88);

        AnswerClass a89 = new AnswerClass("A030b", "Gold and silver are the most expensive metals.", "Q030");
        this.addAnswer(a89);

        AnswerClass a90 = new AnswerClass("A030c", "Gold is not the most expensive metal or silver is not a metal.", "Q030");
        this.addAnswer(a90);

        AnswerClass a91 = new AnswerClass("A031a", "Sandy soil is not ideal for crops or for farming.", "Q031");
        this.addAnswer(a91);

        AnswerClass a92 = new AnswerClass("A031b", "Soil that is not sandy is ideal for crops or farming.", "Q031");
        this.addAnswer(a92);

        AnswerClass a93 = new AnswerClass("A031c", "Sandy soil is not ideal for crops nor for farming.", "Q031");
        this.addAnswer(a93);

        AnswerClass a94 = new AnswerClass("A032a", "Wild beaches are not undiscovered and you can’t find any hotels nearby.", "Q032");
        this.addAnswer(a94);

        AnswerClass a95 = new AnswerClass("A032b", "Wild beaches are not undiscovered but you can find some hotels nearby", "Q032");
        this.addAnswer(a95);

        AnswerClass a96 = new AnswerClass("A032c", "Beaches that are not wild are discovered or you can find hotels nearby.", "Q032");
        this.addAnswer(a96);

        AnswerClass a97 = new AnswerClass("A033a", "No beaches are formed along an ocean nor they have lifeguards posts.", "Q033");
        this.addAnswer(a97);

        AnswerClass a98 = new AnswerClass("A033b", "Some beaches are not formed along an ocean or do they have lifeguards posts.", "Q033");
        this.addAnswer(a98);

        AnswerClass a99 = new AnswerClass("A033c", "No beaches are formed along an ocean or they have lifeguards posts.", "Q033");
        this.addAnswer(a99);

        AnswerClass a100 = new AnswerClass("A034a", "Some performance artists do not draw images in sand or this type of art isn’t called sand animation.", "Q034");
        this.addAnswer(a100);

        AnswerClass a101 = new AnswerClass("A034b", "Some performance artists draw images in sand or this type of art  is not called sand animation.", "Q034");
        this.addAnswer(a101);

        AnswerClass a102 = new AnswerClass("A034c", "Performance artists don’t draw images in sand nor they called it sand animation.", "Q034");
        this.addAnswer(a102);

        AnswerClass a103 = new AnswerClass("A035a", "Sand is not composed by rock particles.", "Q035");
        this.addAnswer(a103);

        AnswerClass a104 = new AnswerClass("A035b", "Sand is composed by something else except rock and mineral particles.", "Q035");
        this.addAnswer(a104);

        AnswerClass a105 = new AnswerClass("A035c", "Sand is not composed by rock or by mineral particles. ", "Q035");
        this.addAnswer(a105);

        AnswerClass a106 = new AnswerClass("A036a", "No sandy beaches are visited and this is not a fact.", "Q036");
        this.addAnswer(a106);

        AnswerClass a107 = new AnswerClass("A036b", "Some tourists do not visit sandy beaches or this is not a fact. ", "Q036");
        this.addAnswer(a107);

        AnswerClass a108 = new AnswerClass("A036c", "Some tourists visit sandy beaches or this is a fact.", "Q036");
        this.addAnswer(a108);

        AnswerClass a109 = new AnswerClass("A037a", "Sand is not finer than gravel and coarser than silt.", "Q037");
        this.addAnswer(a109);

        AnswerClass a110 = new AnswerClass("A037b", "Sand is gravel than finer or silt than coarser.", "Q037");
        this.addAnswer(a110);

        AnswerClass a111 = new AnswerClass("A037c", "Sand is not finer than gravel or it is not coarser than silt.", "Q037");
        this.addAnswer(a111);

        AnswerClass a112 = new AnswerClass("A038a", "An uncommon type of sand was created by coral and shellfish.", "Q038");
        this.addAnswer(a112);

        AnswerClass a113 = new AnswerClass("A038b", "A common type of sand was created by coral and shellfish.", "Q038");
        this.addAnswer(a113);

        AnswerClass a114 = new AnswerClass("A038c", "A common type of sand was not created by coral or shellfish.", "Q038");
        this.addAnswer(a114);

        AnswerClass a115 = new AnswerClass("A039a", "Sand or water table are not fun in the back garden or in the livingroom.", "Q039");
        this.addAnswer(a115);

        AnswerClass a116 = new AnswerClass("A039b", "Sand and water table are not fun in the back garden and in the livingroom.", "Q039");
        this.addAnswer(a116);

        AnswerClass a117 = new AnswerClass("A039c", "Sand or water table are fun in the back garden or in the livingroom.", "Q039");
        this.addAnswer(a117);

        AnswerClass a118 = new AnswerClass("A040a", "In the back garden, children can play with sand and water.", "Q040");
        this.addAnswer(a118);

        AnswerClass a119 = new AnswerClass("A040b", "In the back garden, children cannot play with sand and water.", "Q040");
        this.addAnswer(a119);

        AnswerClass a120 = new AnswerClass("A040c", "In the back garden, children can play with sand or water.", "Q040");
        this.addAnswer(a120);

        AnswerClass a121 = new AnswerClass("A041a", "Precipitation cannot fall in form of ice crystals neither in form of snow.", "Q041");
        this.addAnswer(a121);

        AnswerClass a122 = new AnswerClass("A041b", "Precipitations cannot fall in form of ice or in form of snow.", "Q041");
        this.addAnswer(a122);

        AnswerClass a123 = new AnswerClass("A041c", "Precipitation can fall in form of snow but not ice crystals.", "Q041");
        this.addAnswer(a123);

        AnswerClass a124 = new AnswerClass("A042a", "Snow has a fluffy structure and it is composed of small ice particles.", "Q042");
        this.addAnswer(a124);

        AnswerClass a125 = new AnswerClass("A042b", "Snow is composed of small ice particles or it has a fluffy structure.", "Q042");
        this.addAnswer(a125);

        AnswerClass a126 = new AnswerClass("A042c", "Snow does not have a fluffy structure neither is composed of small ice particles.", "Q042");
        this.addAnswer(a126);

        AnswerClass a127 = new AnswerClass("A043a", "Snow does not have an open structure.", "Q043");
        this.addAnswer(a127);

        AnswerClass a128 = new AnswerClass("A043b", "Snow does not have a soft and open structure.", "Q043");
        this.addAnswer(a128);

        AnswerClass a129 = new AnswerClass("A043c", "Snow does not have a soft neither an open structure.", "Q043");
        this.addAnswer(a129);

        AnswerClass a130 = new AnswerClass("A044a", "Snow is not precipitation in form of ice flakes and it has no soft structure.", "Q044");
        this.addAnswer(a130);

        AnswerClass a131 = new AnswerClass("A044b", "Snow is precipitation in form of ice flakes and it has a soft structure.\n", "Q044");
        this.addAnswer(a131);

        AnswerClass a132 = new AnswerClass("A044c", "The structure of snow is not soft and it is not precipitation in form of ice flakes.", "Q044");
        this.addAnswer(a132);

        AnswerClass a133 = new AnswerClass("A045a", "Water can fall from the clouds in form of snow and ice crystals.", "Q045");
        this.addAnswer(a133);

        AnswerClass a134 = new AnswerClass("A045b", "Water can fall from the clouds in form of snow or ice crystals.", "Q045");
        this.addAnswer(a134);

        AnswerClass a135 = new AnswerClass("A045c", "Water cannot fall from the clouds in form of snow and ice crystals.", "Q045");
        this.addAnswer(a135);

        AnswerClass a136 = new AnswerClass("A046a", "Snowflakes do not come in a variety of sizes and shapes neither snow is formed by small ice particles.", "Q046");
        this.addAnswer(a136);

        AnswerClass a137 = new AnswerClass("A046b", "Snowflakes do not come in a variety of sizes and shapes and snow is formed by small ice particles.", "Q046");
        this.addAnswer(a137);

        AnswerClass a138 = new AnswerClass("A046c", "Snowflakes do not come in a variety of sizes and shapes or snow is formed by small ice particles.", "Q046");
        this.addAnswer(a138);

        AnswerClass a139 = new AnswerClass("A047a", "Snow does not have an open and soft structure.", "Q047");
        this.addAnswer(a139);

        AnswerClass a140 = new AnswerClass("A047b", "Snow does not have a soft structure.", "Q047");
        this.addAnswer(a140);

        AnswerClass a141 = new AnswerClass("A047c", "Snow does not have an open neither a soft structure.", "Q047");
        this.addAnswer(a141);

        AnswerClass a142 = new AnswerClass("A048a", "Snow does not fall from the clouds and the process of precipitating snow is not called snowfall.", "Q048");
        this.addAnswer(a142);

        AnswerClass a143 = new AnswerClass("A048b", "The process of precipitating snow is not called snowfall or snow does not fall from the clouds.", "Q048");
        this.addAnswer(a143);

        AnswerClass a144 = new AnswerClass("A048c", "The process of precipitating snow is not called snowfall and snow fall from the clouds.", "Q048");
        this.addAnswer(a144);

        AnswerClass a145 = new AnswerClass("A049a", "Snow does not fall from the clouds and the process of precipitating snow is not called snowfall.\n", "Q049");
        this.addAnswer(a145);

        AnswerClass a146 = new AnswerClass("A049b", "Snow falls from the clouds and the process of precipitating snow is called snowfall.", "Q049");
        this.addAnswer(a146);

        AnswerClass a147 = new AnswerClass("A049c", "The process of precipitating snow is called snowfall.", "Q049");
        this.addAnswer(a147);

        AnswerClass a148 = new AnswerClass("A050a", "Snow has a fluffy structure and it is composed of small ice particles.", "Q050");
        this.addAnswer(a148);

        AnswerClass a149 = new AnswerClass("A050b", "Snow is composed of small ice particles or it has a fluffy structure.", "Q050");
        this.addAnswer(a149);

        AnswerClass a150 = new AnswerClass("A050c", "Snow does not have a fluffy structure and it is not composed of small ice particles.", "Q050");
        this.addAnswer(a150);

        AnswerClass a151 = new AnswerClass("A051a", "The plants grow fast because Amy waters them everyday.", "Q051");
        this.addAnswer(a151);

        AnswerClass a152 = new AnswerClass("A051b", "The plants do not grow fast if Amy does not waters them everyday.", "Q051");
        this.addAnswer(a152);

        AnswerClass a153 = new AnswerClass("A051c", "If Amy waters the plants everyday then the plants grow fast. ", "Q051");
        this.addAnswer(a153);

        AnswerClass a154 = new AnswerClass("A052a", "Flowers grow from seeds and they are not plants.", "Q052");
        this.addAnswer(a154);

        AnswerClass a155 = new AnswerClass("A052b", "Flowers do not grow from seeds or they are not plants.", "Q052");
        this.addAnswer(a155);

        AnswerClass a156 = new AnswerClass("A052c", "Flowers are plants if they grow from seeds.", "Q052");
        this.addAnswer(a156);

        AnswerClass a157 = new AnswerClass("A053a", "If exposed to sunlight, plants will not obtain energy.", "Q053");
        this.addAnswer(a157);

        AnswerClass a158 = new AnswerClass("A053b", "Plants obtain energy if not exposed to sunlight.", "Q053");
        this.addAnswer(a158);

        AnswerClass a159 = new AnswerClass("A053c", "Plants won’t obtain energy if exposed to sunlight.", "Q053");
        this.addAnswer(a159);

        AnswerClass a160 = new AnswerClass("A054a", "Plants", "Q054");
        this.addAnswer(a160);

        AnswerClass a161 = new AnswerClass("A054b", "Otherwise", "Q054");
        this.addAnswer(a161);

        AnswerClass a162 = new AnswerClass("A054c", "will not survive", "Q054");
        this.addAnswer(a162);

        AnswerClass a163 = new AnswerClass("A055a", "You won’t have them anymore", "Q055");
        this.addAnswer(a163);

        AnswerClass a164 = new AnswerClass("A055b", "Don’t water", "Q055");
        this.addAnswer(a164);

        AnswerClass a165 = new AnswerClass("A055c", "Don’t water the flowers for a month", "Q055");
        this.addAnswer(a165);

        AnswerClass a166 = new AnswerClass("A056a", "loves plants", "Q056");
        this.addAnswer(a166);

        AnswerClass a167 = new AnswerClass("A056b", "deserves a planthouse", "Q056");
        this.addAnswer(a167);

        AnswerClass a168 = new AnswerClass("A056c", "anyone who loves plants", "Q056");
        this.addAnswer(a168);

        AnswerClass a169 = new AnswerClass("A057a", "you will get a free green pot ", "Q057");
        this.addAnswer(a169);

        AnswerClass a170 = new AnswerClass("A057b", "green plant pot", "Q057");
        this.addAnswer(a170);

        AnswerClass a171 = new AnswerClass("A057c", "visit us", "Q057");
        this.addAnswer(a171);

        AnswerClass a172 = new AnswerClass("A058a", "House plants will grow if over-watered or under-watered.", "Q058");
        this.addAnswer(a172);

        AnswerClass a173 = new AnswerClass("A058b", "House plants won’t grow if not over-watered or under-watered.", "Q058");
        this.addAnswer(a173);

        AnswerClass a174 = new AnswerClass("A058c", "House plants will grow if not over-watered or under-watered.", "Q058");
        this.addAnswer(a174);
        //two questions skipped

        AnswerClass a181 = new AnswerClass("A061a", "Lighting strikes and you can not hear it.", "Q061");
        this.addAnswer(a181);

        AnswerClass a182 = new AnswerClass("A061b", "Lightning strikes or you can not hear it.", "Q061");
        this.addAnswer(a182);

        AnswerClass a183 = new AnswerClass("A061c", "Lightning does not strike and you can not hear it.", "Q061");
        this.addAnswer(a183);

        AnswerClass a184 = new AnswerClass("A062a", "The electric field is not strong enough and a positive streamer develops from those points.", "Q062");
        this.addAnswer(a184);

        AnswerClass a185 = new AnswerClass("A062b", "The electric field is strong enough and a positive streamer can not develop from those points.", "Q062");
        this.addAnswer(a185);

        AnswerClass a186 = new AnswerClass("A062c", " If the electric field is strong enough, a positive streamer can not develop from those points.", "Q062");
        this.addAnswer(a186);

        AnswerClass a187 = new AnswerClass("A063a", "A lightning hits an object on the ground and it is not called a strike.", "Q063");
        this.addAnswer(a187);

        AnswerClass a188 = new AnswerClass("A063b", "A lightning does not hit an object on the ground and it is not called a strike.", "Q063");
        this.addAnswer(a188);

        AnswerClass a189 = new AnswerClass("A063c", "A lightning hits an object on the ground and it is called a strike.", "Q063");
        this.addAnswer(a189);

        AnswerClass a190 = new AnswerClass("A064a", "A lightning hits an object or the object will not burn.", "Q064");
        this.addAnswer(a190);

        AnswerClass a191 = new AnswerClass("A064b", "A lightning hits an object and the object will burn.", "Q064");
        this.addAnswer(a191);

        AnswerClass a192 = new AnswerClass("A064c", "A lightning hits an object and the object will not burn.", "Q064");
        this.addAnswer(a192);

        AnswerClass a193 = new AnswerClass("A065a", "The house is on fire and only the fire department can save lives.", "Q065");
        this.addAnswer(a193);

        AnswerClass a194 = new AnswerClass("A065b", "The house is not on fire and not only the fire department can save lives.", "Q065");
        this.addAnswer(a194);

        AnswerClass a195 = new AnswerClass("A065c", "The house is on fire and some lives can be saved by someone outside fire department.", "Q065");
        this.addAnswer(a195);

        AnswerClass a196 = new AnswerClass("A066a", "There is a storm and some lightnings are not pretty spectacular.", "Q066");
        this.addAnswer(a196);

        AnswerClass a197 = new AnswerClass("A066b", "There is a storm and all lightnings aren’t pretty spectacular.", "Q066");
        this.addAnswer(a197);

        AnswerClass a198 = new AnswerClass("A066c", "There is a storm and no lightnings are pretty spectacular.", "Q066");
        this.addAnswer(a198);

        AnswerClass a199 = new AnswerClass("A067a", "Lightning strikes a person and it is not usually fatal.", "Q067");
        this.addAnswer(a199);

        AnswerClass a200 = new AnswerClass("A067b", "If lightning strikes a person, it is not usually fatal.", "Q067");
        this.addAnswer(a200);

        AnswerClass a201 = new AnswerClass("A067c", "If lightning strikes a person, it is not fatal.", "Q067");
        this.addAnswer(a201);

        AnswerClass a203 = new AnswerClass("A068a", "If somebody does not have a fear of thunder or lightning and they may have astraphobia.", "Q068");
        this.addAnswer(a203);

        AnswerClass a204 = new AnswerClass("A068b", "Somebody has a fear of thunder or lightning and they may not have astraphobia.", "Q068");
        this.addAnswer(a204);

        AnswerClass a205 = new AnswerClass("A068c", "If somebody does have a fear of thunder and lightning, they may have astraphobia.", "Q068");
        this.addAnswer(a205);

        AnswerClass a206 = new AnswerClass("A069a", "You will learn more about lightning if you don’t study fulminology.", "Q069");
        this.addAnswer(a206);

        AnswerClass a207 = new AnswerClass("A069b", "You will not learn more about lightning if you study fulminology.", "Q069");
        this.addAnswer(a207);

        AnswerClass a208 = new AnswerClass("A069c", "You study fulminology and won’t learn more about lightning.", "Q069");
        this.addAnswer(a208);

        AnswerClass a209 = new AnswerClass("A070a", "The distance is less than 20 kilometres and no one can hear the thunder.", "Q070");
        this.addAnswer(a209);

        AnswerClass a210 = new AnswerClass("A070b", "The distance is less than 20 kilometres and some can’t hear the thunder.", "Q070");
        this.addAnswer(a210);

        AnswerClass a211 = new AnswerClass("A070c", "The distance is less than 20 kilometres and everyone can hear the thunder.", "Q070");
        this.addAnswer(a211);

        AnswerClass a212 = new AnswerClass("A071a", "If a volcano erupts then lava is expelled.", "Q071");
        this.addAnswer(a212);

        AnswerClass a213 = new AnswerClass("A071b", "A volcano erupts and lava is not expelled.", "Q071");
        this.addAnswer(a213);

        AnswerClass a214 = new AnswerClass("A071c", "If lava is expelled then a volcano erupts.", "Q071");
        this.addAnswer(a214);

        AnswerClass a215 = new AnswerClass("A072a", "If lava stops moving then it solidifies.", "Q072");
        this.addAnswer(a215);

        AnswerClass a216 = new AnswerClass("A072b", "Lava solidifies only when it stops moving.", "Q072");
        this.addAnswer(a216);

        AnswerClass a217 = new AnswerClass("A072c", "Lava starts moving when it solidifies.", "Q072");
        this.addAnswer(a217);

        AnswerClass a218 = new AnswerClass("A073a", "If the speed of the lava is higher then the viscosity is lower.", "Q073");
        this.addAnswer(a218);

        AnswerClass a219 = new AnswerClass("A073b", "If the speed of the lava is higher then the viscosity is higher.", "Q073");
        this.addAnswer(a219);

        AnswerClass a220 = new AnswerClass("A073c", "If the speed of the lava is lower then the viscosity is lower.", "Q073");
        this.addAnswer(a220);

        AnswerClass a221 = new AnswerClass("A074a", "If exposed to the surface then magma becomes lava.", "Q074");
        this.addAnswer(a221);

        AnswerClass a222 = new AnswerClass("A074b", "If exposed to the surface then lava becomes magma.", "Q074");
        this.addAnswer(a222);

        AnswerClass a223 = new AnswerClass("A074c", "If not exposed to the surface then magma becomes lava.", "Q074");
        this.addAnswer(a223);

        AnswerClass a224 = new AnswerClass("A075a", "Rocks melt if and only if they do not reach the melting point.", "Q075");
        this.addAnswer(a224);

        AnswerClass a225 = new AnswerClass("A075b", "Rocks melt if they reach the melting point.", "Q075");
        this.addAnswer(a225);

        AnswerClass a226 = new AnswerClass("A075c", "When rocks rich the melting point, they melt.", "Q075");
        this.addAnswer(a226);
        //5 questions skipped

        AnswerClass a242 = new AnswerClass("A081a", "You will save the forest if and only if you stop the wildfire spreading.", "Q081");
        this.addAnswer(a242);

        AnswerClass a243 = new AnswerClass("A081b", "Stopping the wildfire spreading you will save the forest.", "Q081");
        this.addAnswer(a243);

        AnswerClass a244 = new AnswerClass("A081c", "If you do not stop the wildfire spreading then you won’t save the forest.", "Q081");
        this.addAnswer(a244);

        AnswerClass a245 = new AnswerClass("A082a", "If the village is not safe then predators exist.", "Q082");
        this.addAnswer(a245);

        AnswerClass a246 = new AnswerClass("A082b", "If the village was safe then predators did not existed.", "Q082");
        this.addAnswer(a246);

        AnswerClass a247 = new AnswerClass("A082c", "If predators existed, the village is not safe.", "Q082");
        this.addAnswer(a247);

        AnswerClass a248 = new AnswerClass("A083a", "If the war was lost, then battle training is not crucial", "Q083");
        this.addAnswer(a248);

        AnswerClass a249 = new AnswerClass("A083b", "If the battle training is crucial then they will win the war.", "Q083");
        this.addAnswer(a249);

        AnswerClass a250 = new AnswerClass("A083c", "Battle training is not crucial in order to win the war.", "Q083");
        this.addAnswer(a250);

        AnswerClass a251 = new AnswerClass("A084a", "The village is in danger if no flooding occurred.", "Q084");
        this.addAnswer(a251);

        AnswerClass a252 = new AnswerClass("A084b", "The village is in danger if some flooring occurred.", "Q084");
        this.addAnswer(a252);

        AnswerClass a253 = new AnswerClass("A084c", "The village is not in danger if no flooring occurred.", "Q084");
        this.addAnswer(a253);

        AnswerClass a254 = new AnswerClass("A085a", "The world is not safe if all villages are under attack", "Q085");
        this.addAnswer(a254);

        AnswerClass a255 = new AnswerClass("A085b", "The world is safe if no village is under attack.", "Q085");
        this.addAnswer(a255);

        AnswerClass a256 = new AnswerClass("A085c", "The world is not safe if some villages are under attack.", "Q085");
        this.addAnswer(a256);

        AnswerClass a257 = new AnswerClass("A086a", "If village people will lose something, then nobody helped them.", "Q086");
        this.addAnswer(a257);

        AnswerClass a258 = new AnswerClass("A086b", "If village people will lose everything, then somebody did not helped them.", "Q086");
        this.addAnswer(a258);

        AnswerClass a259 = new AnswerClass("A086c", "If village people will lose everything, then nobody helped them.", "Q086");
        this.addAnswer(a259);
        //4 questions skipped

        AnswerClass a272 = new AnswerClass("A091a", "Heroes are giving random acts of kindness.", "Q091");
        this.addAnswer(a272);

        AnswerClass a273 = new AnswerClass("A091b", "People are heroes.", "Q091");
        this.addAnswer(a273);

        AnswerClass a274 = new AnswerClass("A091c", "Random acts of kindness are given by some people.", "Q091");
        this.addAnswer(a274);

        AnswerClass a275 = new AnswerClass("A092a", "Only heroes can save the world.", "Q092");
        this.addAnswer(a275);

        AnswerClass a276 = new AnswerClass("A092b", "Everyone can save the world.", "Q092");
        this.addAnswer(a276);

        AnswerClass a277 = new AnswerClass("A092c", "Not everyone can save the world.", "Q092");
        this.addAnswer(a277);

        AnswerClass a278 = new AnswerClass("A093a", "The world is threatened.", "Q093");
        this.addAnswer(a278);

        AnswerClass a279 = new AnswerClass("A093b", "Superheroes are reacting.", "Q093");
        this.addAnswer(a279);

        AnswerClass a280 = new AnswerClass("A093c", "The world is not threatened.", "Q093");
        this.addAnswer(a280);

        AnswerClass a281 = new AnswerClass("A094a", "Superheroes are not humans.", "Q094");
        this.addAnswer(a281);

        AnswerClass a282 = new AnswerClass("A094b", "Humans don’t need to save the world.", "Q094");
        this.addAnswer(a282);

        AnswerClass a283 = new AnswerClass("A094c", "Humans need to save the world.", "Q094");
        this.addAnswer(a283);

        //end =)

    }


    private void addLevels() {

        LevelClass l1 = new LevelClass("L01", "Level 1 - Wind", "<p><b>Hello!</b> This is " +
                "the first level of your power conquest. On this level you are going to " +
                "learn the concept of <b>propositional logic</b> and <b>contradictory propositions.</b> " +
                "In the end of this level you will have the <b>wind power</b> which is the first " +
                "step to get the <b>air power</b>, but to finish the level one you have to prove " +
                "your knowledge about wind by answering 5 questions. " + "</p>" +
                "<p>So, lets get started with the concepts:" + "</p>" +
                "<p><b>Propositional logics</b> is also called <b>“sentential logic”</b> or <b>“statement logic”</b> " +
                "and it deals with logical relationship between propositions (also called: " +
                "<b>claims</b>, <b>statement</b>, <b>sentences</b>, <b>assertions</b>, ..) taken as wholes. A proposition " +
                "is a declarative sentence which has a <b>True/False</b> value and it is composed by a " +
                "subject term and a predicate term, for example:" + "</p>" +
                "<p>“The wind is cold”." + "</p>" + "<p>The wind= subject term" + "</p>" + "<p>“is cold” = " +
                "the predicate" + "</p>" + "<p>We symbolize the proposition using a single letter: " +
                "</p>" + "<p><b>j</b>: “ Jill is wearing a red dress”." + "</p>" + "<br />" + "<p><b>Contradictories,</b> " +
                "operator \"<b>not</b>\":" + "</p>" + "<p>The Contradictory of A is a claim that always has the " +
                "opposite truth value of A. In the case of a simple proposition just use a " +
                "negative word or expression (<b>\"no\"</b>, <b>\"not\"</b>, <b>\"It is not true\"</b>, <b>\"It is false\"</b>...)" +
                " before the sentence, and you have the contradictory. The <b>“not”</b> operator can also be " +
                "represented by <b>“¬”</b>. For example:" + "</p>" + "<p><b>a</b>: “The wind is blowing”" + "</p>" +
                "<p><b>¬a</b>: “The wind is not blowing”" + "</p>" + "<p>Notice that <b>‘¬a’</b> is the contradictory claim " +
                "of <b>‘a’</b> and vice-versa. " + "</p>", "Tip1");
        this.addLevel(l1);

        LevelClass l2 = new LevelClass("L02", "Level 2 - Sound", "<p><b>Hello!</b> This is the last level of " +
                "your air power conquest. On this level you are going to learn the <b>conjunctions</b>. In " +
                "the end of this level you will have the <b>air power</b>, but to finish the level 2 you have" +
                " to prove your knowledge about <b>sound</b> as well as you proved about wind by answering 5" +
                " questions right." + "</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The " +
                "<b>conjunctions</b> use operators such as <b>“and”</b> or <b>“but”</b> to connect two simple propositions," +
                " for example:" + "</p>" + "<p>“The wind is blowing hard and it is raining”." + "</p>" +
                "<p>To evaluate this proposition as true <b>both</b> propositions must be <b>true</b>, if one is false" +
                " then the whole statement is false. The <b>“and”</b> operator can be also represented by <b>“^”</b>.</p>", "Tip2");
        this.addLevel(l2);

        LevelClass l3 = new LevelClass("L03", "Level 3 - Metal", "<p>In order to master the <b>Earth power</b> " +
                "you have to pass two levels (<b>Metal</b> and <b>Sand</b>). This is the first one that you have" +
                " to pass, <b>Metal</b>. On this level you are going to learn the <b>disjunctions</b> and to " +
                "complete the level 3 you have to prove your knowledge about metal by answering 5 " +
                "questions right." + "</p>" + "<p>So, lets get started with the concepts: </p>" + "<p>The " +
                "<b>disjunctions</b> use the <b>“or”</b> operator to connect two simple propositions, for example:" + "</p>" +
                "<p>“Iron is a kind of metal or it is a kind of stone”. " + "</p>" + "<p>We have two kinds of " +
                "disjunctions: <b>Inclusive “or”</b> and <b>Exclusive “or”</b>." + "</p>" + "<p>In the <b>inclusive “or”</b> the " +
                "propositions are evaluated as true when <b>any one</b> of claims is <b>true</b>. The whole " +
                "sentence will be false only if both propositions are false." + "</p>" + "<p>In the <b>exclusive " +
                "“or”</b> the propositions are evaluated as true when <b>only one</b> of the claims is <b>true</b>. " +
                "The whole statement is false when both claims have the same value, both false or " +
                "both true." + "</p>" + "<p>The <b>“or”</b> operator can be also represented by <b>“v”</b>.</p>", "Tip 3");
        this.addLevel(l3);

        LevelClass l4 = new LevelClass("L04", "Level 4 - Sand", "<p>Hello! This is Level 4, the last step you have to go through" +
                " to get the <b>Earth</b> power. On this level you are going to learn about the <b>contradictory of a conjunction" +
                "</b> and to complete the level 4 you have to prove your knowledge about Sand by answering 5 questions right. </p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>The <b>Contradictory</b> of A is a claim that <b>always</b> has the <b>opposite</b> truth value of A.</p>" +
                "<p>Remember the conjunction is the compound claim that has the operator “OR” present. In order to write the " +
                "contradictory of a conjunction, you need to know the following rule:<p>" +
                "<p>not(A and B) = notA or notB</p>", "Tip 4");
        this.addLevel(l4);

        LevelClass l5 = new LevelClass("L05", "Level 5 - Snow", "<p>Hello! This is Level 5, the first step you have to go through" +
                " to get the <b>Water</b> power. On this level you are going to learn about the <b>contradictory of a disjunction</b>" +
                " and to complete the level 5 you have to prove your knowledge about <b>sand</b> by answering 5 questions right. </p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>Remember that the Contradictory of A is a claim that always has the opposite truth value of A.</p>" +
                "<p>And also remember that the conjunction is the compound claim that has the operator “OR” present. In order " +
                "to write the contradictory of a conjunction, you need to know the following rule:</p>" +
                "<p>not(A or B) = notA and notB</p>", "Tip 5");
        this.addLevel(l5);

        LevelClass l6 = new LevelClass("L06", "Level 6 - Plant", "<p>Hello! This is Level 6, the last step you have to go through" +
                " to get the <b>Water</b> power. On this level you are going to learn about the <b>conditional propositions</b>" +
                " and to complete the level 6 you have to prove your knowledge about <b>plants</b> by answering 5 questions right." +
                "</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The conditional proposition is represented in the " +
                "format: <b>if A then B</b>. Where A = antecedent and B = consequent. A conditional claim is False when the antecedent" +
                " is True but the consequent is False. When A is False or both A and B are True the proposition is True. Other way of" +
                " addressing this:</p>" + "<p>B if A = if A then B</p>", "Tip 6");
        this.addLevel(l6);

        LevelClass l7 = new LevelClass("L07", "Level 7 - Lightning", "<p>Hello! This is Level 7, the first step you have to go through" +
                " to get the <b>Fire</b> power. On this level you are going to learn about the <b>contradictory of conditionals</b> and," +
                "in order to complete this level, you have to prove your knowledge about Lightning by answering 5 questions right.</p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>The contradictory of a conditional - NOT(if A then B) is a conjunction. This compound claim is True if antecedent is" +
                " true (A) but the consequence (B) is false. </p>" + "<p>not (if A then B) = A and not-B = A but not-B <> if A then not-B</p>", "Tip 7");
        this.addLevel(l7);

        LevelClass l8 = new LevelClass("L08", "Level 8 - Lava", "<p>Hello! This is Level 8, the last step you have to go through to get the " +
                "<b>Fire</b> Power. On this level you are going to learn about the <b>equivalence</b> and, in order to complete this level, you have" +
                " to prove your knowledge about <b>Lava</b> by answering 5 questions right.</p>" + "<p>So, lets get started with the concepts:</p>" +
                "<p>Only If rule: A only if B = if A then B </p>" + "<p>Biconditional rule (conjoining two conditionals):</p>" +
                "<p>A if and only if B = (A if B) and (A only if B)</p>" + "<p>written as: A if and only if B = A iff B = A=B</p>" +
                "<p>or (if B then A) and (if A then B)</p>" + "<p>In this case, the claims A and B always have the same truth value: " +
                "if A is true then B is true and vice versa. We symbolize the logical equivalence of statement p and q by p ≡ q ( p <--> q ).</p>", "Tip 8");
        this.addLevel(l8);

        LevelClass l9 = new LevelClass("L09", "Level 9 - Dark City", "</p>Hello! This is Level 9, the first step you have to go through in order" +
                " to become a <b>Hero!</b>. On this level you are going to learn about the <b>contrapositive</b> and, in order to complete this level, you have to " +
                "protect your people from attack of the <b>Dark City</b> by answering 5 questions right.</p> <p>So, lets get started with the concepts:</p>" + "<p>General rule: if A then B = if not-B " +
                "then not-A</p>" + "<p>ex: Conditional: (A: You won’t become a good player) if (B: you don’t practice)</p>" + "<p>where A: consequent and B: antecedent</p>" +
                "<p>Contrapositive: If you become a good player then you practiced.</p>", "Tip 9");
        this.addLevel(l9);

        LevelClass l10 = new LevelClass("L10", "Level 10 - WORLD Master", "<p><b>Congratulation!</b> This is Level 10, the last step you have to go through in order to become " +
                "a <b>The World Master</b> On this level you are going to learn about <b>inference</b> and, in order to complete this level, you have to save the world by answering" +
                " 5 questions right.</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The rule: true statements stand as premises and they can derive in conclusions" +
                " (respecting the rules learned by now and the semantics). </p>" + "<p>A→B</p>" + "<p>A/B</p>", "Tip 10");
        this.addLevel(l10);
    }


    public boolean addUserActivity(UserActivityClass userActivity) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, userActivity.getUser_id());
        values.put(COLUMN_QUESTION_ID, userActivity.getQuestion_id());
        values.put(COLUMN_ANSWER_ID, userActivity.getAnswer_id());
        values.put(COLUMN_DATE, userActivity.getDate());
        database.insert(TABLE_USERS_ACT, null, values);
        return true;
    }

    // Adding new question
    public void addQuestion(QuestionClass q) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_ID, q.getQuestion_id());
        values.put(COLUMN_QUESTION_TEXT, q.getQuestion_text());
        values.put(COLUMN_LEVEL_ID, q.getLevel_id());
        values.put(COLUMN_RIGHT_ANSWER, q.getRight_answer());
        database.insert(TABLE_QUESTIONS, null, values);
    }

    // Adding new answer
    public void addAnswer(AnswerClass a) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ANSWER_ID, a.getAnswer_id());
        values.put(COLUMN_ANSWER_TEXT, a.getAnswer_text());
        values.put(COLUMN_QUESTION_ID, a.getQuestion_id());
        database.insert(TABLE_ANSWERS, null, values);
    }

    public void addLevel(LevelClass l) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEVEL_ID, l.getLevel_id());
        values.put(COLUMN_LEVEL_NAME, l.getLevelname());
        values.put(COLUMN_LESSON, l.getLesson());
        values.put(COLUMN_TIP, l.getTip());
        database.insert(TABLE_LEVEL, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS_ACT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }


    public boolean addUser(UserClass user) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASS, user.getPass());
        values.put(COLUMN_AVATAR, user.getAvatar());

        long iduser = database.insert(TABLE_USERS, null, values);

        ScoreboardClass score = new ScoreboardClass((int) iduser, 00, 00, "L01");
        this.addScore(score);

        return true;
    }

    public long getUserID(UserClass user) {
        long userID = 0;
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_EMAIL + " = '" + user.getEmail() + "' ; ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            userID = cursor.getLong(0);
        }
        return userID;
    }

    public boolean addScore(ScoreboardClass score) {

        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USER_ID, score.getUser_id());
        values.put(COLUMN_POINTS, score.getPoints());
        values.put(COLUMN_WRONG_PERCENT, score.getWrong_percent());
        values.put(COLUMN_LEVEL_ID, score.getLevel_id());
        database.insert(TABLE_SCOREBOARD, null, values);

        return true;
    }

    public boolean addScoreboardScreen(ScoreboardScreen scoreboard) {

        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USERNAME_SCOREBOARD, scoreboard.getUserName());
        values.put(COLUMN_LEVELNAME_SCOREBOARD, scoreboard.getLevelName());
        values.put(COLUMN_POINTS_SCOREBOARD, scoreboard.getPoints());
        values.put(COLUMN_WRONGPERC_SCOREBOARD, scoreboard.getWrongPerc());
        database.insert(TABLE_SCOREBOARD_SCREEN, null, values);

        return true;
    }

    public ArrayList<ScoreboardScreen> getScoreboardTable() {
        ArrayList<ScoreboardScreen> scoreList = new ArrayList<ScoreboardScreen>();
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD_SCREEN + " ORDER BY " + COLUMN_POINTS_SCOREBOARD + " DESC, " + COLUMN_WRONGPERC_SCOREBOARD + " ASC ;";
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

    public boolean deleteScoreboardTable() {
        //String deleteQuery = "DELETE FROM " + TABLE_SCOREBOARD_SCREEN + ";";
        //database = this.getReadableDatabase();
        database.delete(TABLE_SCOREBOARD_SCREEN, null, null);

        return true;
    }

    public List<UserClass> getAllUsers() {
        List<UserClass> usersList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS + ";";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UserClass user = new UserClass();
                user.setUser_id(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPass(cursor.getString(3));
                user.setAvatar(cursor.getString(4));
                usersList.add(user);
            } while (cursor.moveToNext());
        }
        return usersList;
    }

    ///inicio
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
    }
///fim

    public LevelClass getLevel(String levelID) {
        LevelClass levelobj = new LevelClass();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_LEVEL + " WHERE " + COLUMN_LEVEL_ID + " = '" + (String) levelID + "' ; ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            levelobj.setLevel_id(cursor.getString(0));
            levelobj.setLevelname(cursor.getString(1));
            levelobj.setLesson(cursor.getString(2));
            levelobj.setTip(cursor.getString(3));
        }
        return levelobj;
    }

    public ScoreboardClass getScore(long UserID) {
        ScoreboardClass scoreobj = new ScoreboardClass();
        Cursor cursor;
        String UserString = Integer.toString((int) UserID);
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ;";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            scoreobj.setUser_id(cursor.getInt(0));
            scoreobj.setPoints(cursor.getInt(1));
            scoreobj.setWrong_percent(cursor.getInt(2));
            scoreobj.setLevel_id(cursor.getString(3));
        }
        return scoreobj;
    }

    public List<AnswerClass> getAnswer(String qid) {
        List<AnswerClass> Answerlist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ANSWERS + " WHERE " + COLUMN_QUESTION_ID + " = '" + qid + "' ;";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AnswerClass answers = new AnswerClass();
                answers.setAnswer_id(cursor.getString(0));
                answers.setAnswer_text(cursor.getString(1));
                answers.setQuestion_id(cursor.getString(2));
                Answerlist.add(answers);
            } while (cursor.moveToNext());
        }
        return Answerlist;
    }

    public List<QuestionClass> levelQuestion(String levelId) {
        List<QuestionClass> questionsList = new ArrayList<>();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_LEVEL_ID + " = '" + levelId + "' ;";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                QuestionClass levelQuestion = new QuestionClass();
                levelQuestion.setQuestion_id(cursor.getString(0));
                levelQuestion.setQuestion_text(cursor.getString(1));
                levelQuestion.setLevel_id(cursor.getString(2));
                levelQuestion.setRight_answer(cursor.getString(3));
                questionsList.add(levelQuestion);
            } while (cursor.moveToNext());
        }

        return questionsList;
    }


    public boolean updatingScore(Integer score, UserClass User, String levelID) {
        Cursor cursor;
        String UserString = Integer.toString((int) User.getUser_id());
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        ContentValues values;
        values = new ContentValues();
        if (cursor.moveToFirst()) {
            values.put(COLUMN_USER_ID, cursor.getInt(0));
            values.put(COLUMN_POINTS, score);
            values.put(COLUMN_WRONG_PERCENT, cursor.getInt(2));
            values.put(COLUMN_LEVEL_ID, levelID);
        }

        database = this.getWritableDatabase();
        database.update(TABLE_SCOREBOARD, values, COLUMN_USER_ID + "= ?", new String[]{UserString});
        return true;
    }

    public boolean updatingWrongScore(Integer wScore, UserClass User){
        Cursor cursor;
        String UserString = Integer.toString((int) User.getUser_id());
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        ContentValues values;
        values = new ContentValues();
        if (cursor.moveToFirst()) {
            values.put(COLUMN_USER_ID, cursor.getInt(0));
            values.put(COLUMN_POINTS, cursor.getInt(1));
            values.put(COLUMN_WRONG_PERCENT, wScore);
            values.put(COLUMN_LEVEL_ID, cursor.getString(3));
        }

        database = this.getWritableDatabase();
        database.update(TABLE_SCOREBOARD, values, COLUMN_USER_ID + "= ?", new String[]{UserString});
        return true;

    }

}

