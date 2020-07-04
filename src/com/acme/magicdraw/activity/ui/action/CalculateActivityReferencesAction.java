package com.acme.magicdraw.activity.ui.action;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.acme.magicdraw.activity.ui.query.CallerActivities;
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

	public void actionPerformed(ActionEvent e) {
		Tree tree = getTree();

		Project project = Application.getInstance().getProject();
		List<String> selectedActivityIds = selectedActivities(tree);

		CallerActivities query = new CallerActivities(project, selectedActivityIds);
		Map<String, List<Activity>> activityMap = query.callerActivities();

		ReferencedActivitiesResult result = new ReferencedActivitiesResult(project);
		result.display(activityMap);
	}

	private List<String> selectedActivities(Tree tree) {
		List<Node> nodes = Arrays.asList(tree.getSelectedNodes());
		
		return nodes.stream()
				.map(Node::getUserObject)
				.filter(Activity.class::isInstance)
				.map(Activity.class::cast)
				.map(Activity::getID)
				.collect(Collectors.toList());
	}

}
