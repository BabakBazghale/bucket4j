/*
 *
 * Copyright 2015-2019 Vladimir Bukhtoyarov
 *
 *       Licensed under the Apache License, Version 2.0 (the "License");
 *       you may not use this file except in compliance with the License.
 *       You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package io.github.bucket4j.distributed.proxy;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.distributed.AsyncBucket;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * TODO
 *
 * @param <K>
 */
public interface RemoteBucketBuilder<K extends Serializable> {

    /**
     * TODO
     *
     * @param recoveryStrategy
     * @return
     */
    RemoteBucketBuilder<K> withRecoveryStrategy(RecoveryStrategy recoveryStrategy);

    /**
     * TODO
     *
     * @param requestOptimizer
     * @return
     */
    RemoteBucketBuilder<K> withRequestOptimizer(RequestOptimizer requestOptimizer);

    /**
     * TODO
     *
     * @param key
     * @param configuration
     * @return
     */
    Bucket buildProxy(K key, BucketConfiguration configuration);

    /**
     * TODO
     *
     * @param key
     * @param configurationSupplier
     * @return
     */
    Bucket buildProxy(K key, Supplier<BucketConfiguration> configurationSupplier);

    /**
     * TODO
     *
     * @param key
     * @param configuration
     * @return
     */
    AsyncBucket buildAsyncProxy(K key, BucketConfiguration configuration);

    /**
     * TODO
     *
     * @param key
     * @param configurationSupplier
     * @return
     */
    AsyncBucket buildAsyncProxy(K key, Supplier<CompletableFuture<BucketConfiguration>> configurationSupplier);

}