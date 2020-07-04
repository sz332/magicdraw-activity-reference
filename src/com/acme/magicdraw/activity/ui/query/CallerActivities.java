package com.acme.magicdraw.activity.ui.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.uml.Finder;
import com.nomagic.uml2.ext.magicdraw.actions.mdbasicactions.CallBehaviorAction;
import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;

public class CallerActivities {

	private final Project project;
	private final List<String> targetActivities;

	public CallerActivities(Project project, List<String> targetActivities) {
		this.project = project;
		this.targetActivities = targetActivities;
	}

	// FIXME replace with stream api
	public Map<String, List<Activity>> callerActivities() {

		Map<String, List<Activity>> retValue = new HashMap<>();

		Collection<Activity> allActivities = Finder.byTypeRecursively().find(project, new Class[] { Activity.class });

		// for every activities
		for (Activity activity : allActivities) {

			// for every activity called by that particular activity
			for (Activity calledActivity : findCalledActivities(activity)) {

				String calledActivityId = calledActivity.getID();

				// if the called activity is among the list of targets
				if (targetActivities.contains(calledActivityId)) {

					// 
					if (!retValue.containsKey(calledActivityId)) {
						retValue.put(calledActivityId, new ArrayList<>());
					}

					List<Activity> actList = retValue.get(calledActivityId);

					// if the caller activity was not added yet, add it to the list
					if (!actList.contains(activity)) {
						actList.add(activity);
					}
				}

			}

		}

		return retValue;
	}

	// FIXME replace with stream api
	private List<Activity> findCalledActivities(Activity activity) {
		
		List<Activity> retValue = new ArrayList<>();
		
		Collection<CallBehaviorAction> actions = Finder.byTypeRecursively().find(activity, new Class[] {CallBehaviorAction.class}, false);
		
		for (CallBehaviorAction action : actions) {
			
			if (action.getBehavior() != null && action.getBehavior() instanceof Activity) {
				retValue.add((Activity)action.getBehavior());
			}
		}
		
		return retValue;
	}

}
