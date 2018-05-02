package com.aplose.smooss.factory;

import com.aplose.smooss.model.BringModule;
import com.aplose.smooss.model.CarPoolingModule;
import com.aplose.smooss.model.ChatModule;
import com.aplose.smooss.model.MiniGameModule;
import com.aplose.smooss.model.Module;
import com.aplose.smooss.model.Module.TypeModule;
import com.aplose.smooss.model.PicturesModule;
import com.aplose.smooss.model.PlaylistModule;
import com.aplose.smooss.model.TriCountModule;

//Flavien && Rachid : Create class FactoryModule
public class FactoryModule {
	public Module creerModule(TypeModule type) {
		Module module = null;

		switch (type) {
		case CarpoolingModule:
			module = new CarPoolingModule();
			break;
		case BringModule:
			module = new BringModule();
			break;
		case PicturesModule:
			module = new PicturesModule();
			break;
		case TriCountModule:
			module = new TriCountModule();
			break;
		case MiniGameModule:
			module = new MiniGameModule();
			break;
		case ChatModule:
			module = new ChatModule();
			break;
		case PlaylistModule:
			module = new PlaylistModule();
			break;

		}
		return module;
	}

}
