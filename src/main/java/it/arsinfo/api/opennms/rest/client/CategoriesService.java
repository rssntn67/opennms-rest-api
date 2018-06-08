package it.arsinfo.api.opennms.rest.client;


import org.opennms.netmgt.model.OnmsCategory;
import org.opennms.netmgt.model.OnmsCategoryCollection;

public interface CategoriesService extends RestFilterService{
    
    OnmsCategoryCollection getAll();
    
    OnmsCategory getCategory(String categoryName);
    
    void delete(String categoryName);
}
