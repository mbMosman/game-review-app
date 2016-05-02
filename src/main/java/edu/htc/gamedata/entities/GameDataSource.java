package edu.htc.gamedata.entities;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class GameDataSource {

    private static final String GAMES_TABLE_CREATE =
            "CREATE TABLE games ( " +
                "id INTEGER PRIMARY KEY, " +
                "name VARCHAR(50)" +
                "platform VARCHAR(25)" +
            ");";

    private static final String GAMES_TAGS_TABLE_CREATE =
            "CREATE TABLE games ( " +
                "game_id INTEGER references games(id), " +
                "tag VARCHAR(50) " +
            ");";

    private static final String REVIEWERS_TABLE_CREATE =
            "CREATE TABLE reviewers ( " +
                "user_id VARCHAR(50) PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "age INTEGER, " +
                "gender VARCHAR(25), " +
                "comments CLOB, " +
                "password VARCHAR (50) " + // NOTE this is a bad example of storing passwords.  They should be encrypted.
            ");";

    private static final String REVIEWS_TABLE_CREATE =
            "CREATE TABLE reviews ( " +
                "id INTEGER PRIMARY KEY, " +
                "game_id INTEGER references games(id), " +
                "review_id INTEGER references reviews(id) " +
                "comments CLOB, " +
                "date TIMESTAMP " +
            ");";

    private static final String FAVORITE_GAMES_TABLE_CREATE =
            "CREATE TABLE reviews ( " +
                    "game_id INTEGER references games(id), " +
                    "user_id VARCHAR(50) references reviewers(user_id) " +
            ");";


  /*
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.DERBY)
                .addScript(GAMES_TABLE_CREATE)
                .addScript(GAMES_TAGS_TABLE_CREATE)
                .addScript(REVIEWERS_TABLE_CREATE)
                .addScript(REVIEWS_TABLE_CREATE)
                .addScript(FAVORITE_GAMES_TABLE_CREATE)
                .build();
        return db;
    }
    */
}