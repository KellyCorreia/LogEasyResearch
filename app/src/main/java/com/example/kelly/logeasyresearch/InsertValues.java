package com.example.kelly.logeasyresearch;


public class InsertValues {

    private MySQLiteHelper db = null;

    public InsertValues(MySQLiteHelper database){
        db = database;
    }

    public void insertAllValues(){
        this.addLevels();
        this.addQuestions();
        this.addAnswers();
    }

    private void addQuestions() {

        //these are the questions for test purposes on the summer project
        //Level 1
        ClassQuestion q1 = new ClassQuestion("Q001", "One essential feature of a proposition is:", 1);
        db.addQuestion(q1);

        ClassQuestion q2 = new ClassQuestion("Q002", "Does the following express a proposition or a " +
                "fragment? \n 'While waiting for the wind to change directions.'", 1);
        db.addQuestion(q2);

        ClassQuestion q3 = new ClassQuestion("Q003", "Does the following express a proposition or a" +
                " fragment? \n 'While waiting for the wind to change directions, I stayed home.'", 1);
        db.addQuestion(q3);

        ClassQuestion q4 = new ClassQuestion("Q004", "Does the following express a proposition or a" +
                " fragment?\n 'The coldest wind in the world.'", 1);
        db.addQuestion(q4);

        ClassQuestion q5 = new ClassQuestion("Q005", "Does the following express a proposition or a" +
                " fragment?\n The wind from south is the coldest wind in the world.", 1);
        db.addQuestion(q5);

        ClassQuestion q6 = new ClassQuestion("Q006", "Does the following express a proposition or a" +
                " fragment?\n The wind's direction", 1);
        db.addQuestion(q6);

        ClassQuestion q7 = new ClassQuestion("Q007", "Does the following express a proposition or a" +
                " fragment?\n The wind's direction is south", 1);
        db.addQuestion(q7);

        //level 2
        ClassQuestion q11 = new ClassQuestion("Q011", "Determine whether the following contains an " +
                "argument.\n People appreciate the silence. Yet, at the same time, they enjoy noisy music concerts.", 2);
        db.addQuestion(q11);

        ClassQuestion q12 = new ClassQuestion("Q012", "Determine whether the following contains an " +
                "argument.\n There is more and more concern about the noise in our environment. One " +
                "reason is that our environment keeps getting noisier and noisier.", 2);
        db.addQuestion(q12);

        ClassQuestion q13 = new ClassQuestion("Q013", "Determine whether the following contains an " +
                "argument.\n Music is a combination of sound and silence. Musicians put together " +
                "different instrument sounds. Then, they add vocal sound to produce music.", 2);
        db.addQuestion(q13);

        ClassQuestion q14 = new ClassQuestion("Q014", "Determine whether the following contains an " +
                "argument.\n People enjoy listening nature sounds. Since it helps them to relax.", 2);
        db.addQuestion(q14);

        ClassQuestion q15 = new ClassQuestion("Q015", " Determine whether the following contains an" +
                " argument.\n Some people do not wear hearing protection in noisy environments. As " +
                "a result they lose their hearing capability.", 2);
        db.addQuestion(q15);

        ClassQuestion q16 = new ClassQuestion("Q015", " Determine whether the following contains an" +
                " argument.\n People don't like to stay in noise environments. Since it makes them feel stressed.", 2);
        db.addQuestion(q16);

        ClassQuestion q17 = new ClassQuestion("Q015", " Determine whether the following contains an" +
                " argument.\n In order to make a song musicians need to add sounds together in a harmonic way.", 2);
        db.addQuestion(q17);



       //These are the questions from the first version of the app
        /*ClassQuestion q1 = new ClassQuestion("Q001", "Which one is the contradictory of the " +
                "following claim: \n “Sometimes the wind is blowing hard.”", 1);
        db.addQuestion(q1);

        ClassQuestion q2 = new ClassQuestion("Q002", "Which one is the contradictory of the " +
                "following statement: \n “The wind is blowing all the time.”", 1);
        db.addQuestion(q2);

        ClassQuestion q3 = new ClassQuestion("Q003", "Which one of the following sentences becomes " +
                "true after applying the NOT operator.", 1);
        db.addQuestion(q3);

        ClassQuestion q4 = new ClassQuestion("Q004", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", 1);
        db.addQuestion(q4);

        ClassQuestion q5 = new ClassQuestion("Q005", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", 1);
        db.addQuestion(q5);

        ClassQuestion q6 = new ClassQuestion("Q006", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", 1);
        db.addQuestion(q6);

        ClassQuestion q7 = new ClassQuestion("Q007", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.",1);
        db.addQuestion(q7);

        ClassQuestion q8 = new ClassQuestion("Q008", "Which one is the contradictory of the following" +
                " statement: \n “The wind has no direction.”", 1);
        db.addQuestion(q8);

        ClassQuestion q9 = new ClassQuestion("Q009", "Which one is the contradictory of the following" +
                " claim: \n “The wind’s direction is North.”", 1);
        db.addQuestion(q9);

        ClassQuestion q10 = new ClassQuestion("Q010", "Which one is the contradictory of the following" +
                " sentence: \n “Some breeze is a light wind.”", 1);
        db.addQuestion(q10);

        ClassQuestion q11 = new ClassQuestion("Q011", "Given: a = “The sound is a vibration” is  " +
                "true and b = “The sound is not a wave” is false. Which of the following is true:", 2);
        db.addQuestion(q11);

        ClassQuestion q12 = new ClassQuestion("Q012", "Given: a = “The sound propagates through the air”" +
                " is true. Which of the following is false:", 2);
        db.addQuestion(q12);

        ClassQuestion q13 = new ClassQuestion("Q013", "Given: a = “The sound propagates through solids”" +
                " is true and b = “The sound is not a vibration” is false. Which of the following is true:", 2);
        db.addQuestion(q13);

        ClassQuestion q14 = new ClassQuestion("Q014", "Given: “The speed of the sound is 972m/s” is " +
                "true and “Sound propagates through the air”. Considering the exclusive “or”. Which " +
                "of the following is true:", 2);
        db.addQuestion(q14);

        ClassQuestion q15 = new ClassQuestion("Q015", "Given: a = “All sound come from a vibrating " +
                "source” is true and b = “Sound can be heard” is true. Which os the following is true:", 2);
        db.addQuestion(q15);

        ClassQuestion q16 = new ClassQuestion("Q016", "Given: a = “Sound cannot be heard” is false " +
                "and b = “Sound is a current of air” is false. Which os the following is false:", 2);
        db.addQuestion(q16);

        ClassQuestion q17 = new ClassQuestion("Q017", "Given: a = “Music is a combination of sounds”" +
                " is true. Which os the following is false:", 2);
        db.addQuestion(q17);

        ClassQuestion q18 = new ClassQuestion("Q018", "Given: a = “Music is a combination of sounds”" +
                " is true,  b = “Sound is a current of air” is false and c = “All sound come from a" +
                " vibrating source” is true. Which one of the following is true:", 2);
        db.addQuestion(q18);

        ClassQuestion q19 = new ClassQuestion("Q019", "Given: a = “Sound cannot be heard” is false" +
                " and b = “All sound come from a vibrating source” is true. Which of the following " +
                "is true:", 2);
        db.addQuestion(q19);

        ClassQuestion q20 = new ClassQuestion("Q020", "Given: a = “Music is a combination of sound " +
                "and silence” is true, b = “A very strong sound forms a tornado” is false and c = " +
                "“Sound is not a wave” is false. Which of the following is true:", 2);
        db.addQuestion(q20);

        ClassQuestion q21 = new ClassQuestion("Q021", "Given:  a = “The earth is full of metals” is" +
                " true and b = “Gold is a metal” is true.  Which of the following is false:", 3);
        db.addQuestion(q21);

        ClassQuestion q22 = new ClassQuestion("Q022", "Which one of the following propositions is true:", 3);
        db.addQuestion(q22);

        ClassQuestion q23 = new ClassQuestion("Q023", "Given: a = “All metals are found in the earth”" +
                " is true and b = “Silver is a crystal” is false. Which one of the following is false.", 3);
        db.addQuestion(q23);

        ClassQuestion q24 = new ClassQuestion("Q024", "Given: a = “Gold is more expensive than silver”" +
                " is true and b = “Both gold and silver are metals” is true. Which one of the following" +
                " is true.", 3);
        db.addQuestion(q24);

        ClassQuestion q25 = new ClassQuestion("Q025", "Given: a = “Gold is a gemstone” and  b = “Ruby" +
                " is a metal” both are false. Which one of the following is true:", 3);
        db.addQuestion(q25);

        ClassQuestion q26 = new ClassQuestion("Q026", "Given: a = “Silver is a stone” is false and b" +
                " = “All metals are found in the earth” is true. Which one of the following is false:", 3);
        db.addQuestion(q26);

        ClassQuestion q27 = new ClassQuestion("Q027", "Given: “All metals are found in the earth and " +
                "gold is a metal” is true and “Ruby is a stone or gold is a stone” is true. Which one of " +
                "the following is true:", 3);
        db.addQuestion(q27);

        ClassQuestion q28 = new ClassQuestion("Q028", "Given: “Silver is a precious metal and gold is not" +
                " a stone” is true. Which one of the following is true:", 3);
        db.addQuestion(q28);

        ClassQuestion q29 = new ClassQuestion("Q029", "Given: “Iron is a metal”  is true. Which one of the following is false:", 3);
        db.addQuestion(q29);

        ClassQuestion q30 = new ClassQuestion("Q030", "Given: “Gold is the most expensive metal” is true " +
                "and “Silver is a metal” is true. Which one of the following is false:", 3);
        db.addQuestion(q30);

        ClassQuestion q31 = new ClassQuestion("Q031", "Which one of the following is the contradictory" +
                " of A: Sandy soil is ideal for crops and farming.", 4);
        db.addQuestion(q31);

        ClassQuestion q32 = new ClassQuestion("Q032", "Which one of the following is the contradictory " +
                "of A: Wild beaches are undiscovered and you can’t find any hotels nearby.", 4);
        db.addQuestion(q32);

        ClassQuestion q33 = new ClassQuestion("Q033", "Which one of the following is the contradictory" +
                " of A: Some beaches are formed along an ocean and they don’t have life guards posts.",4);
        db.addQuestion(q33);

        ClassQuestion q34 = new ClassQuestion("Q034", "Which of the following is the contradictory of A:" +
                " Performance artists draw images in sand and this type of art is called sand animation.",4);
        db.addQuestion(q34);

        ClassQuestion q35 = new ClassQuestion("Q035", "Which of the following is the contradictory" +
                " of A: Sand is composed by rock and mineral particles.\n",4);
        db.addQuestion(q35);

        ClassQuestion q36 = new ClassQuestion("Q036", "Given A: Only the sandy beaches are visited by" +
                " tourist and this is a fact. - true. Which one is the contradictory of A from the following:",4);
        db.addQuestion(q36);

        ClassQuestion q37 = new ClassQuestion("Q037", "Given A: Sand is finer than gravel and coarser " +
                "than silt. Which one is the contradictory of A from the following compound claims:", 4);
        db.addQuestion(q37);

        ClassQuestion q38 = new ClassQuestion("Q038", "Given the contradictory of A: A common type of " +
                "sand was not created by coral or shellfish. Please choose A from the following:", 4);
        db.addQuestion(q38);

        ClassQuestion q39 = new ClassQuestion("Q039", "Given the contradictory of B: Sand and water table " +
                "are fun in the back garden or in the livingroom . Find the compound claim B:", 4);
        db.addQuestion(q39);

        ClassQuestion q40 = new ClassQuestion("Q040", "Given the contradictory of B: In the back garden, " +
                "children cannot play with sand or water. Find the compound claim B:", 4);
        db.addQuestion(q40);

        ClassQuestion q41 = new ClassQuestion("Q041", "Which one of the following is the contradictory " +
                "of A: Precipitations can fall in form of ice crystals or in snow.", 5);
        db.addQuestion(q41);

        ClassQuestion q42 = new ClassQuestion("Q042", "Which one of the following is the contradictory " +
                "of C: not (A or B). A: Snow has a fluffy structure. B: Snow is composed of small ice particles.", 5);
        db.addQuestion(q42);

        ClassQuestion q43 = new ClassQuestion("Q043", "Given: A: Snow has an open and soft structure." +
                " Which one of the following is the contradictory of A:",5);
        db.addQuestion(q43);

        ClassQuestion q44 = new ClassQuestion("Q044", "Given: A: not (B or C); B: Snow is precipitation in form of " +
                "ice flakes; C: Snow has a soft structure.  Which one of the following represents A:", 5);
        db.addQuestion(q44);

        ClassQuestion q45 = new ClassQuestion("Q045", "Given: ¬(A v B): Water cannot fall from the clouds in form of " +
                "snow neither ice crystals. Which of the following represents A and B:", 5);
        db.addQuestion(q45);

        ClassQuestion q46 = new ClassQuestion("Q046", "Which one of the following is the contradictory of AvB. " +
                "Given: A: Snow is formed by small ice particles; B: Snowflakes come in a variety of sizes and shapes.", 5);
        db.addQuestion(q46);

        ClassQuestion q47 = new ClassQuestion("Q047", "Which one of the following is the contradictory " +
                "of A. Given: A: Snow has an open or soft structure.", 5);
        db.addQuestion(q47);

        ClassQuestion q48 = new ClassQuestion("Q048", "Which one of the following is the contradictory of A: " +
                "Snow falls from the clouds or the process of precipitating snow is called snowfall.", 5);
        db.addQuestion(q48);

        ClassQuestion q49 = new ClassQuestion("Q049", "Which one of the following is the contradictory of A: " +
                "Snow does not fall from the clouds or the process of precipitating snow is not called snowfall.", 5);
        db.addQuestion(q49);

        ClassQuestion q50 = new ClassQuestion("Q050", "Which one of the following is the contradictory A: " +
                "Snow has a fluffy structure or it is composed of small ice particles.", 5);
        db.addQuestion(q50);

        ClassQuestion q51 = new ClassQuestion("Q051", "Given: A: The plants grow fast. and B: Amy waters" +
                " the plants everyday. Which of the following represents if A then B:", 6);
        db.addQuestion(q51);

        ClassQuestion q52 = new ClassQuestion("Q052", "Given: A: If flowers grow from seeds then they are plants " +
                ": True. Which one of the following is false:", 6);
        db.addQuestion(q52);

        ClassQuestion q53 = new ClassQuestion("Q053", "Consider A: Plants obtain energy if exposed to " +
                "sunlight. Please select the false statement from the following:", 6);
        db.addQuestion(q53);

        ClassQuestion q54 = new ClassQuestion("Q054", "Please select the antecedent from the following" +
                " claim: B = Otherwise, plants will not survive on this planet.",6);
        db.addQuestion(q54);

        ClassQuestion q55 = new ClassQuestion("Q055", "Please select the antecedent from the following" +
                " claim: C = Don’t water the flowers for a month and you won’t have them anymore.", 6);
        db.addQuestion(q55);

        ClassQuestion q56 = new ClassQuestion("Q056", "Please select the consequent from the following" +
                " claim: A = Anyone who loves plants deserves a planthouse.",6);
        db.addQuestion(q56);

        ClassQuestion q57 = new ClassQuestion("Q057", "Please select the consequent from the following" +
                " claim: B = Visit us and you will get a free green plant pot.", 6);
        db.addQuestion(q57);

        ClassQuestion q58 = new ClassQuestion("Q058", "Consider A: House plants won’t grow if over-watered" +
                " or under-watered. Please select the false statement from the following:", 6);
        db.addQuestion(q58);
        //two questions skipped

        ClassQuestion q61 = new ClassQuestion("Q061", "Please select the contradictory of A: If lightning" +
                " strikes then you can hear it.", 7);
        db.addQuestion(q61);

        ClassQuestion q62 = new ClassQuestion("Q062", "Please select the contradictory of A: If the electric" +
                " field is strong enough, a positive streamer can develop from those points.", 7);
        db.addQuestion(q62);

        ClassQuestion q63 = new ClassQuestion("Q063", "Which one of the following is the contradictory of C:" +
                " If a lightning hits an object on the ground it is called a strike.", 7);
        db.addQuestion(q63);

        ClassQuestion q64 = new ClassQuestion("Q064", "Which one of the following is the contradictory" +
                " of A: If a lightning hits an object, the object will burn.", 7);
        db.addQuestion(q64);

        ClassQuestion q65 = new ClassQuestion("Q065", "Which one of the following is the contradictory" +
                " of B: If the house is on fire then only fire department can save lives.", 7);
        db.addQuestion(q65);

        ClassQuestion q66 = new ClassQuestion("Q066", "Which one of the following is the contradictory " +
                "of C: If there is a storm then some lightnings are pretty spectacular.", 7);
        db.addQuestion(q66);

        ClassQuestion q67 = new ClassQuestion("Q067", "Which one of the following is the contradictory of " +
                "B: If lightning strikes a person, it is usually fatal.", 7);
        db.addQuestion(q67);

        ClassQuestion q68 = new ClassQuestion("Q068", "Which one of the following is the contradictory " +
                "of A: If somebody has a fear of thunder or lightning, they may have astraphobia.", 7);
        db.addQuestion(q68);

        ClassQuestion q69 = new ClassQuestion("Q069", "Which one of the following is the contradictory of " +
                "C: You will learn more about lightning if you study fulminology.", 7);
        db.addQuestion(q69);

        ClassQuestion q70 = new ClassQuestion("Q070", "Which one of the following is the contradictory " +
                "of A: Some people can hear the thunder if the distance is less than 20 kilometres.", 7);
        db.addQuestion(q70);

        ClassQuestion q71 = new ClassQuestion("Q071", "Please select the false relationship for the following " +
                "compound claim: Lava is expelled only if a volcano erupts.", 8);
        db.addQuestion(q71);

        ClassQuestion q72 = new ClassQuestion("Q072", "Please select the false relationship for the following" +
                " compound claim: Lava stops moving if and only if it solidifies.", 8);
        db.addQuestion(q72);

        ClassQuestion q73 = new ClassQuestion("Q073", "Please select the true relationship for the following" +
                " compound claim: The speed of the lava is higher if and only if the viscosity is lower.", 8);
        db.addQuestion(q73);

        ClassQuestion q74 = new ClassQuestion("Q074", "Given: Magma becomes lava if and only if it is exposed" +
                " to the surface. Please fill in the dots with the adecvate statement. \n \tIf magma becomes" +
                " lava then it is exposed to the surface and …", 8);
        db.addQuestion(q74);

        ClassQuestion q75 = new ClassQuestion("Q075", "Please select the equivalence statement:\n" +
                "\tRocks melt if they reach the melting point and when they reach the melting point, rocks melt.", 8);
        db.addQuestion(q75);
        //5 questions skipped

        ClassQuestion q81 = new ClassQuestion("Q081", "Please select the contrapositive for the following " +
                "statement: In order to save the forest you must stop the wildfire spreading. ", 9);
        db.addQuestion(q81);

        ClassQuestion q82 = new ClassQuestion("Q082", "Please select the statement that has the following" +
                " contrapositive: If predators did not existed then the village would have been safe.", 9);
        db.addQuestion(q82);

        ClassQuestion q83 = new ClassQuestion("Q083", "Please select the contrapositive for the following statement:" +
                " Battle training is crucial in order to win the war.", 9);
        db.addQuestion(q83);

        ClassQuestion q84 = new ClassQuestion("Q084", "Please select the statement that has the following contrapositive:" +
                " If no flooding occurred then the village is not in danger.", 9);
        db.addQuestion(q84);

        ClassQuestion q85 = new ClassQuestion("Q085", "Please select the statement that has the following contrapositive:" +
                " If some villages are not under attack then the world is safe.", 9);
        db.addQuestion(q85);

        ClassQuestion q86 = new ClassQuestion("Q086", "Please select the contrapositive for the following statement:" +
                " If somebody will help them, the village people won’t lose everything.", 9);
        db.addQuestion(q86);
        //4 questions skipped

        ClassQuestion q91 = new ClassQuestion("Q091", "Please select the inference that derive from the following premises:\n" +
                "p: Heroes are people.\n" + "q: People are giving random acts of kindness.", 10);
        db.addQuestion(q91);

        ClassQuestion q92 = new ClassQuestion("Q092", "Please select the inference that derive from the following premises:\n" +
                "p: In order to save the world you need to be a hero.\n" + "q. Everyone can be a hero", 10);
        db.addQuestion(q92);

        ClassQuestion q93 = new ClassQuestion("Q093", "Please select the inference that derive from the following premises:\n" +
                "p: If the world is threatened then superheroes will react.\n" + "q: Superheroes are not reacting.\n", 10);
        db.addQuestion(q93);

        ClassQuestion q94 = new ClassQuestion("Q094", "Please select the inference that derive from the following premises:\n" +
                "p: If you have super powers you are a superhero.\n" + "q: If you don’t have super powers than you are human.\n" +
                "r: If you are a superhero then you need to save the world.", 10);
        db.addQuestion(q94);*/


    }

