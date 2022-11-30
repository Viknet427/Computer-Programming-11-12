package com.gamefromscratch.helloworld.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gamefromscratch.AnimationDemo;
import com.gamefromscratch.InputDemo2;
import com.gamefromscratch.InputDemo3;
import com.gamefromscratch.graphicsdemo.GraphicsDemo;
import com.gamefromscratch.helloworld.HelloWorld;
import input.gamefromscratch.com.InputDemo;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Input Demo2";
		config.useGL30 = false;
		config.width = 480;
		config.height = 320;

		new LwjglApplication(new InputDemo3(), config);
	}
}
