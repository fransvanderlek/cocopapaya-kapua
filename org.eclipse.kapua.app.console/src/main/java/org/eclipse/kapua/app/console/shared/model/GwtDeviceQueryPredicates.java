/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.kapua.app.console.shared.model;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GwtDeviceQueryPredicates extends KapuaBaseModel implements Serializable {

    private static final long serialVersionUID = 2649696808210585054L;

    public enum GwtDeviceStatus implements IsSerializable {
        ENABLED, DISABLED, ANY;
        GwtDeviceStatus() {
        };
    }

    public enum GwtDeviceCertificateStatus implements IsSerializable {
        ANY, NOT_INSTALLED, INSTALLED_OUT_OF_DATE, INSTALLED_UP_TO_DATE;
        GwtDeviceCertificateStatus() {
        };
    }

    public enum GwtDeviceConnectionStatus implements IsSerializable {
        CONNECTED, DISCONNECTED, MISSING, ANY;
        GwtDeviceConnectionStatus() {
        };
    }

    public enum GwtSortOrder implements IsSerializable {
        ASCENDING, DESCENDING;
        GwtSortOrder() {
        }
    }

    public enum GwtSortAttribute implements IsSerializable {
        CLIENT_ID, DISPLAY_NAME, LAST_EVENT_ON;
        GwtSortAttribute() {
        }
    }

    public GwtDeviceQueryPredicates() {
        setSortAttribute(GwtSortAttribute.CLIENT_ID.name());
        setSortOrder(GwtSortOrder.ASCENDING.name());
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    public <X> X get(String property) {
        if ("deviceStatusEnum".equals(property)) {
            return (X) (GwtDeviceStatus.valueOf(getDeviceStatus()));
        } else if ("deviceConnectionStatusEnum".equals(property)) {
            return (X) (GwtDeviceConnectionStatus.valueOf(getDeviceConnectionStatus()));
        } else if ("deviceCertificateStatusEnum".equals(property)) {
            return (X) (GwtDeviceCertificateStatus.valueOf(getDeviceCertificateStatus()));
        } else if ("sortOrderEnum".equals(property)) {
            return (X) (GwtSortOrder.valueOf(getSortOrder()));
        } else if ("sortAttributeEnum".equals(property)) {
            return (X) (GwtSortAttribute.valueOf(getSortAttribute()));
        } else {
            return super.get(property);
        }
    }

    public Long getTag() {
        return (Long) get("tag");
    }

    public void setTag(Long gwtTag) {
        set("tag", gwtTag);
    }

    public String getClientId() {
        return (String) get("clientId");
    }

    public String getUnescapedClientId() {
        return (String) getUnescaped("clientId");
    }

    public void setClientId(String clientId) {
        set("clientId", clientId);
    }

    public String getDisplayName() {
        return (String) get("displayName");
    }

    public String getUnescapedDisplayName() {
        return (String) getUnescaped("displayName");
    }

    public void setDisplayName(String displayName) {
        set("displayName", displayName);
    }

    public String getSerialNumber() {
        return (String) get("serialNumber");
    }

    public String getUnescapedSerialNumber() {
        return (String) getUnescaped("serialNumber");
    }

    public void setSerialNumber(String serialNumber) {
        set("serialNumber", serialNumber);
    }

    public String getDeviceStatus() {
        return (String) get("deviceStatus");
    }

    public GwtDeviceStatus getDeviceStatusEnum() {
        return get("deviceStatusEnum");
    }

    public void setDeviceStatus(String deviceStatus) {
        set("deviceStatus", deviceStatus);
    }

    public String getDeviceConnectionStatus() {
        return (String) get("deviceConnectionStatus");
    }

    public GwtDeviceConnectionStatus getDeviceConnectionStatusEnum() {
        return get("deviceConnectionStatusEnum");
    }

    public void setDeviceConnectionStatus(String deviceConnectionStatus) {
        set("deviceConnectionStatus", deviceConnectionStatus);
    }

    public String getEsfVersion() {
        return (String) get("esfVersion");
    }

    public String getUnescapedEsfVersion() {
        return (String) getUnescaped("esfVersion");
    }

    public void setEsfVersion(String esfVersion) {
        set("esfVersion", esfVersion);
    }

    public String getApplicationIdentifiers() {
        return (String) get("applicationIdentifiers");
    }

    public String getUnescapedApplicationIdentifiers() {
        return (String) getUnescaped("applicationIdentifiers");
    }

    public void setApplicationIdentifiers(String applicationIdentifiers) {
        set("applicationIdentifiers", applicationIdentifiers);
    }

    public String getImei() {
        return (String) get("imei");
    }

    public void setImei(String imei) {
        set("imei", imei);
    }

    public String getImsi() {
        return (String) get("imsi");
    }

    public void setImsi(String imsi) {
        set("imsi", imsi);
    }

    public String getIccid() {
        return (String) get("iccid");
    }

    public void setIccid(String iccid) {
        set("iccid", iccid);
    }

    public String getCustomAttribute1() {
        return (String) get("customAttribute1");
    }

    public String getUnescapedCustomAttribute1() {
        return (String) getUnescaped("customAttribute1");
    }

    public void setCustomAttribute1(String customAttribute1) {
        set("customAttribute1", customAttribute1);
    }

    public String getCustomAttribute2() {
        return (String) get("customAttribute2");
    }

    public String getUnescapedCustomAttribute2() {
        return (String) getUnescaped("customAttribute2");
    }

    public void setCustomAttribute2(String customAttribute2) {
        set("customAttribute2", customAttribute2);
    }

    public String getDeviceCertificateStatus() {
        return get("deviceCertificateStatus");
    }

    public GwtDeviceCertificateStatus getDeviceCertificateStatusEnum() {
        return get("deviceCertificateStatusEnum");
    }

    public void setDeviceCertificateStatus(String deviceCertificateStatus) {
        set("deviceCertificateStatus", deviceCertificateStatus);
    }

    public Long getSignedCertificateId() {
        return (Long) get("signedCertificateId");
    }

    public void setSignedCertificateId(Long signedCertificateId) {
        set("signedCertificateId", signedCertificateId);
    }

    public String getSortOrder() {
        return (String) get("sortOrder");
    }

    public GwtSortOrder getSortOrderEnum() {
        return get("sortOrderEnum");
    }

    public void setSortOrder(String sortOrder) {
        set("sortOrder", sortOrder);
    }

    public String getSortAttribute() {
        return (String) get("sortAttribute");
    }

    public GwtSortAttribute getSortAttributeEnum() {
        return get("sortAttributeEnum");
    }

    public void setSortAttribute(String sortAttribute) {
        set("sortAttribute", sortAttribute);
    }

    public Long getDefaultPki() {
        return get("defaultPki");
    }

    public void setDefaultPki(Long value) {
        set("defaultPki", value);
    }

}
