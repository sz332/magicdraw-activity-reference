package com.acme.magicdraw.activity.ui.view;

import com.acme.magicdraw.activity.ui.query.CallerActivitiesQueryResult;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.browser.Browser;
import com.nomagic.magicdraw.ui.browser.SearchResultsTree;

public class ReferencedActivitiesView {

	public void display(CallerActivitiesQueryResult queryResult) {

		Browser browser = Application.getInstance()
		                             .getMainFrame()
		                             .getBrowser();

		if (browser != null) {
			SearchResultsTree searchResultTree = browser.getSearchResultsTree(true);

			if (searchResultTree != null) {
				searchResultTree.clearSearchResults();
				searchResultTree.addFoundElements(queryResult.asElements());
			}
		}
	}

}
