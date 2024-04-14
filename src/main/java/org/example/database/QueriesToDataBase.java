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
        connection.getResultUpdate("CREATE TABLE IF NOT EXISTS public.song_smooth(id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1 ), PRIMARY KEY (id))");

        connection.getResultUpdate("Alter table song_smooth add column if not exists length_cycle integer NOT NULL");
        connection.getResultUpdate("Alter table song_smooth add column if not exists multiplication_hz float(53) NOT NULL");

        connection.getResultUpdate("Alter table song_smooth add column if not exists border_down integer NOT NULL");
        connection.getResultUpdate("Alter table song_smooth add column if not exists mode varchar(255) NOT NULL");

        connection.getResultUpdate("Alter table song_smooth add column if not exists duration_sound integer NOT NULL");
        connection.getResultUpdate("Alter table song_smooth add column if not exists volume integer NOT NULL");

        connection.getResultUpdate("Alter table song_smooth add column if not exists delay_cycle integer NOT NULL");
        connection.getResultUpdate("Alter table song_smooth add column if not exists smoothness integer NOT NULL");
    }

    public void addSong(Song song){
        connection.getResultUpdate("INSERT INTO public.song_smooth(length_cycle, multiplication_hz, border_down, mode, duration_sound, volume, delay_cycle,smoothness) VALUES ("+song.getLengthCycle() +","+song.getMultiplicationHz()+","+song.getBorderDown()+",'"+song.getMode()+"',"+song.getDurationSound()+","+song.getVolume()+","+song.getDelayCycle()+","+song.getSmoothness()+")");
    }

    public List<Song> getSongs(){
        List<Song> songs = new ArrayList<>();

        ResultSet resultSet = connection.getResultSet("SELECT id, length_cycle, multiplication_hz, border_down, mode, duration_sound, volume, delay_cycle, smoothness FROM public.song_smooth");

        while (true){

            try {
                if (resultSet.next()){
                    Song song = new Song();

                    song.setId( resultSet.getInt("id") );
                    song.setLengthCycle( resultSet.getInt("length_cycle") );
                    song.setMode( resultSet.getString("mode") );
                    song.setBorderDown( resultSet.getInt("border_down") );
                    song.setMultiplicationHz( resultSet.getDouble("multiplication_hz") );
                    song.setDurationSound(resultSet.getInt("duration_sound"));
                    song.setVolume( resultSet.getInt("volume") );
                    song.setDelayCycle( resultSet.getInt("delay_cycle") );
                    song.setSmoothness( resultSet.getInt("smoothness") );

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
