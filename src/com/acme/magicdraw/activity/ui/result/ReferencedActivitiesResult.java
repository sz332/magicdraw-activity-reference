package com.acme.magicdraw.activity.ui.result;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.ui.browser.Browser;
import com.nomagic.magicdraw.ui.browser.SearchResultsTree;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class ReferencedActivitiesResult {
	
	private final Project project;
	
	public ReferencedActivitiesResult(Project project) {
		this.project = project;
	}
	
	public void display(Map<String, List<Activity>> referencedActivities) {
		
		Browser browser = Application.getInstance().getMainFrame().getBrowser();

		SearchResultsTree searchResultTree = browser.getSearchResultsTree(true);
		searchResultTree.clearSearchResults();
		
		Collection<List<Activity>> foundActivities = referencedActivities.values();
		
		for (List<Activity> activities : foundActivities) {
			List<Element> elements = new ArrayList<>();
			elements.addAll(activities);
			searchResultTree.addFoundElements(elements);
		}
		
	}

}
