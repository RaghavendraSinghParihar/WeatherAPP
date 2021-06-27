package com.health.test.mvvm.koin.ui.home

import android.app.AlertDialog
import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.base.BR
import com.base.BaseActivity

import com.google.android.material.navigation.NavigationView
import com.health.test.R
import com.health.test.database.DbManager

import com.health.test.databinding.HomeActivityBinding

import com.health.test.mvvm.koin.ui.beauty.BeautyFragment
import com.health.test.retrofit.ProgressDialogLoader

import com.health.test.utils.Utils
import com.utils.Logger
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class HomeActivity : BaseActivity<HomeActivityBinding, HomeViewModel>(), HomeNavigator, NavigationView.OnNavigationItemSelectedListener {
    private val homeViewModel: HomeViewModel by viewModel()
     private var toolbar: Toolbar? = null
    var title: String? = null
    var counter: Int = 2


    companion object {
        val logger = Logger.getLogger(HomeActivity::class.java)
    }

    override fun getLayoutId(): Int = R.layout.home_activity

    override fun getBindingVariable(): Int = BR._all

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.error("onCreate")
    }

    private fun initUI() {
        DbManager.createInstance(this)
        val dbManager = DbManager.getInstance()
        addXMLToJava()
        loadFragmentToHomeScreen()

    }

    /**
     * replace fragment in container
     *
     * @param fragment
     */
    override fun replaceFragment(fragment: Fragment) {
        val simpleName = fragment::class.java.simpleName
        supportFragmentManager.beginTransaction().replace(R.id.flContent, fragment, simpleName)
                .addToBackStack(simpleName).commitAllowingStateLoss()
    }


    fun showProgress() {
        ProgressDialogLoader.progressDialogCreation(this, getString(R.string.loading))
    }

    fun showProgressCustom(message: String) {
        ProgressDialogLoader.progressDialogCreation(this, message)
    }

    override fun hideProgress() {
        ProgressDialogLoader.progressdialogDismiss()
    }

    override fun updateUI(savedInstanceState: Bundle?) {
        homeViewModel.setNavigator(this)
        toolbar?.let {
            setUpToolBar(it.id, true)
        }
        initUI()
    }

    override fun getViewModel(): HomeViewModel = homeViewModel


    fun showAlertBOX(msg: String) {
        val builder = AlertDialog.Builder(
                this)
        builder.setMessage(msg).setCancelable(false)
                .setPositiveButton(getString(R.string.ok)) { dialog, id ->

                }
        builder.show()
    }

    fun updateToolBarTitle(title: String) {
        toolbar?.let {
            it.title = title
        }
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    private fun addXMLToJava() {

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(R.string.home)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            toolbar?.setNavigationOnClickListener { finish() }
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }


    private fun loadFragmentToHomeScreen() {
        // Loading DailyTips Fragment to home screen
        // At first when user will come to this screen he/she will see DailyTips Screen
        showFragment(BeautyFragment(), null)

    }

    private fun sendEmail() {
        val mailIntent = Intent(Intent.ACTION_VIEW)
        val data = Uri.parse("mailto:?subject=" + "Health App feedback" + "&body=" + " " + "&to=" + "minakshisaini0406@gmail.com")
        mailIntent.data = data
        startActivity(Intent.createChooser(mailIntent, "Send mail..."))
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment: Fragment
        val id = item.itemId
        val args = Bundle()
        if (id == R.id.daily_tips) {
            if (Utils.checkInternetConnection(Objects.requireNonNull(this))) {
                fragment = BeautyFragment()
                showFragment(fragment, null)
            } else {
                Toast.makeText(this, getString(R.string.check_internet), Toast.LENGTH_LONG).show()
            }

        } else if (id == R.id.beauty_tips) {
            if (Utils.checkInternetConnection(Objects.requireNonNull(this))) {
                fragment = BeautyFragment()
                showFragment(fragment, null)
            } else {
                Toast.makeText(this, getString(R.string.check_internet), Toast.LENGTH_LONG).show()
            }
        } else if (id == R.id.yoga_tips) {

        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showFragment(fragment: Fragment, args: Bundle?) {
        val mTransactiont = supportFragmentManager.beginTransaction()
        fragment.arguments = args
        mTransactiont.replace(R.id.flContent, fragment, fragment.javaClass.name)
        mTransactiont.commit()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ebook -> {
                val bundle = Bundle()
                true
            }
            R.id.moreApp -> {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=ShriHari+Apps")))
                true
            }

            else ->                 // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {

        }
    }


}
