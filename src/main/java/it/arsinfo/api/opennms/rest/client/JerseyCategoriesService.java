package it.arsinfo.api.opennms.rest.client;

import org.opennms.netmgt.model.OnmsCategory;
import org.opennms.netmgt.model.OnmsCategoryCollection;


public class JerseyCategoriesService extends JerseyAbstractService implements
		CategoriesService {

	private static final String CATEGORY_PATH = "/categories";
	
	
	
	private String buildCategoryPath(String name) {
		return CATEGORY_PATH+"/"+name;
	}
	
	public OnmsCategoryCollection getAll() {
		return getJerseyClient().get(OnmsCategoryCollection.class, CATEGORY_PATH);
	}

	public OnmsCategory getCategory(String name) {
		return getJerseyClient().get(OnmsCategory.class, buildCategoryPath(name));
	}

	public void delete(String name) {
		getJerseyClient().delete(buildCategoryPath(name));
	}

}
