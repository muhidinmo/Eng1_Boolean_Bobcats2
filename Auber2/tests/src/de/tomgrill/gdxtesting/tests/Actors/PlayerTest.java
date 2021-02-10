package de.tomgrill.gdxtesting.tests.Actors;

import static org.junit.Assert.assertTrue;


import com.badlogic.gdx.Gdx;

import com.group4.Auber.*;
import com.group4.Auber.Actors.Player;

import com.group4.Auber.Screens.TitleScreen;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;


import de.tomgrill.gdxtesting.GdxTestRunner;

import java.util.EmptyStackException;

@RunWith(GdxTestRunner.class)
public class PlayerTest {

    @Test
    public void testAssets(){
        boolean errors = false;
        try {
            assertTrue("player.png is missing", Gdx.files.internal("img/player.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("player_up.png is missing", Gdx.files.internal("img/player_up.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("player_left.png is missing", Gdx.files.internal("img/player_left.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("player_right.png is missing", Gdx.files.internal("img/player_right.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("player_attack.png is missing", Gdx.files.internal("img/player_attack.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        try {
            assertTrue("player_target.png is missing", Gdx.files.internal("img/player_target.png").exists());
        }catch (AssertionError e){
            System.out.println(e.getMessage());
            errors = true;
        }
        if (errors){
            fail("There are missing files");
        }
    }

    @Test
    public void testDeath() throws EmptyStackException {
        AuberGame game = new AuberGame();
        game.setScreen(mock(TitleScreen.class));
        Player player = new Player(mock(MapRenderer.class), 0, 0);
        player.game = game;
        try {
            player.onDeath();
        }catch (IllegalArgumentException e){
            ;
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

}
