package com.base


interface Local {
    /**
     * SecureShaderPreferences Object Responsible for Saving your key-Value Pair Data Securely.
     * Recommended While Saving Small Amount of Data
     *
     * @return the SecureShaderPreferences Object Reference
     */
    fun getSharedPreferences(): SecureSharedPreference

    /**
     * PersistenceStore Object Responsible for Saving your key-Value Pair Data Securely.
     * Recommended While Saving Big Amount of Data
     *
     * @return
     */
    fun getPersistenceStore(): PersistenceStore
}