package com.health.test.mvvm.koin.ui.beauty

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.base.BR
import com.base.BaseFragment
import com.health.test.R
import com.health.test.databinding.FragmentBeautyTipsBindingImpl
import com.health.test.mvvm.koin.ui.home.HomeActivity
import org.koin.android.viewmodel.ext.android.viewModel

class BeautyFragment : BaseFragment<FragmentBeautyTipsBindingImpl, BeautyViewModel>(),
        BeautyNavigator {
    private val dailyTipsViewModel: BeautyViewModel by viewModel()
    private lateinit var mContext: HomeActivity
    private var recyclerViewShow: RecyclerView? = null
  //  var dbManager: DbManager? = null
    companion object {
        fun newInstance(bundle: Bundle): BeautyFragment {
            val args = Bundle()
            val fragment = BeautyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun getViewModel(): BeautyViewModel = dailyTipsViewModel
    override fun getLayoutId(): Int = R.layout.fragment_beauty_tips
    override fun getBindingVariable(): Int = BR.viewModel
    override fun updateUI(savedInstanceState: Bundle?) {
        dailyTipsViewModel.setNavigator(this)
        setUIData()
    }

    private fun setUIData() {
        mContext.updateToolBarTitle("Test")
       /* DbManager.createInstance(mContext)
        getViewModel().dbManager = DbManager.getInstance()*/
        /* recyclerViewShow = view!!.findViewById<View>(R.id.recyclerViewShow) as RecyclerView
         mContext?.updateToolBarTitle(getString(R.string.health_book))
         recyclerViewShow?.setHasFixedSize(true)
         val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
         recyclerViewShow?.layoutManager = layoutManager*/

    }

/*    private fun showDataInList() {
        try {
            if (eBookDataResponses.size > 0) {
                Collections.sort(eBookDataResponses, SortByDateForHealth())
                Collections.reverse(eBookDataResponses)
                val adapter = EBookListRecyclerAdapter(activity!!, eBookDataResponses)
                recyclerViewShow!!.adapter = adapter
                adapter.setClickListener(this)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, getString(R.string.no_data_found_message), Toast.LENGTH_SHORT).show()
            }
        } catch (ee: Exception) {
            ee.printStackTrace()
        }
    }*/
    override fun hideProgress() {
        mContext.hideProgress()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = (context as HomeActivity)
    }


}
