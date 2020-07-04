package com.acme.magicdraw.activity;

import com.acme.magicdraw.activity.ui.action.ActivityReferenceConfigurator;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.plugins.Plugin;

public class ActivityReferencesPlugin extends Plugin {

	@Override
	public void init() {
		System.out.println("Activities reference plugin initialized");
		Application.getInstance().getGUILog().showMessage("Activities reference initialized");
		ActionsConfiguratorsManager.getInstance().addContainmentBrowserContextConfigurator(new ActivityReferenceConfigurator());
	}

	@Override
	public boolean close() {
		return true;
	}

	@Override
	public boolean isSupported() {
		return true;
	}

}
