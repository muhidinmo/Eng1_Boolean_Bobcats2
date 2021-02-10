package de.tomgrill.gdxtesting.tests.HUD;

import static org.junit.Assert.assertTrue;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.utils.Null;
import com.group4.Auber.Actors.Operative;
import com.group4.Auber.Actors.Player;
import com.group4.Auber.Actors.Systems;
import com.group4.Auber.AuberGame;
import com.group4.Auber.HUD.HUD;
import com.group4.Auber.MapRenderer;
import com.group4.Auber.OperativeAI.GridGraph;
import com.group4.Auber.Screens.TitleScreen;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class NotificationWindowTest {

    @Test
    public void testAssets(){
        //Tests that all the assets Operative class require exist
        boolean errors = false;
        try {
            assertTrue("notification.mp3 is missing", Gdx.files.internal("audio/notification.mp3").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }
}