    private void addAnswers() {

        //These are the answers for testing purposes on the summer project
        //level 1
        ClassAnswer a1 = new ClassAnswer("A001a", "It asks a question.", "Q001", 0);
        db.addAnswer(a1);

        ClassAnswer a2 = new ClassAnswer("A001b", "It is either true or false.", "Q001", 1);
        db.addAnswer(a2);

        ClassAnswer a3 = new ClassAnswer("A001c", "It issues a command.", "Q001", 0);
        db.addAnswer(a3);

        ClassAnswer a4 = new ClassAnswer("A002a", "Proposition", "Q002", 0);
        db.addAnswer(a4);

        ClassAnswer a5 = new ClassAnswer("A002b", "Fragment", "Q002", 1);
        db.addAnswer(a5);

        ClassAnswer a7 = new ClassAnswer("A003a", "Proposition.", "Q003", 1);
        db.addAnswer(a7);

        ClassAnswer a8 = new ClassAnswer("A003b", "Fragment", "Q003", 0);
        db.addAnswer(a8);

        ClassAnswer a10 = new ClassAnswer("A004a", "Proposition", "Q004", 0);
        db.addAnswer(a10);

        ClassAnswer a11 = new ClassAnswer("A004b", "Fragment", "Q004", 1);
        db.addAnswer(a11);

        ClassAnswer a13 = new ClassAnswer("A005a", "Proposition", "Q005", 1);
        db.addAnswer(a13);

        ClassAnswer a14 = new ClassAnswer("A005b", "Fragment", "Q005", 0);
        db.addAnswer(a14);

        ClassAnswer a15 = new ClassAnswer("A006a", "Proposition", "Q006", 0);
        db.addAnswer(a15);

        ClassAnswer a16 = new ClassAnswer("A006b", "Fragment", "Q006", 1);
        db.addAnswer(a16);

        ClassAnswer a17 = new ClassAnswer("A007a", "Proposition", "Q007", 1);
        db.addAnswer(a17);

        ClassAnswer a18 = new ClassAnswer("A007b", "Fragment", "Q007", 0);
        db.addAnswer(a18);

        //level2
        ClassAnswer a31 = new ClassAnswer("A011a", "Yes, it contains an argument.", "Q011", 0);
        db.addAnswer(a31);

        ClassAnswer a32 = new ClassAnswer("A011b", "No, it doesn't contain an argument.", "Q011", 1);
        db.addAnswer(a32);

        ClassAnswer a34 = new ClassAnswer("A012a", "Yes, it contains an argument.", "Q012", 0);
        db.addAnswer(a34);

        ClassAnswer a35 = new ClassAnswer("A012b", "No, it doesn't contain an argument.", "Q012", 1);
        db.addAnswer(a35);

        ClassAnswer a37 = new ClassAnswer("A013a", "Yes, it contains an argument.", "Q013", 0);
        db.addAnswer(a37);

        ClassAnswer a38 = new ClassAnswer("A013b", "No, it doesn't contain an argument.", "Q013", 1);
        db.addAnswer(a38);

        ClassAnswer a40 = new ClassAnswer("A014a", "Yes, it contains an argument.", "Q014", 1);
        db.addAnswer(a40);

        ClassAnswer a41 = new ClassAnswer("A014b", "No, it doesn't contain an argument.", "Q014", 0);
        db.addAnswer(a41);

        ClassAnswer a43 = new ClassAnswer("A015a", "Yes, it contains an argument.", "Q015", 1);
        db.addAnswer(a43);

        ClassAnswer a44 = new ClassAnswer("A015b", "No, it doesn't contain an argument.", "Q015", 0);
        db.addAnswer(a44);

        ClassAnswer a45 = new ClassAnswer("A016a", "Yes, it contains an argument.", "Q016", 1);
        db.addAnswer(a45);

        ClassAnswer a46 = new ClassAnswer("A016b", "No, it doesn't contain an argument.", "Q016", 0);
        db.addAnswer(a46);

        ClassAnswer a47 = new ClassAnswer("A017a", "Yes, it contains an argument.", "Q017", 0);
        db.addAnswer(a47);

        ClassAnswer a48 = new ClassAnswer("A017b", "No, it doesn't contain an argument.", "Q017", 1);
        db.addAnswer(a48);


        //These are the answers for the first version of logeasy
        /*ClassAnswer a1 = new ClassAnswer("A001a", "The wind is not blowing hard.", "Q001", 0);
        db.addAnswer(a1);

        ClassAnswer a2 = new ClassAnswer("A001b", "Sometimes the wind is not blowing hard.", "Q001", 0);
        db.addAnswer(a2);

        ClassAnswer a3 = new ClassAnswer("A001c", "The wind is never blowing hard.", "Q001", 1);
        db.addAnswer(a3);

        ClassAnswer a4 = new ClassAnswer("A002a", "The wind is not blowing.", "Q002", 0);
        db.addAnswer(a4);

        ClassAnswer a5 = new ClassAnswer("A002b", "Sometimes the wind is not blowing.", "Q002", 0);
        db.addAnswer(a5);

        ClassAnswer a6 = new ClassAnswer("A002c", "The wind is never blowing.", "Q002", 0);
        db.addAnswer(a6);

        ClassAnswer a7 = new ClassAnswer("A003a", "The wind can change directions.", "Q003", 0);
        db.addAnswer(a7);

        ClassAnswer a8 = new ClassAnswer("A003b", "The wind is blowing in the same direction.", "Q003", 0);
        db.addAnswer(a8);

        ClassAnswer a9 = new ClassAnswer("A003c", "The wind can never change directions.", "Q003", 1);
        db.addAnswer(a9);

        ClassAnswer a10 = new ClassAnswer("A004a", "The wind has the power to destroy houses", "Q004", 0);
        db.addAnswer(a10);

        ClassAnswer a11 = new ClassAnswer("A004b", "The wind can sometimes destroy houses.", "Q004", 1);
        db.addAnswer(a11);

        ClassAnswer a12 = new ClassAnswer("A004c", "The wind can destroy houses.", "Q004", 0);
        db.addAnswer(a12);

        ClassAnswer a13 = new ClassAnswer("A005a", "The wind can blow hard.", "Q005", 0);
        db.addAnswer(a13);

        ClassAnswer a14 = new ClassAnswer("A005b", "The wind blows hard all the time.", "Q005", 1);
        db.addAnswer(a14);

        ClassAnswer a15 = new ClassAnswer("A005c", "The wind is not blowing hard.", "Q005", 0);
        db.addAnswer(a15);

        ClassAnswer a16 = new ClassAnswer("A006a", "The houses may be destroyed by the wind.", "Q006", 1);
        db.addAnswer(a16);

        ClassAnswer a17 = new ClassAnswer("A006b", "Some houses may be destroyed by the wind.", "Q006", 0);
        db.addAnswer(a17);

        ClassAnswer a18 = new ClassAnswer("A006c", "Not all the houses can be destroyed by the wind.", "Q006", 0);
        db.addAnswer(a18);

        ClassAnswer a19 = new ClassAnswer("A007a", "The wind’s direction never changes.", "Q007", 1);
        db.addAnswer(a19);

        ClassAnswer a20 = new ClassAnswer("A007b", "The wind’s direction can change.", "Q007", 1);
        db.addAnswer(a20);

        ClassAnswer a21 = new ClassAnswer("A007c", "The wind’s direction can change sometimes.", "Q007", 0);
        db.addAnswer(a21);

        ClassAnswer a22 = new ClassAnswer("A008a", "The wind sometimes has a direction.", "Q008", 1);
        db.addAnswer(a22);

        ClassAnswer a23 = new ClassAnswer("A008b", "The wind doesn’t have a direction.", "Q008", 0);
        db.addAnswer(a23);

        ClassAnswer a24 = new ClassAnswer("A008c", "The wind’s direction exists.", "Q008", 0);
        db.addAnswer(a24);

        ClassAnswer a25 = new ClassAnswer("A009a", "The wind’s direction is South.", "Q009", 0);
        db.addAnswer(a25);

        ClassAnswer a26 = new ClassAnswer("A009b", "Sometimes the wind’s direction is not North.", "Q009", 1);
        db.addAnswer(a26);

        ClassAnswer a27 = new ClassAnswer("A009c", "The wind’s direction is different.", "Q009", 0);
        db.addAnswer(a27);

        ClassAnswer a28 = new ClassAnswer("A010a", "No breeze is a light wind.", "Q010", 1);
        db.addAnswer(a28);

        ClassAnswer a29 = new ClassAnswer("A010b", "A breeze is sometimes a light wind.", "Q010", 0);
        db.addAnswer(a29);

        ClassAnswer a30 = new ClassAnswer("A010c", "All breezes are light.", "Q010", 0);
        db.addAnswer(a30);

        ClassAnswer a31 = new ClassAnswer("A011a", "The sound is a vibration and it is not a wave.", "Q011", 0);
        db.addAnswer(a31);

        ClassAnswer a32 = new ClassAnswer("A011b", "The sound is not a vibration, but it is a wave.", "Q011", 0);
        db.addAnswer(a32);

        ClassAnswer a33 = new ClassAnswer("A011c", "The sound is a vibration and it is a wave.", "Q011", 1);
        db.addAnswer(a33);

        ClassAnswer a34 = new ClassAnswer("A012a", "The sound propagates through the air or it is not a wave.", "Q012", 0);
        db.addAnswer(a34);

        ClassAnswer a35 = new ClassAnswer("A012b", "The sound doesn’t propagates through the air and it is a wave.", "Q012", 1);
        db.addAnswer(a35);

        ClassAnswer a36 = new ClassAnswer("A012c", "The sound propagates through the air and it is a vibration.", "Q012", 0);
        db.addAnswer(a36);

        ClassAnswer a37 = new ClassAnswer("A013a", "a ^ b", "Q013", 0);
        db.addAnswer(a37);

        ClassAnswer a38 = new ClassAnswer("A013b", "a ^ ¬b", "Q013", 1);
        db.addAnswer(a38);

        ClassAnswer a39 = new ClassAnswer("A013c", "¬a ^ b", "Q013", 0);
        db.addAnswer(a39);

        ClassAnswer a40 = new ClassAnswer("A014a", "The speed of the sound is 972m/s or it propagates through the air.", "Q014", 0);
        db.addAnswer(a40);

        ClassAnswer a41 = new ClassAnswer("A014b", "The speed of the sound is not 972m/s or it does not propagates through the air.", "Q014", 0);
        db.addAnswer(a41);

        ClassAnswer a42 = new ClassAnswer("A014c", "The speed of the sound is 972m/s or it does not propagates through the air.", "Q014", 0);
        db.addAnswer(a42);

        ClassAnswer a43 = new ClassAnswer("A015a", "a ^ b", "Q015", 1);
        db.addAnswer(a43);

        ClassAnswer a44 = new ClassAnswer("A015b", "¬a ^ b", "Q015", 0);
        db.addAnswer(a44);

        ClassAnswer a45 = new ClassAnswer("A015c", "a ^ ¬b", "Q015", 0);
        db.addAnswer(a45);

        ClassAnswer a46 = new ClassAnswer("A016a", "a ^ b", "Q016", 0);
        db.addAnswer(a46);

        ClassAnswer a47 = new ClassAnswer("A016b", "¬a ^ b", "Q016", 0);
        db.addAnswer(a47);

        ClassAnswer a48 = new ClassAnswer("A016c", "¬a ^ ¬b", "Q016", 1);
        db.addAnswer(a48);

        ClassAnswer a49 = new ClassAnswer("A017a", "Music is a combination of sounds and sound is a current of air.", "Q017", 0);
        db.addAnswer(a49);

        ClassAnswer a50 = new ClassAnswer("A017b", "Music is not a combination of sounds and sound is a vibration. ", "Q017", 1);
        db.addAnswer(a50);

        ClassAnswer a51 = new ClassAnswer("A017c", "Music is a combination of sounds and sound cannot be heard.", "Q017", 0);
        db.addAnswer(a51);

        ClassAnswer a52 = new ClassAnswer("A018a", "a ^ b ^ c", "Q018", 0);
        db.addAnswer(a52);

        ClassAnswer a53 = new ClassAnswer("A018b", "a ^ ¬b ^ c", "Q018", 1);
        db.addAnswer(a53);

        ClassAnswer a54 = new ClassAnswer("A018c", "a ^ b ^ ¬c", "Q018", 0);
        db.addAnswer(a54);

        ClassAnswer a55 = new ClassAnswer("A019a", "Sound can be heard and some sounds do not come from a vibrating source.", "Q019", 0);
        db.addAnswer(a55);

        ClassAnswer a56 = new ClassAnswer("A019b", "All sound come from a vibrating source and sound cannot be heard.", "Q019", 0);
        db.addAnswer(a56);

        ClassAnswer a57 = new ClassAnswer("A019c", "All sound come from a vibrating source and sound can be heard.", "Q019", 1);
        db.addAnswer(a57);

        ClassAnswer a58 = new ClassAnswer("A020a", "Sound is a wave and a very strong sound does not form a tornado. ", "Q020", 1);
        db.addAnswer(a58);

        ClassAnswer a59 = new ClassAnswer("A020b", "Music is a combination of sound and silence and a very strong sound forms a tornado.", "Q020", 0);
        db.addAnswer(a59);

        ClassAnswer a60 = new ClassAnswer("A020c", "Sound is not a wave and music is a combination of sound and silence.", "Q020", 0);
        db.addAnswer(a60);

        ClassAnswer a61 = new ClassAnswer("A021a", "a v b", "Q021", 0);
        db.addAnswer(a61);

        ClassAnswer a62 = new ClassAnswer("A021b", "a v ¬b", "Q021", 0);
        db.addAnswer(a62);

        ClassAnswer a63 = new ClassAnswer("A021c", "¬a v ¬b", "Q021", 1);
        db.addAnswer(a63);

        ClassAnswer a64 = new ClassAnswer("A022a", "Gold is a metal and silver is not a metal.", "Q022", 0);
        db.addAnswer(a64);

        ClassAnswer a65 = new ClassAnswer("A022b", "Gold is a metal or silver is not a metal.", "Q022", 1);
        db.addAnswer(a65);

        ClassAnswer a66 = new ClassAnswer("A022c", "Gold is not a metal or silver is not a metal.", "Q022", 0);
        db.addAnswer(a66);

        ClassAnswer a67 = new ClassAnswer("A023a", "Some metals are not found in the earth or silver is not a crystal.", "Q023", 0);
        db.addAnswer(a67);

        ClassAnswer a68 = new ClassAnswer("A023b", "Some metals are not found in the earth or silver is a crystal. ", "Q023", 1);
        db.addAnswer(a68);

        ClassAnswer a69 = new ClassAnswer("A023c", "Silver is a metal and all metal are found in the earth.", "Q023", 0);
        db.addAnswer(a69);

        ClassAnswer a70 = new ClassAnswer("A024a", "Gold and silver are metals and silver is more expensive than gold.", "Q024", 0);
        db.addAnswer(a70);

        ClassAnswer a71 = new ClassAnswer("A024b", "Gold is more expensive than silver or silver is not a metal.", "Q024", 1);
        db.addAnswer(a71);

        ClassAnswer a72 = new ClassAnswer("A024c", "Silver is more expensive than gold or gold is not a metal.", "Q024", 0);
        db.addAnswer(a72);

        ClassAnswer a73 = new ClassAnswer("A025a", "Gold is not a gemstone or ruby is a metal.", "Q025", 1);
        db.addAnswer(a73);

        ClassAnswer a74 = new ClassAnswer("A025b", "Gold is a gemstone or ruby is a metal.", "Q025", 0);
        db.addAnswer(a74);

        ClassAnswer a75 = new ClassAnswer("A025c", "Gold and Ruby are metals.", "Q025", 0);
        db.addAnswer(a75);

        ClassAnswer a76 = new ClassAnswer("A026a", "¬a ^ b", "Q026", 0);
        db.addAnswer(a76);

        ClassAnswer a77 = new ClassAnswer("A026b", "a v b", "Q026", 0);
        db.addAnswer(a77);

        ClassAnswer a78 = new ClassAnswer("A026c", "a ^ b", "Q026", 1);
        db.addAnswer(a78);

        ClassAnswer a79 = new ClassAnswer("A027a", "All metals are found in the earth and ruby is a stone.\n", "Q027", 0);
        db.addAnswer(a79);

        ClassAnswer a80 = new ClassAnswer("A027b", "Gold is a metal or gold is stone.", "Q027", 1);
        db.addAnswer(a80);

        ClassAnswer a81 = new ClassAnswer("A027c", "Gold is not a metal or a stone.", "Q027", 0);
        db.addAnswer(a81);

        ClassAnswer a82 = new ClassAnswer("A028a", "Silver is a precious metal or gold is a stone.", "Q028", 1);
        db.addAnswer(a82);

        ClassAnswer a83 = new ClassAnswer("A028b", "Silver is not a metal or gold is a stone.", "Q028", 0);
        db.addAnswer(a83);

        ClassAnswer a84 = new ClassAnswer("A028c", "Gold and silver are metals.", "Q028", 0);
        db.addAnswer(a84);

        ClassAnswer a85 = new ClassAnswer("A029a", "Gold is a metal, but iron is not.", "Q029", 1);
        db.addAnswer(a85);

        ClassAnswer a86 = new ClassAnswer("A029b", "Iron is not a metal or gold is a metal", "Q029", 0);
        db.addAnswer(a86);

        ClassAnswer a87 = new ClassAnswer("A029c", "Iron is a metal or gold is a metal.", "Q029", 0);
        db.addAnswer(a87);

        ClassAnswer a88 = new ClassAnswer("A030a", "Or silver or gold is the most expensive metal.", "Q030", 0);
        db.addAnswer(a88);

        ClassAnswer a89 = new ClassAnswer("A030b", "Gold and silver are the most expensive metals.", "Q030", 0);
        db.addAnswer(a89);

        ClassAnswer a90 = new ClassAnswer("A030c", "Gold is not the most expensive metal or silver is not a metal.", "Q030", 1);
        db.addAnswer(a90);

        ClassAnswer a91 = new ClassAnswer("A031a", "Sandy soil is not ideal for crops or for farming.", "Q031", 1);
        db.addAnswer(a91);

        ClassAnswer a92 = new ClassAnswer("A031b", "Soil that is not sandy is ideal for crops or farming.", "Q031", 0);
        db.addAnswer(a92);

        ClassAnswer a93 = new ClassAnswer("A031c", "Sandy soil is not ideal for crops nor for farming.", "Q031", 0);
        db.addAnswer(a93);

        ClassAnswer a94 = new ClassAnswer("A032a", "Wild beaches are not undiscovered and you can’t find any hotels nearby.", "Q032", 0);
        db.addAnswer(a94);

        ClassAnswer a95 = new ClassAnswer("A032b", "Wild beaches are not undiscovered but you can find some hotels nearby", "Q032", 1);
        db.addAnswer(a95);

        ClassAnswer a96 = new ClassAnswer("A032c", "Beaches that are not wild are discovered or you can find hotels nearby.", "Q032", 0);
        db.addAnswer(a96);

        ClassAnswer a97 = new ClassAnswer("A033a", "No beaches are formed along an ocean nor they have lifeguards posts.", "Q033", 0);
        db.addAnswer(a97);

        ClassAnswer a98 = new ClassAnswer("A033b", "Some beaches are not formed along an ocean or do they have lifeguards posts.", "Q033", 0);
        db.addAnswer(a98);

        ClassAnswer a99 = new ClassAnswer("A033c", "No beaches are formed along an ocean or they have lifeguards posts.", "Q033", 1);
        db.addAnswer(a99);

        ClassAnswer a100 = new ClassAnswer("A034a", "Some performance artists do not draw images in sand or this type of art isn’t called sand animation.", "Q034", 1);
        db.addAnswer(a100);

        ClassAnswer a101 = new ClassAnswer("A034b", "Some performance artists draw images in sand or this type of art  is not called sand animation.", "Q034", 0);
        db.addAnswer(a101);

        ClassAnswer a102 = new ClassAnswer("A034c", "Performance artists don’t draw images in sand nor they called it sand animation.", "Q034", 0);
        db.addAnswer(a102);

        ClassAnswer a103 = new ClassAnswer("A035a", "Sand is not composed by rock particles.", "Q035", 0);
        db.addAnswer(a103);

        ClassAnswer a104 = new ClassAnswer("A035b", "Sand is composed by something else except rock and mineral particles.", "Q035", 0);
        db.addAnswer(a104);

        ClassAnswer a105 = new ClassAnswer("A035c", "Sand is not composed by rock or by mineral particles. ", "Q035", 1);
        db.addAnswer(a105);

        ClassAnswer a106 = new ClassAnswer("A036a", "No sandy beaches are visited and this is not a fact.", "Q036", 0);
        db.addAnswer(a106);

        ClassAnswer a107 = new ClassAnswer("A036b", "Some tourists do not visit sandy beaches or this is not a fact. ", "Q036", 1);
        db.addAnswer(a107);

        ClassAnswer a108 = new ClassAnswer("A036c", "Some tourists visit sandy beaches or this is a fact.", "Q036", 0);
        db.addAnswer(a108);

        ClassAnswer a109 = new ClassAnswer("A037a", "Sand is not finer than gravel and coarser than silt.", "Q037", 0);
        db.addAnswer(a109);

        ClassAnswer a110 = new ClassAnswer("A037b", "Sand is gravel than finer or silt than coarser.", "Q037", 0);
        db.addAnswer(a110);

        ClassAnswer a111 = new ClassAnswer("A037c", "Sand is not finer than gravel or it is not coarser than silt.", "Q037", 1);
        db.addAnswer(a111);

        ClassAnswer a112 = new ClassAnswer("A038a", "An uncommon type of sand was created by coral and shellfish.", "Q038", 0);
        db.addAnswer(a112);

        ClassAnswer a113 = new ClassAnswer("A038b", "A common type of sand was created by coral and shellfish.", "Q038",1);
        db.addAnswer(a113);

        ClassAnswer a114 = new ClassAnswer("A038c", "A common type of sand was not created by coral or shellfish.", "Q038", 0);
        db.addAnswer(a114);

        ClassAnswer a115 = new ClassAnswer("A039a", "Sand or water table are not fun in the back garden or in the livingroom.", "Q039", 0);
        db.addAnswer(a115);

        ClassAnswer a116 = new ClassAnswer("A039b", "Sand and water table are not fun in the back garden and in the livingroom.", "Q039", 1);
        db.addAnswer(a116);

        ClassAnswer a117 = new ClassAnswer("A039c", "Sand or water table are fun in the back garden or in the livingroom.", "Q039", 0);
        db.addAnswer(a117);

        ClassAnswer a118 = new ClassAnswer("A040a", "In the back garden, children can play with sand and water.", "Q040", 1);
        db.addAnswer(a118);

        ClassAnswer a119 = new ClassAnswer("A040b", "In the back garden, children cannot play with sand and water.", "Q040", 0);
        db.addAnswer(a119);

        ClassAnswer a120 = new ClassAnswer("A040c", "In the back garden, children can play with sand or water.", "Q040", 0);
        db.addAnswer(a120);

        ClassAnswer a121 = new ClassAnswer("A041a", "Precipitation cannot fall in form of ice crystals neither in form of snow.", "Q041", 1);
        db.addAnswer(a121);

        ClassAnswer a122 = new ClassAnswer("A041b", "Precipitations cannot fall in form of ice or in form of snow.", "Q041", 0);
        db.addAnswer(a122);

        ClassAnswer a123 = new ClassAnswer("A041c", "Precipitation can fall in form of snow but not ice crystals.", "Q041", 0);
        db.addAnswer(a123);

        ClassAnswer a124 = new ClassAnswer("A042a", "Snow has a fluffy structure and it is composed of small ice particles.", "Q042", 0);
        db.addAnswer(a124);

        ClassAnswer a125 = new ClassAnswer("A042b", "Snow is composed of small ice particles or it has a fluffy structure.", "Q042", 1);
        db.addAnswer(a125);

        ClassAnswer a126 = new ClassAnswer("A042c", "Snow does not have a fluffy structure neither is composed of small ice particles.", "Q042", 0);
        db.addAnswer(a126);

        ClassAnswer a127 = new ClassAnswer("A043a", "Snow does not have an open structure.", "Q043", 0);
        db.addAnswer(a127);

        ClassAnswer a128 = new ClassAnswer("A043b", "Snow does not have a soft and open structure.", "Q043", 0);
        db.addAnswer(a128);

        ClassAnswer a129 = new ClassAnswer("A043c", "Snow does not have a soft neither an open structure.", "Q043", 1);
        db.addAnswer(a129);

        ClassAnswer a130 = new ClassAnswer("A044a", "Snow is not precipitation in form of ice flakes and it has no soft structure.", "Q044" , 0);
        db.addAnswer(a130);

        ClassAnswer a131 = new ClassAnswer("A044b", "Snow is precipitation in form of ice flakes and it has a soft structure.\n", "Q044", 0);
        db.addAnswer(a131);

        ClassAnswer a132 = new ClassAnswer("A044c", "The structure of snow is not soft and it is not precipitation in form of ice flakes.", "Q044", 1);
        db.addAnswer(a132);

        ClassAnswer a133 = new ClassAnswer("A045a", "Water can fall from the clouds in form of snow and ice crystals.", "Q045",1);
        db.addAnswer(a133);

        ClassAnswer a134 = new ClassAnswer("A045b", "Water can fall from the clouds in form of snow or ice crystals.", "Q045", 0);
        db.addAnswer(a134);

        ClassAnswer a135 = new ClassAnswer("A045c", "Water cannot fall from the clouds in form of snow and ice crystals.", "Q045", 0);
        db.addAnswer(a135);

        ClassAnswer a136 = new ClassAnswer("A046a", "Snowflakes do not come in a variety of sizes and shapes neither snow is formed by small ice particles.", "Q046", 1);
        db.addAnswer(a136);

        ClassAnswer a137 = new ClassAnswer("A046b", "Snowflakes do not come in a variety of sizes and shapes and snow is formed by small ice particles.", "Q046", 0);
        db.addAnswer(a137);

        ClassAnswer a138 = new ClassAnswer("A046c", "Snowflakes do not come in a variety of sizes and shapes or snow is formed by small ice particles.", "Q046", 0);
        db.addAnswer(a138);

        ClassAnswer a139 = new ClassAnswer("A047a", "Snow does not have an open and soft structure.", "Q047", 0);
        db.addAnswer(a139);

        ClassAnswer a140 = new ClassAnswer("A047b", "Snow does not have a soft structure.", "Q047", 0);
        db.addAnswer(a140);

        ClassAnswer a141 = new ClassAnswer("A047c", "Snow does not have an open neither a soft structure.", "Q047", 1);
        db.addAnswer(a141);

        ClassAnswer a142 = new ClassAnswer("A048a", "Snow does not fall from the clouds and the process of precipitating snow is not called snowfall.", "Q048", 1);
        db.addAnswer(a142);

        ClassAnswer a143 = new ClassAnswer("A048b", "The process of precipitating snow is not called snowfall or snow does not fall from the clouds.", "Q048", 0);
        db.addAnswer(a143);

        ClassAnswer a144 = new ClassAnswer("A048c", "The process of precipitating snow is not called snowfall and snow fall from the clouds.", "Q048", 0);
        db.addAnswer(a144);

        ClassAnswer a145 = new ClassAnswer("A049a", "Snow does not fall from the clouds and the process of precipitating snow is not called snowfall.\n", "Q049", 0);
        db.addAnswer(a145);

        ClassAnswer a146 = new ClassAnswer("A049b", "Snow falls from the clouds and the process of precipitating snow is called snowfall.", "Q049", 1);
        db.addAnswer(a146);

        ClassAnswer a147 = new ClassAnswer("A049c", "The process of precipitating snow is called snowfall.", "Q049", 0);
        db.addAnswer(a147);

        ClassAnswer a148 = new ClassAnswer("A050a", "Snow has a fluffy structure and it is composed of small ice particles.", "Q050", 0);
        db.addAnswer(a148);

        ClassAnswer a149 = new ClassAnswer("A050b", "Snow is composed of small ice particles or it has a fluffy structure.", "Q050", 0);
        db.addAnswer(a149);

        ClassAnswer a150 = new ClassAnswer("A050c", "Snow does not have a fluffy structure and it is not composed of small ice particles.", "Q050", 1);
        db.addAnswer(a150);

        ClassAnswer a151 = new ClassAnswer("A051a", "The plants grow fast because Amy waters them everyday.", "Q051", 0);
        db.addAnswer(a151);

        ClassAnswer a152 = new ClassAnswer("A051b", "The plants do not grow fast if Amy does not waters them everyday.", "Q051", 0);
        db.addAnswer(a152);

        ClassAnswer a153 = new ClassAnswer("A051c", "If Amy waters the plants everyday then the plants grow fast. ", "Q051", 1);
        db.addAnswer(a153);

        ClassAnswer a154 = new ClassAnswer("A052a", "Flowers grow from seeds and they are not plants.", "Q052", 1);
        db.addAnswer(a154);

        ClassAnswer a155 = new ClassAnswer("A052b", "Flowers do not grow from seeds or they are not plants.", "Q052", 0);
        db.addAnswer(a155);

        ClassAnswer a156 = new ClassAnswer("A052c", "Flowers are plants if they grow from seeds.", "Q052", 0);
        db.addAnswer(a156);

        ClassAnswer a157 = new ClassAnswer("A053a", "If exposed to sunlight, plants will not obtain energy.", "Q053", 0);
        db.addAnswer(a157);

        ClassAnswer a158 = new ClassAnswer("A053b", "Plants obtain energy if not exposed to sunlight.", "Q053", 0);
        db.addAnswer(a158);

        ClassAnswer a159 = new ClassAnswer("A053c", "Plants won’t obtain energy if exposed to sunlight.", "Q053", 1);
        db.addAnswer(a159);

        ClassAnswer a160 = new ClassAnswer("A054a", "Plants", "Q054", 0);
        db.addAnswer(a160);

        ClassAnswer a161 = new ClassAnswer("A054b", "Otherwise", "Q054", 1);
        db.addAnswer(a161);

        ClassAnswer a162 = new ClassAnswer("A054c", "will not survive", "Q054", 0);
        db.addAnswer(a162);

        ClassAnswer a163 = new ClassAnswer("A055a", "You won’t have them anymore", "Q055", 0);
        db.addAnswer(a163);

        ClassAnswer a164 = new ClassAnswer("A055b", "Don’t water", "Q055", 0);
        db.addAnswer(a164);

        ClassAnswer a165 = new ClassAnswer("A055c", "Don’t water the flowers for a month", "Q055", 1);
        db.addAnswer(a165);

        ClassAnswer a166 = new ClassAnswer("A056a", "loves plants", "Q056", 0);
        db.addAnswer(a166);

        ClassAnswer a167 = new ClassAnswer("A056b", "deserves a planthouse", "Q056",1);
        db.addAnswer(a167);

        ClassAnswer a168 = new ClassAnswer("A056c", "anyone who loves plants", "Q056", 0);
        db.addAnswer(a168);

        ClassAnswer a169 = new ClassAnswer("A057a", "you will get a free green pot ", "Q057", 0);
        db.addAnswer(a169);

        ClassAnswer a170 = new ClassAnswer("A057b", "green plant pot", "Q057", 0);
        db.addAnswer(a170);

        ClassAnswer a171 = new ClassAnswer("A057c", "visit us", "Q057", 0);
        db.addAnswer(a171);

        ClassAnswer a172 = new ClassAnswer("A058a", "House plants will grow if over-watered or under-watered.", "Q058", 1);
        db.addAnswer(a172);

        ClassAnswer a173 = new ClassAnswer("A058b", "House plants won’t grow if not over-watered or under-watered.", "Q058", 0);
        db.addAnswer(a173);

        ClassAnswer a174 = new ClassAnswer("A058c", "House plants will grow if not over-watered or under-watered.", "Q058", 0);
        db.addAnswer(a174);
        //two questions skipped

        ClassAnswer a181 = new ClassAnswer("A061a", "Lighting strikes and you can not hear it.", "Q061", 1);
        db.addAnswer(a181);

        ClassAnswer a182 = new ClassAnswer("A061b", "Lightning strikes or you can not hear it.", "Q061", 0);
        db.addAnswer(a182);

        ClassAnswer a183 = new ClassAnswer("A061c", "Lightning does not strike and you can not hear it.", "Q061", 0);
        db.addAnswer(a183);

        ClassAnswer a184 = new ClassAnswer("A062a", "The electric field is not strong enough and a positive streamer develops from those points.", "Q062", 0);
        db.addAnswer(a184);

        ClassAnswer a185 = new ClassAnswer("A062b", "The electric field is strong enough and a positive streamer can not develop from those points.", "Q062", 1);
        db.addAnswer(a185);

        ClassAnswer a186 = new ClassAnswer("A062c", " If the electric field is strong enough, a positive streamer can not develop from those points.", "Q062", 0);
        db.addAnswer(a186);

        ClassAnswer a187 = new ClassAnswer("A063a", "A lightning hits an object on the ground and it is not called a strike.", "Q063", 1);
        db.addAnswer(a187);

        ClassAnswer a188 = new ClassAnswer("A063b", "A lightning does not hit an object on the ground and it is not called a strike.", "Q063", 0);
        db.addAnswer(a188);

        ClassAnswer a189 = new ClassAnswer("A063c", "A lightning hits an object on the ground and it is called a strike.", "Q063", 0);
        db.addAnswer(a189);

        ClassAnswer a190 = new ClassAnswer("A064a", "A lightning hits an object or the object will not burn.", "Q064", 0);
        db.addAnswer(a190);

        ClassAnswer a191 = new ClassAnswer("A064b", "A lightning hits an object and the object will burn.", "Q064", 0);
        db.addAnswer(a191);

        ClassAnswer a192 = new ClassAnswer("A064c", "A lightning hits an object and the object will not burn.", "Q064", 1);
        db.addAnswer(a192);

        ClassAnswer a193 = new ClassAnswer("A065a", "The house is on fire and only the fire department can save lives.", "Q065", 0);
        db.addAnswer(a193);

        ClassAnswer a194 = new ClassAnswer("A065b", "The house is not on fire and not only the fire department can save lives.", "Q065", 0);
        db.addAnswer(a194);

        ClassAnswer a195 = new ClassAnswer("A065c", "The house is on fire and some lives can be saved by someone outside fire department.", "Q065", 1);
        db.addAnswer(a195);

        ClassAnswer a196 = new ClassAnswer("A066a", "There is a storm and some lightnings are not pretty spectacular.", "Q066", 0);
        db.addAnswer(a196);

        ClassAnswer a197 = new ClassAnswer("A066b", "There is a storm and all lightnings aren’t pretty spectacular.", "Q066", 0);
        db.addAnswer(a197);

        ClassAnswer a198 = new ClassAnswer("A066c", "There is a storm and no lightnings are pretty spectacular.", "Q066", 1);
        db.addAnswer(a198);

        ClassAnswer a199 = new ClassAnswer("A067a", "Lightning strikes a person and it is not usually fatal.", "Q067", 1);
        db.addAnswer(a199);

        ClassAnswer a200 = new ClassAnswer("A067b", "If lightning strikes a person, it is not usually fatal.", "Q067", 0);
        db.addAnswer(a200);

        ClassAnswer a201 = new ClassAnswer("A067c", "If lightning strikes a person, it is not fatal.", "Q067", 0);
        db.addAnswer(a201);

        ClassAnswer a203 = new ClassAnswer("A068a", "If somebody does not have a fear of thunder or lightning and they may have astraphobia.", "Q068", 0);
        db.addAnswer(a203);

        ClassAnswer a204 = new ClassAnswer("A068b", "Somebody has a fear of thunder or lightning and they may not have astraphobia.", "Q068", 1);
        db.addAnswer(a204);

        ClassAnswer a205 = new ClassAnswer("A068c", "If somebody does have a fear of thunder and lightning, they may have astraphobia.", "Q068", 0);
        db.addAnswer(a205);

        ClassAnswer a206 = new ClassAnswer("A069a", "You will learn more about lightning if you don’t study fulminology.", "Q069", 0);
        db.addAnswer(a206);

        ClassAnswer a207 = new ClassAnswer("A069b", "You will not learn more about lightning if you study fulminology.", "Q069", 0);
        db.addAnswer(a207);

        ClassAnswer a208 = new ClassAnswer("A069c", "You study fulminology and won’t learn more about lightning.", "Q069", 1);
        db.addAnswer(a208);

        ClassAnswer a209 = new ClassAnswer("A070a", "The distance is less than 20 kilometres and no one can hear the thunder.", "Q070", 1);
        db.addAnswer(a209);

        ClassAnswer a210 = new ClassAnswer("A070b", "The distance is less than 20 kilometres and some can’t hear the thunder.", "Q070", 0);
        db.addAnswer(a210);

        ClassAnswer a211 = new ClassAnswer("A070c", "The distance is less than 20 kilometres and everyone can hear the thunder.", "Q070", 0);
        db.addAnswer(a211);

        ClassAnswer a212 = new ClassAnswer("A071a", "If a volcano erupts then lava is expelled.", "Q071", 0);
        db.addAnswer(a212);

        ClassAnswer a213 = new ClassAnswer("A071b", "A volcano erupts and lava is not expelled.", "Q071", 1);
        db.addAnswer(a213);

        ClassAnswer a214 = new ClassAnswer("A071c", "If lava is expelled then a volcano erupts.", "Q071", 0);
        db.addAnswer(a214);

        ClassAnswer a215 = new ClassAnswer("A072a", "If lava stops moving then it solidifies.", "Q072", 0);
        db.addAnswer(a215);

        ClassAnswer a216 = new ClassAnswer("A072b", "Lava solidifies only when it stops moving.", "Q072", 0);
        db.addAnswer(a216);

        ClassAnswer a217 = new ClassAnswer("A072c", "Lava starts moving when it solidifies.", "Q072", 1);
        db.addAnswer(a217);

        ClassAnswer a218 = new ClassAnswer("A073a", "If the speed of the lava is higher then the viscosity is lower.", "Q073", 1);
        db.addAnswer(a218);

        ClassAnswer a219 = new ClassAnswer("A073b", "If the speed of the lava is higher then the viscosity is higher.", "Q073", 0);
        db.addAnswer(a219);

        ClassAnswer a220 = new ClassAnswer("A073c", "If the speed of the lava is lower then the viscosity is lower.", "Q073", 0);
        db.addAnswer(a220);

        ClassAnswer a221 = new ClassAnswer("A074a", "If exposed to the surface then magma becomes lava.", "Q074", 1);
        db.addAnswer(a221);

        ClassAnswer a222 = new ClassAnswer("A074b", "If exposed to the surface then lava becomes magma.", "Q074", 0);
        db.addAnswer(a222);

        ClassAnswer a223 = new ClassAnswer("A074c", "If not exposed to the surface then magma becomes lava.", "Q074", 0);
        db.addAnswer(a223);

        ClassAnswer a224 = new ClassAnswer("A075a", "Rocks melt if and only if they do not reach the melting point.", "Q075", 1);
        db.addAnswer(a224);

        ClassAnswer a225 = new ClassAnswer("A075b", "Rocks melt if they reach the melting point.", "Q075", 0);
        db.addAnswer(a225);

        ClassAnswer a226 = new ClassAnswer("A075c", "When rocks rich the melting point, they melt.", "Q075", 0);
        db.addAnswer(a226);
        //5 questions skipped

        ClassAnswer a242 = new ClassAnswer("A081a", "You will save the forest if and only if you stop the wildfire spreading.", "Q081", 0);
        db.addAnswer(a242);

        ClassAnswer a243 = new ClassAnswer("A081b", "Stopping the wildfire spreading you will save the forest.", "Q081", 0);
        db.addAnswer(a243);

        ClassAnswer a244 = new ClassAnswer("A081c", "If you do not stop the wildfire spreading then you won’t save the forest.", "Q081", 1);
        db.addAnswer(a244);

        ClassAnswer a245 = new ClassAnswer("A082a", "If the village is not safe then predators exist.", "Q082", 1);
        db.addAnswer(a245);

        ClassAnswer a246 = new ClassAnswer("A082b", "If the village was safe then predators did not existed.", "Q082", 0);
        db.addAnswer(a246);

        ClassAnswer a247 = new ClassAnswer("A082c", "If predators existed, the village is not safe.", "Q082", 0);
        db.addAnswer(a247);

        ClassAnswer a248 = new ClassAnswer("A083a", "If the war was lost, then battle training is not crucial", "Q083", 1);
        db.addAnswer(a248);

        ClassAnswer a249 = new ClassAnswer("A083b", "If the battle training is crucial then they will win the war.", "Q083", 0);
        db.addAnswer(a249);

        ClassAnswer a250 = new ClassAnswer("A083c", "Battle training is not crucial in order to win the war.", "Q083", 0);
        db.addAnswer(a250);

        ClassAnswer a251 = new ClassAnswer("A084a", "The village is in danger if no flooding occurred.", "Q084", 0);
        db.addAnswer(a251);

        ClassAnswer a252 = new ClassAnswer("A084b", "The village is in danger if some flooring occurred.", "Q084", 1);
        db.addAnswer(a252);

        ClassAnswer a253 = new ClassAnswer("A084c", "The village is not in danger if no flooring occurred.", "Q084", 0);
        db.addAnswer(a253);

        ClassAnswer a254 = new ClassAnswer("A085a", "The world is not safe if all villages are under attack", "Q085", 1);
        db.addAnswer(a254);

        ClassAnswer a255 = new ClassAnswer("A085b", "The world is safe if no village is under attack.", "Q085", 0);
        db.addAnswer(a255);

        ClassAnswer a256 = new ClassAnswer("A085c", "The world is not safe if some villages are under attack.", "Q085", 0);
        db.addAnswer(a256);

        ClassAnswer a257 = new ClassAnswer("A086a", "If village people will lose something, then nobody helped them.", "Q086", 0);
        db.addAnswer(a257);

        ClassAnswer a258 = new ClassAnswer("A086b", "If village people will lose everything, then somebody did not helped them.", "Q086", 0);
        db.addAnswer(a258);

        ClassAnswer a259 = new ClassAnswer("A086c", "If village people will lose everything, then nobody helped them.", "Q086", 1);
        db.addAnswer(a259);
        //4 questions skipped

        ClassAnswer a272 = new ClassAnswer("A091a", "Heroes are giving random acts of kindness.", "Q091", 1);
        db.addAnswer(a272);

        ClassAnswer a273 = new ClassAnswer("A091b", "People are heroes.", "Q091", 0);
        db.addAnswer(a273);

        ClassAnswer a274 = new ClassAnswer("A091c", "Random acts of kindness are given by some people.", "Q091", 0);
        db.addAnswer(a274);

        ClassAnswer a275 = new ClassAnswer("A092a", "Only heroes can save the world.", "Q092", 0);
        db.addAnswer(a275);

        ClassAnswer a276 = new ClassAnswer("A092b", "Everyone can save the world.", "Q092", 1);
        db.addAnswer(a276);

        ClassAnswer a277 = new ClassAnswer("A092c", "Not everyone can save the world.", "Q092", 0);
        db.addAnswer(a277);

        ClassAnswer a278 = new ClassAnswer("A093a", "The world is threatened.", "Q093", 0);
        db.addAnswer(a278);

        ClassAnswer a279 = new ClassAnswer("A093b", "Superheroes are reacting.", "Q093", 0);
        db.addAnswer(a279);

        ClassAnswer a280 = new ClassAnswer("A093c", "The world is not threatened.", "Q093", 1);
        db.addAnswer(a280);

        ClassAnswer a281 = new ClassAnswer("A094a", "Superheroes are not humans.", "Q094", 0);
        db.addAnswer(a281);

        ClassAnswer a282 = new ClassAnswer("A094b", "Humans don’t need to save the world.", "Q094", 1);
        db.addAnswer(a282);

        ClassAnswer a283 = new ClassAnswer("A094c", "Humans need to save the world.", "Q094", 0);
        db.addAnswer(a283);
*/

    }

