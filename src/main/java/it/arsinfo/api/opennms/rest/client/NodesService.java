package it.arsinfo.api.opennms.rest.client;

import javax.ws.rs.core.MultivaluedMap;

import org.opennms.netmgt.model.OnmsAssetRecord;
import org.opennms.netmgt.model.OnmsCategory;
import org.opennms.netmgt.model.OnmsCategoryCollection;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsIpInterfaceList;
import org.opennms.netmgt.model.OnmsMonitoredService;
import org.opennms.netmgt.model.OnmsMonitoredServiceList;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.OnmsNodeList;
import org.opennms.netmgt.model.OnmsSnmpInterface;
import org.opennms.netmgt.model.OnmsSnmpInterfaceList;


public interface NodesService extends RestFilterService {


    OnmsNodeList getAll();

    OnmsNodeList getWithDefaultsQueryParams();

    OnmsNodeList find(MultivaluedMap<String, String> queryParams);

    OnmsNode get(Integer id);
    
    OnmsIpInterfaceList getIpInterfaces(Integer id);

    OnmsIpInterface getIpInterface(Integer id, String ipaddress);

    OnmsSnmpInterfaceList  getSnmpInterfaces(Integer id);
    
    OnmsSnmpInterface getSnmpInterface(Integer id,Integer ifindex);

    OnmsAssetRecord getAssetRecord(Integer id);
    
    OnmsCategoryCollection getCategories(Integer id);
    
    OnmsCategory getCategory(Integer id, String category);
    
    OnmsMonitoredServiceList getMonitoredServices(Integer id, String ipaddress);
    
    OnmsMonitoredService getMonitoredService(Integer id, String ipaddress,String serviceName);

}
