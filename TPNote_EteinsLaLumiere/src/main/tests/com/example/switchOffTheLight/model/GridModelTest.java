package com.example.switchOffTheLight.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridModelTest {

    GridModel model;

    @BeforeEach
    void beforeEach ()
    {
        //Initialisation
        model = new GridModel();
    }

    @Test
    void test_clickOnLight_allFalse()
    {
        //Tests
        for (int i = 0 ; i < GridModel.LENGTH_X ; i ++)
            for (int j = 0 ; j < GridModel.LENGTH_Y ; j ++)
                assertFalse(this.model.getLight(i, j));
    }

    @Test
    void test_invert_Ok()
    {
        //Method call
        this.model.invert(0,0);

        //Tests
        assertTrue(this.model.getLight(0, 0), "should be true");
    }

    @Test
    void test_inGrid_in() {
        //Method call
        this.model.inGrid(1,2);
    }

    @Test
    void getLight() {
    }
}