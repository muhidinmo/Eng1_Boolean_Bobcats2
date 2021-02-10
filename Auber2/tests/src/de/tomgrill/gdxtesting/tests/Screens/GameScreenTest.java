package de.tomgrill.gdxtesting.tests.Screens;

import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class GameScreenTest {

    @Test
    public void testAssets(){
        //Test if all the assets loaded by the TitleScreen class exist
        boolean errors = false;
        try {
            assertTrue("ambience.mp3 is missing", Gdx.files.internal("audio/ambience.mp3").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("mapScreen.png is missing", Gdx.files.internal("img/mapScreen.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("auber_map.tmx is missing", Gdx.files.internal("auber_map.tmx").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("mapdata.json is missing", Gdx.files.internal("mapdata.json").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("walkable_map.txt is missing", Gdx.files.internal("walkable_map.txt").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }
}