package com.test.testproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Model(adaptables = SlingHttpServletRequest.class,
    resourceType = "ugams/components/content/home-about",
    defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson", extensions = "json", selector ="myselector",
options = {
		@ExporterOption(name ="SerializationFeature.WRAP_ROOT_VALUE", value = "true"),
		@ExporterOption(name = "MapperFeature.SORT_PROPERTIES_ALPHABETICALLY", value = "true")
})
@JsonRootName("Properties")
public class HomeAboutModel {

    private static final Logger logger = LoggerFactory.getLogger(HomeAboutModel.class);

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String desc;

    @ValueMapValue
    private String heading;

    @ValueMapValue
    private String buttonTitle;

    @ValueMapValue
    private String img;

    @ValueMapValue
    private String path;
    
    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getHeading() {
        return heading;
    }

    public String getButtonTitle() {
        return buttonTitle;
    }
    
    @JsonIgnore
    public String getImg() {
        return img;
    }

    public String getPath() {
        return path;
    }
    
    @JsonProperty(value = "Content")
    public String noContent() {
    	return "No Content";
    }

}