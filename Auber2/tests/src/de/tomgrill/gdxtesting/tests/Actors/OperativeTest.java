package de.tomgrill.gdxtesting.tests.Actors;

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
public class OperativeTest {

    @Test
    public void testAssets(){
        //Tests that all the assets Operative class require exist
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
    public void onDeath() {
        //Setup for Tests
        AuberGame game = new AuberGame();
        try {
            Systems system = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
            system.game = game;
        }catch (NullPointerException e){
            ;
        }
        Operative operative = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative.game = game;
        Operative operative1 = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative1.game = game;
        //Tests if operative dies when method is called
        operative.onDeath();
        assertTrue("Operative isn't dead", operative.dead);
        //Tests if game ends when all operatves are dead
        try {
            operative1.onDeath();
        }catch (IllegalArgumentException e){
            assertTrue("Operative isn't dead", operative.dead);
        }catch (Exception e){
            fail("operative.onDeath() method failed to end the game when all operatives are apprehended");
        }
    }

    @Test
    public void onHit() {
        //Setup for Test
        AuberGame game = new AuberGame();
        try {
            Systems system = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
            system.game = game;
        }catch (NullPointerException e){
            ;
        }
        Operative operative = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative.game = game;
        Operative operative1 = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative1.game = game;
        //Test if operative takes damage correctly
        operative.onHit(mock(Player.class), 10);
        assertTrue("Operative does not take damage correctly or has default less than 11 health",new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class)).health - 10 == operative.health);
        //Test if operative survives less than lethal damage
        operative.onHit(mock(Player.class), operative.health-1);
        assertTrue("Operative failed to survive less than lethal damage", !(operative.dead));
        //Test if operative dies when exact damage is taken
        operative.onHit(mock(Player.class), operative.health);
        assertTrue("Operative failed to die when exact damage was taken", operative.dead);
        //Test if operative dies when excessive damage is taken
        operative = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative.onHit(mock(Player.class), operative.health + 1);
        assertTrue("Operative failed to die when excessive damage was taken", operative.dead);
        //Test if operatives can damage operatives
        operative = new Operative(0, 0, mock(MapRenderer.class), mock(HUD.class), mock(GridGraph.class));
        operative.onHit(operative, operative.health);
        assertTrue("Operative managed to damage itself", !(operative.dead));
    }
}