package it.arsinfo.api.opennms.rest.client;

import javax.ws.rs.core.MultivaluedMap;

import it.arsinfo.api.opennms.rest.client.model.OnmsAlarmCollection;

public class JerseyAlarmService extends JerseyAbstractService implements AlarmService {

	  private JerseyClientImpl m_jerseyClient;
	  
	  public JerseyAlarmService(JerseyClientImpl jerseyClient) {
		  m_jerseyClient = jerseyClient;
	  }
  
	  private final String ALARMSPATH="alarms";
	
	  @Override
	  public OnmsAlarmCollection findAll() {
		  MultivaluedMap queryAll = setLimit(0);
		  return m_jerseyClient.get(OnmsAlarmCollection.class, ALARMSPATH, queryAll);
	  }

}
