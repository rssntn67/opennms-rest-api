package it.arsinfo.api.opennms.rest.client;

import it.arsinfo.api.opennms.rest.client.model.OnmsAlarmCollection;

public interface AlarmService {

	OnmsAlarmCollection findAll();
}
