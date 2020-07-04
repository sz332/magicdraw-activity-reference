package com.acme.magicdraw.activity.ui.action;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;

import com.acme.magicdraw.activity.ui.query.CallerActivitiesQuery;
import com.acme.magicdraw.activity.ui.query.CallerActivitiesQueryResult;
import com.acme.magicdraw.activity.ui.result.ReferencedActivitiesResult;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;

public class CalculateActivityReferencesAction extends DefaultBrowserAction {

	private static final long serialVersionUID = -513799663712552635L;

	public CalculateActivityReferencesAction(String id, String name) {
		super(id, name, null, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Tree tree = getTree();

		if (tree != null) {

			Project project = Application.getInstance()
			                             .getProject();
			
			List<String> selectedActivityIds = selectedActivities(tree);

			CallerActivitiesQuery query = new CallerActivitiesQuery(project, selectedActivityIds);
			CallerActivitiesQueryResult queryResult = query.execute();

			ReferencedActivitiesResult result = new ReferencedActivitiesResult();
			result.display(queryResult);
		}
	}

	private List<String> selectedActivities(Tree tree) {
		return Arrays.asList(tree.getSelectedNodes())
		             .stream()
		             .map(Node::getUserObject)
		             .filter(Activity.class::isInstance)
		             .map(Activity.class::cast)
		             .map(Activity::getID)
		             .collect(Collectors.toList());
	}

}
