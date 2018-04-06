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
package org.eclipse.kapua.transport.amqpproton.pooling.setting;

import org.eclipse.kapua.commons.setting.SettingKey;

/**
 * Available settings key for MQTT client pool for MQTT transport level
 *
 * @since 1.0.0
 */
public enum AmqpClientPoolSettingKeys implements SettingKey {

    /**
     * The prefix for the id set to the AMQP Client
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_CLIENT_ID_PREFIX("client.pool.client.id.prefix"),

    /**
     * The minimum size for the client pool.
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_SIZE_IDLE_MIN("client.pool.size.idle.min"),

    /**
     * The maximum size for the client pool.
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_SIZE_IDLE_MAX("client.pool.size.idle.max"),

    /**
     * FIXME [javadoc] document property
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_SIZE_TOTAL_MAX("client.pool.size.total.max"),

    /**
     * The max time to wait an available AMQP Client
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_BORROW_WAIT_MAX("client.pool.borrow.wait.max"),

    /**
     * The time interval between each eviction on the client pool
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_EVICTION_INTERVAL("client.pool.eviction.interval"),

    /**
     * FIXME [javadoc] document property
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_WHEN_EXAUSTED_BLOCK("client.pool.when.exhausted.block"),

    /**
     * FIXME [javadoc] document property
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_WHEN_IDLE_TEST("client.pool.when.idle.test"),

    /**
     * Checks client status when borrowing client from the pool.
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_ON_BORROW_TEST("client.pool.on.borrow.test"),

    /**
     * Checks client status when returning client to the pool.
     * 
     * @since 1.0.0
     */
    CLIENT_POOL_ON_RETURN_TEST("client.pool.on.return.test"),
    ;

    /**
     * The key value in the configuration resources.
     * 
     * @since 1.0.0
     */
    private String key;

    /**
     * Set up the {@code enum} with the key value provided
     * 
     * @param key
     *            The value mapped by this {@link Enum} value
     * @since 1.0.0
     */
    private AmqpClientPoolSettingKeys(String key) {
        this.key = key;
    }

    /**
     * Gets the key for this {@link AmqpClientPoolSettingKeys}
     * 
     * @since 1.0.0
     */
    public String key() {
        return key;
    }
}
