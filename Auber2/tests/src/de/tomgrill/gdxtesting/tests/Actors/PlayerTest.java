package de.tomgrill.gdxtesting.tests.Actors;

import static org.junit.Assert.assertTrue;
import com.badlogic.gdx.Gdx;
import com.group4.Auber.*;
import com.group4.Auber.Actors.Operative;
import com.group4.Auber.Actors.Player;
import com.group4.Auber.Screens.TitleScreen;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class PlayerTest {

    @Test
    public void testAssets(){
        //Test if all the assets loaded by the player class exist
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
    public void testDeath(){
        //Test if the player death method completes
        AuberGame game = new AuberGame();
        Player player = new Player(mock(MapRenderer.class), 0, 0);
        player.game = game;
        try {
            player.onDeath();
        }catch (IllegalArgumentException e){
            ;
        }catch (Exception e){
            fail("player.onDeath() method failed to complete");
        }
    }

    @Test
    public void onHit() {
        //Setup for Test
        AuberGame game = new AuberGame();
        Player player = new Player(mock(MapRenderer.class), 0, 0);
        player.game = game;
        //Test if player takes damage correctly
        player.onHit(mock(Operative.class), 10);
        assertTrue("Player does not take damage correctly or has less than 11 health by default",new Player(mock(MapRenderer.class), 0, 0).getHealth() - 10 == player.getHealth());
        //Test if player survives when less than lethal damage is taken
        try {
            player.onHit(mock(Operative.class), player.getHealth() -1);
        }catch (IllegalArgumentException e){
            fail("Player does not survive less than lethal damage");
        }
        //Test if player dies when exact damage is taken
        try {
            player.onHit(mock(Operative.class), player.getHealth());
        }catch (IllegalArgumentException e){
            ;
        }catch (Exception e){
            fail("player failed to die when exact damage was taken");
        }
        //Test if player dies when excessive damage is taken
        player = new Player(mock(MapRenderer.class), 0, 0);
        try {
            player.onHit(mock(Operative.class), player.getHealth() + 1);
        }catch (IllegalArgumentException e){
            ;
        }catch (Exception e){
            fail("player failed to die when excessive damage was taken");
        }
        //Test if player can damage themselves
        player = new Player(mock(MapRenderer.class), 0, 0);
        player.onHit(player, 10);
        assertTrue("Player has managed to damage itself",new Player(mock(MapRenderer.class), 0, 0).getHealth()  == player.getHealth());
    }
}
