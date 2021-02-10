package de.tomgrill.gdxtesting.tests.Actors;

import static org.junit.Assert.assertTrue;

import com.group4.Auber.Actors.Operative;
import com.group4.Auber.Actors.Player;
import com.group4.Auber.Actors.Systems;
import com.group4.Auber.AuberGame;
import com.group4.Auber.HUD.HUD;
import com.group4.Auber.MapRenderer;
import com.group4.Auber.OperativeAI.GridGraph;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public class SystemsTest {

    @Test
    public void onDeath() {
        //Setup for Tests
        AuberGame game = new AuberGame();
        Systems.systemsRemaining.clear();
        Systems system = mock(Systems.class);
        Systems system1 = mock(Systems.class);
        try {
            system = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
        }catch (NullPointerException e){
            system.game = game;
        }
        try {
            system1 = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
        }catch (NullPointerException e){
            system1.game = game;
        }
        //Tests if System is removed when it dies
        Systems.systemsRemaining.get(0).onDeath();
        assertTrue("System hasn't been removed from systemsRemaining", Systems.systemsRemaining.size() == 1);
        //Test if game ends when last system dies
        try {
            Systems.systemsRemaining.get(0).onDeath();
        }catch (IllegalArgumentException e){
            assertTrue("System hasn't been removed from systemsRemaining", Systems.systemsRemaining.size() == 0);
        }catch (Exception e){
            fail("system.onDeath() method failed to end the game when all systems are destroyed");
        }
    }

    @Test
    public void onHit() {
        //Setup for Tests
        AuberGame game = new AuberGame();
        Systems system = mock(Systems.class);
        Systems system1 = mock(Systems.class);
        Systems system2 = mock(Systems.class);
        try {
            system = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
        }catch (NullPointerException e){
            system.game = game;
        }
        try {
            system1 = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
        }catch (NullPointerException e){
            system1.game = game;
        }
        try {
            system2 = new Systems(0, 0, 0, 0, mock(MapRenderer.class), mock(HUD.class), "test", 100);
        }catch (NullPointerException e){
            system2.game = game;
        }
        //Test if system takes damage correctly
        Systems.systemsRemaining.get(0).onHit(mock(Operative.class), 10);
        assertTrue("System does not take damage correctly", Systems.systemsRemaining.get(0).health == 90);
        //Test if player can damage systems
        Systems.systemsRemaining.get(0).onHit(mock(Player.class), 10);
        assertTrue("Player managed to damage system", Systems.systemsRemaining.get(0).health == 90);
        //Test if system survives less than lethal damage
        Systems.systemsRemaining.get(0).onHit(mock(Operative.class), Systems.systemsRemaining.get(0).health-1);
        assertTrue("System failed to survive less than lethal damage", Systems.systemsRemaining.size() == 3);
        //Test if system dies when exact damage is taken
        Systems.systemsRemaining.get(0).onHit(mock(Operative.class), Systems.systemsRemaining.get(0).health);
        assertTrue("System hasn't been removed from systemsRemaining", Systems.systemsRemaining.size() == 2);
        //Test if system dies when excessive damage is taken
        Systems.systemsRemaining.get(0).onHit(mock(Operative.class), Systems.systemsRemaining.get(0).health+1);
        assertTrue("System failed to die when excessive damage was taken", Systems.systemsRemaining.size() == 1);

    }
}