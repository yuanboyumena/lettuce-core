/*
 * Copyright 2017-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.TransactionResult


/**
 * Coroutine executed commands for Transactions.
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 *
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesApi
 */
@ExperimentalLettuceCoroutinesApi
interface RedisTransactionalSuspendableCommands<K, V> {

    /**
     * Discard all commands issued after MULTI.
     *
     * @return String simple-string-reply always {@code OK}.
     */
    suspend fun discard(): String

    /**
     * Execute all commands issued after MULTI.
     *
     * @return List<Object> array-reply each element being the reply to each of the commands in the atomic transaction.
     *
     *         When using {@code WATCH}, {@code EXEC} can return a {@link TransactionResult#wasDiscarded discarded
     *         TransactionResult}.
     * @see TransactionResult#wasDiscarded
     */
    suspend fun exec(): TransactionResult

    /**
     * Mark the start of a transaction block.
     *
     * @return String simple-string-reply always {@code OK}.
     */
    suspend fun multi(): String?

    /**
     * Watch the given keys to determine execution of the MULTI/EXEC block.
     *
     * @param keys the key.
     * @return String simple-string-reply always {@code OK}.
     */
    suspend fun watch(vararg keys: K): String

    /**
     * Forget about all watched keys.
     *
     * @return String simple-string-reply always {@code OK}.
     */
    suspend fun unwatch(): String

}

