package org.example.database;

import org.example.Song;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueriesToDataBase {
    private ConnectionToDataBase connection = new ConnectionToDataBase();

    public void createDataBase(){
        connection.setLOGIN("postgres").setPASSWORD("1").setURL("jdbc:postgresql://localhost:5432/");
        connection.getResultUpdate("CREATE DATABASE the_planet_song");
    }

    public void initialization(){
        connection.setLOGIN("postgres").setPASSWORD("1").setURL("jdbc:postgresql://localhost:5432/the_planet_song");
        connection.getResultUpdate("CREATE TABLE IF NOT EXISTS public.song(id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1 ), PRIMARY KEY (id))");

        connection.getResultUpdate("Alter table song add column if not exists length_cycle integer NOT NULL");
        connection.getResultUpdate("Alter table song add column if not exists multiplication_hz float(53) NOT NULL");

        connection.getResultUpdate("Alter table song add column if not exists border_down integer NOT NULL");
        connection.getResultUpdate("Alter table song add column if not exists count_of_points integer NOT NULL");
        connection.getResultUpdate("Alter table song add column if not exists mode varchar(255) NOT NULL");

        connection.getResultUpdate("Alter table song add column if not exists speed integer NOT NULL");
        connection.getResultUpdate("Alter table song add column if not exists volume integer NOT NULL");
    }

    public void addSong(Song song){
        connection.getResultUpdate("INSERT INTO public.song(length_cycle, multiplication_hz, border_down, count_of_points, mode, speed, volume) VALUES ("+song.getLengthCycle() +","+song.getMultiplicationHz()+","+song.getBorderDown()+","+song.getCountOfPoints()+","+"'"+song.getMode()+"'"+","+song.getSpeed()+","+song.getVolume()+")");
    }

    public List<Song> getSongs(){
        List<Song> songs = new ArrayList<>();

        ResultSet resultSet = connection.getResultSet("SELECT id, length_cycle, multiplication_hz, border_down, count_of_points, mode, speed, volume FROM public.song");

        while (true){

            try {
                if (resultSet.next()){
                    Song song = new Song();

                    song.setId( resultSet.getInt("id") );
                    song.setLengthCycle( resultSet.getInt("length_cycle") );
                    song.setCountOfPoints( resultSet.getInt("count_of_points") );
                    song.setMode( resultSet.getString("mode") );
                    song.setBorderDown( resultSet.getInt("border_down") );
                    song.setMultiplicationHz( resultSet.getDouble("multiplication_hz") );
                    song.setVolume( resultSet.getInt("volume") );
                    song.setSpeed( resultSet.getInt("speed") );

                    songs.add(song);
                }else{
                    return songs;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
