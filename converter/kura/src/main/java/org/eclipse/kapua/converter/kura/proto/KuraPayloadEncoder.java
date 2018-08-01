/*******************************************************************************
 * Copyright (c) 2018 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.converter.kura.proto;

import java.io.IOException;
import java.util.Map;

import org.eclipse.kapua.converter.kura.KuraPayload;
import org.eclipse.kapua.converter.kura.KuraPosition;
import org.eclipse.kapua.converter.kura.proto.KuraPayloadProto.KuraPayload.KuraMetric;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;

public class KuraPayloadEncoder {

    private static final Logger logger = LoggerFactory.getLogger(KuraPayloadEncoder.class);

    private final KuraPayload kuraPayload;

    public KuraPayloadEncoder(KuraPayload kuraPayload) {
        this.kuraPayload = kuraPayload;
    }

    /**
     * Conversion method to serialize an KuraPayload instance into a byte array.
     * 
     * @return
     */
    public byte[] getBytes() throws IOException {
        // Build the message
        KuraPayloadProto.KuraPayload.Builder protoMsg = KuraPayloadProto.KuraPayload.newBuilder();

        // set the timestamp
        if (this.kuraPayload.getTimestamp() != null) {
            protoMsg.setTimestamp(this.kuraPayload.getTimestamp().getTime());
        }

        // set the position
        if (this.kuraPayload.getPosition() != null) {
            protoMsg.setPosition(buildPositionProtoBuf());
        }

        // set the metrics
        for (final Map.Entry<String, Object> entry : this.kuraPayload.metrics().entrySet()) {
            final String name = entry.getKey();
            final Object value = entry.getValue();

            // build a metric
            try {
                KuraMetric.Builder metricB = KuraMetric.newBuilder();
                metricB.setName(name);

                boolean result = setProtoKuraMetricValue(metricB, value);
                if (result) {
                    // add it to the message
                    protoMsg.addMetric(metricB);
                }
            } catch (KuraInvalidMetricTypeException e) {
                logger.error("During serialization, ignoring metric named: {}. Unrecognized value type: {}.", name,
                        value != null ? value.getClass().getName() : "<null>");
                throw new RuntimeException(e);
            }
        }

        // set the body
        if (this.kuraPayload.getBody() != null) {
            protoMsg.setBody(ByteString.copyFrom(this.kuraPayload.getBody()));
        }

        return protoMsg.build().toByteArray();
    }

    //
    // Helper methods to convert the KuraMetrics
    //
    private KuraPayloadProto.KuraPayload.KuraPosition buildPositionProtoBuf() {
        KuraPayloadProto.KuraPayload.KuraPosition.Builder protoPos = KuraPayloadProto.KuraPayload.KuraPosition
                .newBuilder();

        KuraPosition position = this.kuraPayload.getPosition();
        if (position.getLatitude() != null) {
            protoPos.setLatitude(position.getLatitude());
        }
        if (position.getLongitude() != null) {
            protoPos.setLongitude(position.getLongitude());
        }
        if (position.getAltitude() != null) {
            protoPos.setAltitude(position.getAltitude());
        }
        if (position.getPrecision() != null) {
            protoPos.setPrecision(position.getPrecision());
        }
        if (position.getHeading() != null) {
            protoPos.setHeading(position.getHeading());
        }
        if (position.getSpeed() != null) {
            protoPos.setSpeed(position.getSpeed());
        }
        if (position.getTimestamp() != null) {
            protoPos.setTimestamp(position.getTimestamp().getTime());
        }
        if (position.getSatellites() != null) {
            protoPos.setSatellites(position.getSatellites());
        }
        if (position.getStatus() != null) {
            protoPos.setStatus(position.getStatus());
        }
        return protoPos.build();
    }

    private static boolean setProtoKuraMetricValue(KuraPayloadProto.KuraPayload.KuraMetric.Builder metric, Object o)
            throws KuraInvalidMetricTypeException {

        if (o instanceof String) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.STRING);
            metric.setStringValue((String) o);
        } else if (o instanceof Double) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.DOUBLE);
            metric.setDoubleValue((Double) o);
        } else if (o instanceof Integer) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.INT32);
            metric.setIntValue((Integer) o);
        } else if (o instanceof Float) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.FLOAT);
            metric.setFloatValue((Float) o);
        } else if (o instanceof Long) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.INT64);
            metric.setLongValue((Long) o);
        } else if (o instanceof Boolean) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.BOOL);
            metric.setBoolValue((Boolean) o);
        } else if (o instanceof byte[]) {
            metric.setType(KuraPayloadProto.KuraPayload.KuraMetric.ValueType.BYTES);
            metric.setBytesValue(ByteString.copyFrom((byte[]) o));
        } else if (o == null) {
            logger.warn("Received a metric with a null value!");
            return false;
        } else {
            throw new KuraInvalidMetricTypeException(o.getClass().getName());
        }
        return true;
    }
}