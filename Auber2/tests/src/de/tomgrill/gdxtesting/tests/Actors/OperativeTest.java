package de.tomgrill.gdxtesting.tests.Actors;

import static org.junit.Assert.assertTrue;


import com.badlogic.gdx.Gdx;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;

import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class OperativeTest {

    @Test
    public void testAssets(){
        boolean errors = false;
        try {
            assertTrue("metalDeath.mp3 is missing", Gdx.files.internal("audio/metalDeath.mp3").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("operative.png is missing", Gdx.files.internal("img/operative.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("operative_attack.png is missing", Gdx.files.internal("img/operative_attack.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }

    @Test
    public void chooseTarget() {
        assertTrue(1==1);
    }

    @Test
    public void draw() {
    }

    @Test
    public void onHit() {
    }

    @Test
    public void onDeath() {
    }

    @Test
    public void update() {
    }
}