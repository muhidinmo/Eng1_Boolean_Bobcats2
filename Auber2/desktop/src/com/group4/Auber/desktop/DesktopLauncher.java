package com.group4.Auber.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.group4.Auber.AuberGame;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;


/**
 * the desktop launcher holder with the main function
 *
 * @author Robert Watts
 * @author Bogdan Bodnariu-Lescinschi
 */
public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		//Pack all of the textures into a texture atlas
		//REMOVE THIS CODE BEFORE RELEASING THE GAME
//		TexturePacker.Settings sets = new TexturePacker.Settings();
//		sets.pot = true;
//		sets.fast = true;
//		sets.combineSubdirectories = true;
//		sets.paddingX = 1;
//		sets.paddingY = 1;
//		sets.edgePadding = true;
//		TexturePacker.process(sets, "Sprites/TexturePack", "./", "textures");


		config.title = "Auber - Group 4";
		config.width = 1920;
		config.height = 1080;
		config.fullscreen = true;
		config.forceExit = false;
		new LwjglApplication(new AuberGame(), config);
		
	}
}