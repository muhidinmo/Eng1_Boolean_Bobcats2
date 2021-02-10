package de.tomgrill.gdxtesting.tests.Screens;

import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class TitleScreenTest {

    @Test
    public void testAssets(){
        //Test if all the assets loaded by the TitleScreen class exist
        boolean errors = false;
        try {
            assertTrue("menuMusic.mp3 is missing", Gdx.files.internal("audio/menuMusic.mp3").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("Nebula-Aqua-Pink.png is missing", Gdx.files.internal("img/tilesets/Nebula-Aqua-Pink.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("menuSelect.ogg is missing", Gdx.files.internal("audio/menuSelect.ogg").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("auberLogo.png is missing", Gdx.files.internal("img/menu/auberLogo.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("playButtonInactive.png is missing", Gdx.files.internal("img/menu/playButtonInactive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("playButtonActive.png is missing", Gdx.files.internal("img/menu/playButtonActive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("instructionsButtonInactive.png is missing", Gdx.files.internal("img/menu/instructionsButtonInactive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("instructionsButtonActive.png is missing", Gdx.files.internal("img/menu/instructionsButtonActive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("quitButtonInactive.png is missing", Gdx.files.internal("img/menu/quitButtonInactive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("quitButtonActive.png", Gdx.files.internal("img/menu/quitButtonActive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }
}