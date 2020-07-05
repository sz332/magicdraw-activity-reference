package com.acme.magicdraw.activity.ui.action;

import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.magicdraw.actions.ActionsID;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.utils.PriorityProvider;

public class ActivityReferenceConfigurator implements BrowserContextAMConfigurator {

	private static final String ACTION_ID = "ACTIVITY_REFERENCES";
	private static final String ACTION_NAME = "Activity References";

	@Override
	public int getPriority() {
		return PriorityProvider.LOW_PRIORITY;
	}

	@Override
	public void configure(ActionsManager manager, Tree tree) {
		ActionsCategory category = (ActionsCategory) manager.getActionFor(ActionsID.RELATED_ELEMENTS_SUBMENU);

		if (category != null) {
			category.addAction(new CalculateActivityReferencesAction(ACTION_ID, ACTION_NAME));
		}
	}
}
