package com.base

import io.reactivex.Flowable
import io.reactivex.Single

/**
 * FilePersistence to save Deserialize encrypted data for later use.
 */
interface PersistenceStore {
    /**
     * Delete the Persistence Stored Data
     *
     * @param id the identifier to identify the Data
     * @return Returns a Boolean Status through RxJava Single to let Consumer Know Weather we were able to delete the Data or Not.
     */
    fun delete(id: String): Single<Boolean>

    /**
     * Clear All Persistence Stored Data Saved Ever
     *
     * @return Returns a Boolean Status through RxJava Single to let Consumer Know Weather we were able to clear the Data or Not.
     */
    fun clearAll(): Single<Boolean>

    /**
     * Save Data to PersistenceStore for Later Use, Data will be Encrypted So No need to Worry
     *
     * @param id the identifier to identify the Data
     * @param obj the serialized object to Save Which Should be Implementing #Persistable Interface
     * @return Returns a Boolean Status through RxJava Single to let Consumer Know Weather we were able to save the Data or Not.
     */
    fun put(id: String, obj: Persistable): Single<Boolean>

    /**
     * Save Data to PersistenceStore for Later Use, Data will be Encrypted So No need to Worry
     *
     * @param id the identifier to identify the Data
     * @param obj list of serialized object to Save Which Should be Implementing #Persistable Interface
     * @return Returns a Boolean Status through RxJava Single to let Consumer Know Weather we were able to save the Data or Not.
     */
    fun putArray(id: String, obj: Array<Persistable>): Single<Boolean>

    /**
     * Get the Saved Data From this Method, If Data is Not Stored the the result will be null
     *
     * @param T the Type of Data Object Which Should be Implementing #Persistable Interface
     * @param id the identifier to identify the Data
     * @param type the ClassType of Data Object Which Should be Implementing #Persistable Interface
     * @return RxJava Single to Adapt the Data In asynchronous way
     */
    fun <T : Persistable> get(id: String, type: Class<T>): Single<T?>

    /**
     * Get the Saved Data Array From this Method, If Data is Not Stored the the result will be null
     *
     * @param T the Type of Data Object Which Should be Implementing #Persistable Interface
     * @param id the identifier to identify the Data
     * @param type the ClassType of Data Object Which Should be Implementing #Persistable Interface
     * @return RxJava Single to Adapt the Data In asynchronous way
     */
    fun <T> getArray(id: String, type: Class<T>): Single<T?>

    /**
     * Get the Saved Data And then Remove it From Persistence Store from Method, If Data is Not Stored the the result will be null
     *
     * @param T the Type of Data Object Which Should be Implementing #Persistable Interface
     * @param id the identifier to identify the Data
     * @param type the ClassType of Data Object Which Should be Implementing #Persistable Interface
     * @return @return RxJava Flowable to Adapt the Data In asynchronous way
     */
    fun <T : Persistable> getAndRemove(id: String, type: Class<T>): Flowable<Any?>

    /**
     * Checks whether the persistence contains a Value.
     *
     * @param id the identifier to identify the Data in persistence Store
     * @return Returns true if the preference exists in the persistence,
     *         otherwise false.
     */
    fun contains(id: String): Boolean
}