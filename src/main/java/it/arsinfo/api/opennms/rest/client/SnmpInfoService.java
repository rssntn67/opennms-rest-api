package it.arsinfo.api.opennms.rest.client;

import org.opennms.web.svclayer.model.SnmpInfo;

public interface SnmpInfoService extends RestFilterService{


    SnmpInfo get(String ip);
    
    void set(String ip, SnmpInfo snmpInfo);

}