    private void addLevels() {

        //This is the insert for test purposes on the summer project
        ClassLevel l1 = new ClassLevel(1,"Wind", "<p><b>Hi, Alchemist!</b></p> <p>Let’s master the" +
                " four basic nature elements and become a hero!</p> | <p>So this is the first level" +
                " of your power conquest. On this level you are going to learn the concept of " +
                "propositional logic. In the end of this level you will have the wind power which" +
                " is the first step to get the air power and to achieve that you need to prove " +
                "your knowledge about wind by answering 5 questions.</p> | <p>So lets get started " +
                "with the concepts:</p> <p>A concept identifies a certain class of things; a " +
                "proposition asserts something about that class. Concepts give us indispensable " +
                "tools for thought and speech by grouping together similar objects, actions, " +
                "properties, and relationships.| However, a concept by itself is not a complete " +
                "thought, and a word by itself doesn't say anything.</p> <p>Words need to be put " +
                "together into sentences that express propositions. One essential feature of a " +
                "proposition is that it is either true or false.</p> | <p>To assert a proposition, " +
                "we need a complete declarative sentence, with a subject and a predicate.</p> |" +
                "<p> Example:</p> <p><b>The following are propositions:</b></p> <p>The wind is the" +
                " flow of gases.</p> <p>The wind blows south in the winter.</p> <p>The wind is " +
                "blowing now.</p> | <p><b>The following are fragments:</b></p> <p> Wind </p> <p> " +
                "The wind from Ireland </p> <p> What a cold wind!</p>", "Tip1");
        db.addLevel(l1);

        //This is the insert for the first version of the app
       /* ClassLevel l1 = new ClassLevel(1,"Wind", "<p><b>Hello!</b><br/> This is " +
                "the first level of your power conquest. On this level you are going to " +
                "learn the concept of <b>propositional logic</b> and <b>contradictory propositions.</b> |" +
                "In the end of this level you will have the <b>wind power</b> which is the first " +
                "step to get the <b>air power</b>, but to finish the level one you have to prove " +
                "your knowledge about wind by answering 5 questions. " + "</p>|" +
                "<p>So, lets get started with the concepts:" + "</p>" +
                "<p><b>Propositional logics</b> is also called <b>“sentential logic”</b> or <b>“statement logic”</b> " +
                "and it deals with logical relationship between propositions (also called: " +
                "<b>claims</b>, <b>statement</b>, <b>sentences</b>, <b>assertions</b>, ..) taken as wholes.| A proposition " +
                "is a declarative sentence which has a <b>True/false</b> value and it is composed by a " +
                "subject term and a predicate term, for example:" + "</p>" +
                "<p>“The wind is cold”." + "</p>" + "<p>The wind= subject term" + "</p>" + "<p>“is cold” = " +
                "the predicate" + "</p>" + "<p>We symbolize the proposition using a single letter: " +
                "</p>" + "<p><b>j</b>: “ Jill is wearing a red dress”." + "</p>" + "<br />" + "|<p><b>Contradictories,</b> " +
                "operator \"<b>not</b>\":" + "</p>" + "<p>The Contradictory of A is a claim that always has the " +
                "opposite truth value of A. In the case of a simple proposition just use a " +
                "negative word or expression (<b>\"no\"</b>, <b>\"not\"</b>, <b>\"It is not true\"</b>, <b>\"It is false\"</b>...)" +
                " before the sentence, and you have the contradictory.| The <b>“not”</b> operator can also be " +
                "represented by <b>“¬”</b>. For example:" + "</p>" + "<p><b>a</b>: “The wind is blowing”" + "</p>" +
                "<p><b>¬a</b>: “The wind is not blowing”" + "</p>" + "<p>Notice that <b>‘¬a’</b> is the contradictory claim " +
                "of <b>‘a’</b> and vice-versa. " + "</p>", "Tip1");
        db.addLevel(l1);*/

        //This is the insert for test purposes on the summer project

        ClassLevel l2 = new ClassLevel(2,"Sound", "<p><b>Hi, Alchemist!</b></p> <p>This is the last level" +
                " of your air power conquest. On this level you are going to learn how to recognize " +
                "an argument. | In the end of this level you will have the air power, but to finish " +
                "the level 2 you have to prove your knowledge about sound as well as you proved " +
                "about wind by answering 5 questions right. </p> | <p>So, lets get started with the " +
                "concepts:</p> <p>In logic, we use the term \"argument\" to mean a set of propositions" +
                " in which some propositions--the premises--are asserted as support or evidence for " +
                "another--the conclusion. | The author doesn't just tell us something that he takes to " +
                "be true; he also presents reasons intended to convince us that it is true.</p> " +
                "<p>This intention is usually signaled by certain indicator words. The following is a " +
                "list of the more common indicator words:</p> | " +
                "<p><b>Premise Indicators :</b></p> <p>Since :: Because ::  As ::  For :: Given that ::  Assuming that</p>" +
                "<p><b>Conclusion Indicators:</b></p> <p>Therefore :: Thus :: So :: Consequently :: As a result :: It follows that</p>", "Tip2");
        db.addLevel(l2);

        //This is the insert for the first version of the app
        /*ClassLevel l2 = new ClassLevel(2,"Sound", "<p><b>Hello!</b> This is the last level of " +
                "your air power conquest. On this level you are going to learn the <b>conjunctions</b>. In " +
                "the end of this level you will have the <b>air power</b>, but to finish the level 2 you have" +
                " to prove your knowledge about <b>sound</b> as well as you proved about wind by answering 5" +
                " questions right." + "</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The " +
                "<b>conjunctions</b> use operators such as <b>“and”</b> or <b>“but”</b> to connect two simple propositions," +
                " for example:" + "</p>" + "<p>“The wind is blowing hard and it is raining”." + "</p>" +
                "<p>To evaluate this proposition as true <b>both</b> propositions must be <b>true</b>, if one is false" +
                " then the whole statement is false. The <b>“and”</b> operator can be also represented by <b>“^”</b>.</p>", "Tip2");
        db.addLevel(l2);*/

        ClassLevel l3 = new ClassLevel(3,"Metal", "<p>In order to master the <b>Earth power</b> " +
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
        db.addLevel(l3);

        ClassLevel l4 = new ClassLevel(4,"Sand", "<p>Hello! This is Level 4, the last step you have to go through" +
                " to get the <b>Earth</b> power. On this level you are going to learn about the <b>contradictory of a conjunction" +
                "</b> and to complete the level 4 you have to prove your knowledge about Sand by answering 5 questions right. </p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>The <b>Contradictory</b> of A is a claim that <b>always</b> has the <b>opposite</b> truth value of A.</p>" +
                "<p>Remember the conjunction is the compound claim that has the operator “OR” present. In order to write the " +
                "contradictory of a conjunction, you need to know the following rule:<p>" +
                "<p>not(A and B) = notA or notB</p>", "Tip 4");
        db.addLevel(l4);

        ClassLevel l5 = new ClassLevel(5,"Snow", "<p>Hello! This is Level 5, the first step you have to go through" +
                " to get the <b>Water</b> power. On this level you are going to learn about the <b>contradictory of a disjunction</b>" +
                " and to complete the level 5 you have to prove your knowledge about <b>sand</b> by answering 5 questions right. </p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>Remember that the Contradictory of A is a claim that always has the opposite truth value of A.</p>" +
                "<p>And also remember that the conjunction is the compound claim that has the operator “OR” present. In order " +
                "to write the contradictory of a conjunction, you need to know the following rule:</p>" +
                "<p>not(A or B) = notA and notB</p>", "Tip 5");
        db.addLevel(l5);

        ClassLevel l6 = new ClassLevel(6,"Plant", "<p>Hello! This is Level 6, the last step you have to go through" +
                " to get the <b>Water</b> power. On this level you are going to learn about the <b>conditional propositions</b>" +
                " and to complete the level 6 you have to prove your knowledge about <b>plants</b> by answering 5 questions right." +
                "</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The conditional proposition is represented in the " +
                "format: <b>if A then B</b>. Where A = antecedent and B = consequent. A conditional claim is false when the antecedent" +
                " is True but the consequent is false. When A is false or both A and B are True the proposition is True. Other way of" +
                " addressing this:</p>" + "<p>B if A = if A then B</p>", "Tip 6");
        db.addLevel(l6);

        ClassLevel l7 = new ClassLevel(7,"Lightning", "<p>Hello! This is Level 7, the first step you have to go through" +
                " to get the <b>Fire</b> power. On this level you are going to learn about the <b>contradictory of conditionals</b> and," +
                "in order to complete this level, you have to prove your knowledge about Lightning by answering 5 questions right.</p>" +
                "<p>So, lets get started with the concepts:</p>" +
                "<p>The contradictory of a conditional - NOT(if A then B) is a conjunction. This compound claim is True if antecedent is" +
                " true (A) but the consequence (B) is false. </p>" + "<p>not (if A then B) = A and not-B = A but not-B <> if A then not-B</p>", "Tip 7");
        db.addLevel(l7);

        ClassLevel l8 = new ClassLevel(8,"Lava", "<p>Hello! This is Level 8, the last step you have to go through to get the " +
                "<b>Fire</b> Power. On this level you are going to learn about the <b>equivalence</b> and, in order to complete this level, you have" +
                " to prove your knowledge about <b>Lava</b> by answering 5 questions right.</p>" + "<p>So, lets get started with the concepts:</p>" +
                "<p>Only If rule: A only if B = if A then B </p>" + "<p>Biconditional rule (conjoining two conditionals):</p>" +
                "<p>A if and only if B = (A if B) and (A only if B)</p>" + "<p>written as: A if and only if B = A iff B = A=B</p>" +
                "<p>or (if B then A) and (if A then B)</p>" + "<p>In this case, the claims A and B always have the same truth value: " +
                "if A is true then B is true and vice versa. We symbolize the logical equivalence of statement p and q by p ≡ q ( p <--> q ).</p>", "Tip 8");
        db.addLevel(l8);

        ClassLevel l9 = new ClassLevel(9,"Dark City", "</p>Hello! This is Level 9, the first step you have to go through in order" +
                " to become a <b>Hero!</b>. On this level you are going to learn about the <b>contrapositive</b> and, in order to complete this level, you have to " +
                "protect your people from attack of the <b>Dark City</b> by answering 5 questions right.</p> <p>So, lets get started with the concepts:</p>" + "<p>General rule: if A then B = if not-B " +
                "then not-A</p>" + "<p>ex: Conditional: (A: You won’t become a good player) if (B: you don’t practice)</p>" + "<p>where A: consequent and B: antecedent</p>" +
                "<p>Contrapositive: If you become a good player then you practiced.</p>", "Tip 9");
        db.addLevel(l9);

        ClassLevel l10 = new ClassLevel(10, "World Master", "<p><b>Congratulation!</b> This is Level 10, the last step you have to go through in order to become " +
                "a <b>The World Master</b> On this level you are going to learn about <b>inference</b> and, in order to complete this level, you have to save the world by answering" +
                " 5 questions right.</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The rule: true statements stand as premises and they can derive in conclusions" +
                " (respecting the rules learned by now and the semantics). </p>" + "<p>A→B</p>" + "<p>A/B</p>", "Tip 10");
        db.addLevel(l10);
    }
}
