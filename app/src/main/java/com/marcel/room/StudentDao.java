package com.marcel.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM student")
    List<Student>getAllStudents();

    @Insert
    void insertAll(Student... students);

}
