package org.openmrs.module.amrsreports.service;

import org.openmrs.Cohort;
import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.module.amrsreports.MOHFacility;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service for dealing with facilities
 */
public interface MOHFacilityService {

	@Transactional(readOnly = true)
	public List<MOHFacility> getAllFacilities();

	@Transactional(readOnly = true)
	public List<MOHFacility> getAllFacilities(Boolean includeRetired);

	@Transactional(readOnly = true)
	public MOHFacility getFacility(Integer facilityId);

	@Transactional
	public MOHFacility saveFacility(MOHFacility facility);

	@Transactional(readOnly = true)
	public Set<Location> getUnallocatedLocations();

	@Transactional(readOnly = true)
	public Set<Location> getAllocatedLocations();

	@Transactional
	public void retireFacility(MOHFacility facility, String retireReason);

	@Transactional
	public void purgeFacility(MOHFacility facility);

	@Transactional
	public Map<Integer,PatientIdentifier> getCCCNumberMapForFacility(MOHFacility facility);

	@Transactional
	public Map<Integer,Integer> getFacilityIdToLatestSerialNumberMap();

	@Transactional
	public Integer countPatientsInFacilityMissingCCCNumbers(MOHFacility facility);

	@Transactional
	public Integer assignMissingIdentifiersForFacility(MOHFacility facility);

	@Transactional
	public Cohort getPatientsInFacilityMissingCCCNumbers(MOHFacility facility);

	@Transactional
	public Integer getLatestSerialNumberForFacility(MOHFacility facility);

	@Transactional
	public MOHFacility getFacilityByUuid(String uuid);
}
