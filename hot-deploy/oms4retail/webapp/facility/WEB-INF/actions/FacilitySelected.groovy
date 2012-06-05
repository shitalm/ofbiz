import org.ofbiz.base.util.Debug

module = "com.oms4retail.facility";

if(parameters.facilityId != null && !parameters.facilityId.equals("")) {
    Debug.logInfo("We already have facilityId=" + parameters.facilityId + " supplied in parameters", "");
    return "success";
};

facilities = delegator.findList("Facility", null, null, null, null, false);
Debug.logInfo(module +"::facility count =" + facilities.size(), "");

if(parameters.facilityId == null && facilities.size() >= 1) {
    facilityId = facilities.get(0).get("facilityId");
    parameters.facilityId = facilityId;
    Debug.logInfo(module + "::selecting the only facility with facilityId=" + parameters.facilityId, "");
    return "success";
}

return "error";


