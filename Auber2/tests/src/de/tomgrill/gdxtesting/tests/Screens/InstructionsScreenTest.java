package de.tomgrill.gdxtesting.tests.Screens;

import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class InstructionsScreenTest {

    @Test
    public void testAssets(){
        //Test if all the assets loaded by the TitleScreen class exist
        boolean errors = false;
        try {
            assertTrue("instructions.png is missing", Gdx.files.internal("img/menu/instructions.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("backButtonInactive.png is missing", Gdx.files.internal("img/menu/backButtonInactive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("backButtonActive.png is missing", Gdx.files.internal("img/menu/backButtonActive.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }
}