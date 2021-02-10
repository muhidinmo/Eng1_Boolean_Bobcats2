package de.tomgrill.gdxtesting.tests.Screens;

import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class GameEndScreenTest {

    @Test
    public void testAssets(){
        //Test if all the assets loaded by the TitleScreen class exist
        boolean errors = false;
        try {
            assertTrue("gameWin.png is missing", Gdx.files.internal("img/gameWin.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("gameOver.png is missing", Gdx.files.internal("img/gameOver.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("menuButtonInactive.png is missing", Gdx.files.internal("img/menu/menuButtonInactive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("menuButtonActive.png is missing", Gdx.files.internal("img/menu/menuButtonActive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }
}