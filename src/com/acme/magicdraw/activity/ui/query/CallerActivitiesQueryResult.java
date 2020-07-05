package com.acme.magicdraw.activity.ui.query;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.nomagic.uml2.ext.magicdraw.activities.mdfundamentalactivities.Activity;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

public class CallerActivitiesQueryResult {

	private final Map<String, Set<Activity>> activityMap;

	public CallerActivitiesQueryResult(Map<String, Set<Activity>> activityMap) {
		this.activityMap = activityMap;
	}

	public List<Element> asElements() {
		Collection<Set<Activity>> foundActivities = activityMap.values();

		return foundActivities.stream()
		                      .flatMap(Set::stream)
		                      .collect(Collectors.toList());
	}

}
