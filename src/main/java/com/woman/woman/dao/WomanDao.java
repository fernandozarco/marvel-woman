package com.woman.woman.dao;

import com.woman.woman.models.Woman;

import java.util.List;

public interface WomanDao {

    List<Woman> getWomans();

    void delete(Long id);

    void create(Woman woman);

    boolean checkWoman(Woman woman);
}