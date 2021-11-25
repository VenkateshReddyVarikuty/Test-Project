package com.test.testproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.fasterxml.jackson.annotation.JsonRootName;

@Model(adaptables = Resource.class,
resourceType = "ugams/components/content/testimonial",
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		)

@Exporter(name = "jackson", extensions = "json",
options = {
		@ExporterOption(name ="SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
		@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})
@JsonRootName("Properties")
public class TestimonialModel {
	
	@ValueMapValue
	private String name;
	
	@ValueMapValue
	private String desg;
	
	@ValueMapValue
	private String desc;
	
	public String getName() {
		return name;
	}

	public String getDesg() {
		return desg;
	}

	public String getDesc() {
		return desc;
	}

}
