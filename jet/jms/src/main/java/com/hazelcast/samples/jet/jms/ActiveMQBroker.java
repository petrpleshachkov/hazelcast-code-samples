/*
 * Copyright (c) 2008-2021, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.samples.jet.jms;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.embedded.EmbeddedActiveMQ;

/**
 * Utility class to start/stop an ActiveMQ Broker instance
 */
public final class ActiveMQBroker {

    public static final String BROKER_URL = "tcp://localhost:61616";

    private EmbeddedActiveMQ broker;

    ActiveMQBroker() throws Exception {
        ConfigurationImpl configuration = new ConfigurationImpl();
        configuration.setSecurityEnabled(false);
        configuration.setPersistenceEnabled(false);
        configuration.addAcceptorConfiguration("my-acceptor", BROKER_URL);

        broker = new EmbeddedActiveMQ();
        broker.setConfiguration(configuration);
        broker.start();
    }

    public void stop() throws Exception {
        broker.stop();
    }
}
