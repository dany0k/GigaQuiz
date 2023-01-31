package ru.vsu.cs.zmaev.tools;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;

import ru.vsu.cs.zmaev.model.ImageQuestion;
import ru.vsu.cs.zmaev.model.User;

public class DataBaseTools {
    public static void populateDB(SQLiteDatabase db) {
        // Topics
        db.execSQL("INSERT INTO topic(topic_name) VALUES('Андроид')");
        db.execSQL("INSERT INTO topic(topic_name) VALUES('География')");
        db.execSQL("INSERT INTO topic(topic_name) VALUES('Марки авто')");
        db.execSQL("INSERT INTO topic(topic_name) VALUES('Наука')");
        // Answers
        // Android
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 1, 'Все из перечисленного', 'Tools', 'Documentation', 'Libraries');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 2, 'ViewGroup', 'ViewSet', 'ViewCollection', 'ViewRoot');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 3, 'Data binding', 'Data pushing', 'Set text', 'onClick');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 4, 'ConstraintLayout', 'GridLayout', 'LinearLayout', 'FrameLayout');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 5, 'Gradle', 'Graddle', 'Grodle', 'Gruadle');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 6, 'VectorDrawable', 'AndroidVectorDrawable', 'DrawableVector', 'AndroidVector');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 7, 'NavController', 'NavCentral', 'NavMaster', 'NavSwitcher');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 8, 'intent-filter', 'app-registry', 'launcher-registry', 'app-launcher');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 9, '<layout>', '<dbinding>', '<data-binding>', '<binding>');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(1, 10, 'findViewById', 'findViewId', 'findById', 'FindViewID');");
        // Geographical
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 1, 'Байкал', 'Каспийское море', 'Виктория', 'Мичиган');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 2, 'Тирана', 'София', 'Братислава', 'Загреб');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 3, 'Аргентина', 'Бельгия', 'Уругвай', 'Либерия');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 4, 'Эльбрус', 'Эверест', 'Шхара', 'Монбланч');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 5, 'Стамбул', 'Лондон', 'Москва', 'Париж');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 6, 'Индонезия', 'Малайзия', 'Австралия', 'Сунгапур');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 7, 'США', 'Канада', 'Китай', 'Бразилия');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 8, 'Австрия', 'Словения', 'Бельгия', 'Болгария');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 9, 'Суринам', 'Гайана', 'Французская Гвиана', 'Уругвай');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(2, 10, 'Макао', 'Гонконг', 'Тайвань', 'Тибет');");
        // Auto Brands
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 1, 'Alfa Romeo', 'Nissan', 'Acura', 'Vauxhall');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 2, 'Chevrolet', 'Ford', 'Nissan', 'Toyota');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 3, 'Honda', 'Hyundai', 'Nissan', 'Haval');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 4, 'Hyundai', 'Honda', 'Haval', 'Nissan');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 5, 'Opel', 'Vauxhall', 'Renault', 'Nissan');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 6, 'Peugeot', 'Scania', 'SAB', 'Citroen');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 7, 'Seat', 'Subaru', 'Suzuki', 'Scania');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 8, 'Subaru', 'Siat', 'Suzuki', 'Ford');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 9, 'Suzuki', 'Seat', 'Subaru', 'Scania');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(3, 10, 'Toyota', 'Audi', 'Acura', 'Ford');");
        // Science
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 1, 'Ботаника', 'Экология', 'Микрология', 'Агрономия');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 2, 'Юпитер', 'Сатурн', 'Уран', 'Марс');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 3, 'O', 'H', 'N', 'Ox');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 4, 'Азот', 'Водород', 'Кислород', 'Бор');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 5, 'Солнце', 'Полярная звезда', 'Сириус', 'Альдебаран');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 6, 'Пауки', 'Волки', 'Муравьи', 'Гусинецы');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 7, 'Альберт Эйнштейн', 'Мария Кюри', 'Джозеф Томсон', 'Никола Тесла');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 8, '0', '~3000', '~300', '1');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 9, 'Науковедение', 'Наукометрия', 'Философия', 'Наукология');");
        db.execSQL("INSERT INTO answer(" +
                "topic_id, question_id, first_answer, second_answer, third_answer, fourth_answer)" +
                " VALUES(4, 10, 'ЮНЕСКО', 'ООН', 'ОБСЕ', 'СНГ');");
        // Questions
        // Android
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "1, 1, 'Что такое Android Jetpack', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "2, 1, 'Что является базовым классом для layout?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "3, 1, 'Что используется для добавления структурированных данных в layout?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "4, 1, 'Какой layout используется для сложных экранов?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "5, 1, 'Как называется система сборки для Android?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "6, 1, 'Какой класс используется для создания векторного рисунка?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "7, 1, 'Что из перечисленного является компонентом навигации Android?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "8, 1, 'Какой элемент XML позволяет зарегистрировать действие в средстве запуска?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "9, 1, 'Какой тэг используется для соединения UI приложения и бизнес-логики?', 'android_category_simple');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "10, 1, 'Какой метод находит объект по id?', 'android_category_simple');");
        // Geographical
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "1, 2, 'Какое самое глубокое озеро в мире?', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "2, 2, 'Столица Албании?', 'city');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "3, 2, 'Какой стране принадлежит этот флаг', 'argentina_flag');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "4, 2, 'Какая самая высокая гора в Европе?', 'mountain');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "5, 2, 'Какой самый крупный город по населению в Европе?', 'city');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "6, 2, 'Столицей какого государства является Джакарта?', 'city');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "7, 2, 'Какая страна является третьей по площади в мире?', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "8, 2, 'Какая страна изображена на силуете?', 'austria');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "9, 2, 'Какая страна является самой малой по площади в Южной Америке?', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "10, 2, 'Какая страна является бывшей колонией Португалии в Китае', 'earth');");
        // Auto brands
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "1, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'alfa_romeo_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "2, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'chevrolet_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "3, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'honda_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "4, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'hyundai_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "5, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'opel_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "6, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'peugeot_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "7, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'seat_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "8, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'subaru_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "9, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'suzuki_logo');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "10, 3, 'Автомобилю какой марки принадлежит данный логотип?', 'toyota_logo');");

        // Science
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "1, 4, 'Каково название науки, занимающейся изучением растений', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "2, 4, 'Назовите крупнейшую планету в нашей Солнечной системе', 'planet');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "3, 4, 'Назовите химический символ кислорода', 'chemistry_formula');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "4, 4, 'Назовите седьмой элемент периодической таблицы Менделеева', 'chemistry_formula');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "5, 4, 'Как называется звезда, которая находится ближе всего к Земле?', 'planet');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "6, 4, 'Страх перед каким животным называется арахнофобией?', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "7, 4, 'Какой учёный был удостоен Нобелевской премии 1921 года по физике?', 'atom');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "8, 4, 'Сколько костей в своём теле имеет акула?', 'fish_bone');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "9, 4, 'Как называется дисциплина, изучающая науку?', 'earth');");
        db.execSQL("INSERT INTO question(question_id, topic_id, question_text, icon_name) VALUES(" +
                "10, 4, 'Как называется организация, способствующая сотрудничеству ученых по всему миру?', 'chemistry_formula');");
        // Country
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Армения', 'armenia')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Азербайджан', 'azerbaijan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Беларусь', 'belarus')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Грузия', 'georgia')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Казахстан', 'kazakhstan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Кыргызстан', 'kyrgyzstan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Молдова', 'moldova')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Россия', 'russia')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Таджикистан', 'tajikistan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Туркменистан', 'turkmenistan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Узбекситан', 'uzbekistan')");
        db.execSQL("INSERT INTO country(country_name, country_icon_name) VALUES(" +
                "'Украина', 'ukraine')");
    }

    public static void createDB(SQLiteDatabase db) {
        // Answers Table
        db.execSQL("CREATE TABLE IF NOT EXISTS answer(" +
                "answer_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "topic_id INTEGER NOT NULL," +
                "question_id INTEGER NOT NULL," +
                "first_answer TEXT NOT NULL," +
                "second_answer TEXT NOT NULL, third_answer TEXT NOT NULL," +
                "fourth_answer TEXT NOT NULL," +
                "FOREIGN KEY (topic_id) REFERENCES topic(topic_id)," +
                "FOREIGN KEY (question_id) REFERENCES question(question_id));");
        // Topic Table
        db.execSQL("CREATE TABLE IF NOT EXISTS topic(" +
                "topic_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " topic_name TEXT NOT NULL);");
        // Question Table
        db.execSQL("CREATE TABLE IF NOT EXISTS question(" +
                "question_id INTEGER," +
                " topic_id INTEGER NOT NULL," +
                "question_text TEXT NOT NULL," +
                "icon_name TEXT NOT NULL," +
                "FOREIGN KEY (topic_id) REFERENCES topic(topic_id));");
        // User Table
        db.execSQL("CREATE TABLE IF NOT EXISTS user( " +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "country_id INTEGER NOT NULL," +
                "result_id INTEGER, " +
                "question_id INTEGER, " +
                "name TEXT NOT NULL, " +
                "age INTEGER NOT NULL, " +
                "sex TEXT NOT NULL, " +
                "user_icon_name TEXT NOT NULL, " +
                "FOREIGN KEY (country_id) REFERENCES country(country_id), " +
                "FOREIGN KEY (result_id) REFERENCES result(result_id), " +
                "FOREIGN KEY (question_id) REFERENCES question(question_id));");
        // Result Table
        db.execSQL("CREATE TABLE IF NOT EXISTS result(" +
                "result_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "topic_id INTEGER NOT NULL, user_id INTEGER NOT NULL, " +
                "percentage INTEGER, " +
                "FOREIGN KEY (topic_id) REFERENCES topic(topic_id), " +
                "FOREIGN KEY (user_id) REFERENCES user(user_id));");
        // Country table
        db.execSQL("CREATE TABLE IF NOT EXISTS country(" +
                "country_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " country_name TEXT NOT NULL," +
                " country_icon_name TEXT NOT NULL);");
    }

    public static SQLiteDatabase openDataBase(Context context) {
        return context.openOrCreateDatabase("gigaquiz.db",
                context.MODE_PRIVATE, null);
    }

    public static boolean insertUser(SQLiteDatabase db, User user) {
        ContentValues contentValues = new ContentValues();
        System.out.println(user.toString());
        contentValues.put("country_id", user.getCountryID());
        contentValues.put("result_id", user.getResultID());
        contentValues.put("question_id", user.getQuestionID());
        contentValues.put("name", user.getName());
        contentValues.put("age", user.getAge());
        contentValues.put("sex", user.getSex());
        contentValues.put("user_icon_name", user.getUserIconName());
        long result = db.insert("user", null, contentValues);
        addResults(db, user.getUserID());
        return result != -1;
    }

    public static void updateUser(SQLiteDatabase db, User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", user.getName());
        contentValues.put("age", user.getAge());
        contentValues.put("sex", user.getSex());
        contentValues.put("country_id", user.getCountryID());
        // Изменть где user_id
         db.update("user", contentValues, "user_id" + " = " + user.getUserID(), null);
    }

    public static void checkResults() {

    }

    private static void addResults(SQLiteDatabase db, int userID) {
        ContentValues contentValues = new ContentValues();
        Cursor queryTopic = db.rawQuery("SELECT * FROM topic;", null);
        int defaultPercentage = 0;
        while (queryTopic.moveToNext()) {
            contentValues.put("topic_id", queryTopic.getString(0));
            contentValues.put("user_id", userID);
            contentValues.put("percentage", defaultPercentage);
            db.insert("result", null, contentValues);
            contentValues.clear();
        }
    }

    public static void addResult(SQLiteDatabase db, int topicID, int percentage) {
        ContentValues contentValues = new ContentValues();
        String query = "SELECT percentage FROM result WHERE topic_id = ?;";
        Cursor cursor = db.rawQuery(query, new String[] {String.valueOf(topicID)});
        if (cursor.moveToFirst()) {
            int prevPercentage = Integer.parseInt(cursor.getString(0));
            if (prevPercentage > percentage) {
                return;
            }
            contentValues.put("percentage", percentage);
            db.update("result", contentValues, "topic_id" + " = " + topicID, null);
            contentValues.clear();
        }
    }

    public static List<ImageQuestion> getQuestionsBank(Context context, SQLiteDatabase db, int topicID) {
        List<ImageQuestion> questionsBank = new ArrayList<>();
        String questionQuery = "SELECT question_id, question_text, icon_name FROM question WHERE topic_id = ?";
        Cursor questionCursor = db.rawQuery(questionQuery, new String[] {String.valueOf(topicID)});
        String questionID;
        String questionText;
        String iconName;
        int iconID;
        List<String> answers;
        while (questionCursor.moveToNext()) {
            questionID = questionCursor.getString(0);
            questionText = questionCursor.getString(1);
            iconName = questionCursor.getString(2);
            iconID = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
            String answersQuery = "SELECT first_answer, second_answer, third_answer, fourth_answer" +
                    " FROM answer WHERE topic_id = ? AND question_id = ?";
            Cursor answersCursor = db.rawQuery(answersQuery, new String[] {String.valueOf(topicID),
            questionID});
            while (answersCursor.moveToNext()) {
                String firstAnswer = answersCursor.getString(0);
                String secondAnswer = answersCursor.getString(1);
                String thirdAnswer = answersCursor.getString(2);
                String fourthAnswer = answersCursor.getString(3);
                answers = Arrays.asList(firstAnswer, secondAnswer, thirdAnswer, fourthAnswer);
                ImageQuestion question = new ImageQuestion(questionText, answers, iconID);
                questionsBank.add(question);
            }
        }
        return questionsBank;
    }

    public static String[] getTopics(SQLiteDatabase db) {
        String[] topics = new String[4];
        Cursor query = db.rawQuery("SELECT topic_name FROM topic;", null);
        for (int i = 0; i < topics.length && query.moveToNext(); i++) {
            topics[i] = query.getString(0);
        }
        return topics;
    }
}
