package com.test.testproject.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.fasterxml.jackson.annotation.JsonRootName;

@Model(adaptables = Resource.class,
resourceType = "ugams/components/content/timeline",
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		)

@Exporter(name = "jackson", extensions = "json",
options = {
		@ExporterOption(name ="SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
		@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})
@JsonRootName("Properties")
public class TimelineModel {

	@ChildResource
	Resource timeline;

	List<Map<String, String>> timelineItems = new ArrayList<>();

	public List<Map<String, String>> getTimelineItems() {
		if (timeline != null) {
			for (Resource fact : timeline.getChildren()) {
				Map<String, String> itemsMap = new HashMap<>();
				itemsMap.put("title", fact.getValueMap().get("title", String.class));
				itemsMap.put("text1", fact.getValueMap().get("text1", String.class));
				itemsMap.put("text2", fact.getValueMap().get("text2", String.class));
				timelineItems.add(itemsMap);
			}
		}
		return timelineItems;
	}

}
