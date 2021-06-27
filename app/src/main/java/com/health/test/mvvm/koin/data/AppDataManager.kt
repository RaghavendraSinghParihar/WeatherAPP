import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.data.local.prefs.PrefsHelper

/**
 * Raghavendra on 10:14 2018-12-19
 */
class AppDataManager constructor(private val prefsHelper: PrefsHelper) : DataManager {

    override fun getUser(): String? = prefsHelper.getUser()

    override fun saveUser(user: String) = prefsHelper.saveUser(user)
}