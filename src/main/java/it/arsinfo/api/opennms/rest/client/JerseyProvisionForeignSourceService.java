package it.arsinfo.api.opennms.rest.client;

import org.opennms.netmgt.provision.persist.foreignsource.DetectorCollection;
import org.opennms.netmgt.provision.persist.foreignsource.DetectorWrapper;
import org.opennms.netmgt.provision.persist.foreignsource.ForeignSource;
import org.opennms.netmgt.provision.persist.foreignsource.ForeignSourceCollection;
import org.opennms.netmgt.provision.persist.foreignsource.PolicyCollection;
import org.opennms.netmgt.provision.persist.foreignsource.PolicyWrapper;

public class JerseyProvisionForeignSourceService extends JerseyAbstractService
		implements ProvisionForeignSourceService {

	private static final String FOREIGNSOURCE_PATH = "foreignSources";
	private static final String FOREIGNSOURCE_COUNT_PATH = "foreignSources/count";
	private static final String FOREIGNSOURCE_DEFAULT_PATH = "foreignSources/default";
	private static final String FOREIGNSOURCE_DEPLOYED_PATH = "foreignSources/deployed";
	private static final String FOREIGNSOURCE_DEPLOYED_COUNT_PATH = "foreignSources/deployed/count";
	private static final String FOREIGNSOURCE_DETECTOR_PATH = "/detectors";
	private static final String FOREIGNSOURCE_POLICY_PATH = "/policies";
	
	private String buildForeignSourcePath(String name) {
		return FOREIGNSOURCE_PATH+"/"+name;
	}
	
	private String buildForeignSourceDetectorsPath(String name) {
		return buildForeignSourcePath(name)+FOREIGNSOURCE_DETECTOR_PATH;
	}

	private String buildForeignSourceDetectorPath(String name, String detectorname) {
		return buildForeignSourceDetectorsPath(name)+"/"+detectorname;
	}
	
	private String buildForeignSourcePoliciesPath(String name) {
		return buildForeignSourcePath(name)+FOREIGNSOURCE_POLICY_PATH;
	}
	
	private String buildForeignSourcePolicyPath(String name, String policyname) {
		return buildForeignSourcePoliciesPath(name)+"/"+policyname;
	}
	
	

	public ForeignSourceCollection getAll() {
		return getJerseyClient().get(ForeignSourceCollection.class, FOREIGNSOURCE_PATH);
	}

	public int count() {
		return Integer.getInteger(getJerseyClient().get(FOREIGNSOURCE_COUNT_PATH));
	}

	public ForeignSourceCollection getAllDefault() {
		return getJerseyClient().get(ForeignSourceCollection.class, FOREIGNSOURCE_DEFAULT_PATH);
	}

	public ForeignSourceCollection getAllDeployed() {
		return getJerseyClient().get(ForeignSourceCollection.class, FOREIGNSOURCE_DEPLOYED_PATH);
	}

	public int countDeployed() {
		return Integer.getInteger(getJerseyClient().get(FOREIGNSOURCE_DEPLOYED_COUNT_PATH));
	}

	public ForeignSource get(String foreignSource) {
		return getJerseyClient().get(ForeignSource.class, FOREIGNSOURCE_DEFAULT_PATH);
	}

	public DetectorCollection getDetectors(String name) {
		return getJerseyClient().get(DetectorCollection.class, buildForeignSourceDetectorsPath(name));
	}

	public DetectorWrapper getDetector(String name, String detectorname) {
		return getJerseyClient().get(DetectorWrapper.class, buildForeignSourceDetectorPath(name, detectorname));
	}

	public PolicyCollection getpolicies(String name) {
		return getJerseyClient().get(PolicyCollection.class, buildForeignSourcePoliciesPath(name));
	}

	public PolicyWrapper getPolicy(String name, String policyname) {
		return getJerseyClient().get(PolicyWrapper.class, buildForeignSourcePolicyPath(name, policyname));
	}

	public void add(ForeignSource foreignSource) {
		getJerseyClient().post(foreignSource, buildForeignSourcePath(foreignSource.getName()));
	}

	public void addOrReplace(String name, DetectorWrapper detector) {
		getJerseyClient().post(detector, buildForeignSourceDetectorsPath(name));
	}

	public void addOrReplace(String name, PolicyWrapper policy) {
		getJerseyClient().post(policy, buildForeignSourcePoliciesPath(name));
	}

	public void deleteForeignSource(String foreignSource) {
		getJerseyClient().delete(buildForeignSourcePath(foreignSource));
	}

	public void deleteDetector(String name, String detectorname) {
		getJerseyClient().delete(buildForeignSourceDetectorPath(name, detectorname));
	}

	public void deletePolicy(String name, String policyname) {
		getJerseyClient().delete(buildForeignSourcePolicyPath(name, policyname));
	}

}
