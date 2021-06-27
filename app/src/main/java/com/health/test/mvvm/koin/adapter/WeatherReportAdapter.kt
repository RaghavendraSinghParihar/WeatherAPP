package com.health.test.mvvm.koin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.health.test.R
import com.health.test.mvvm.koin.model.weather.WeatherReport

class WeatherReportAdapter(context: Context, listItems: ArrayList<WeatherReport>) : RecyclerView.Adapter<WeatherReportAdapter.MyViewHolder?>() {
    private var listItems: ArrayList<WeatherReport>?
    var mContext: Context
    private var clickListener: ItemClickListener? = null
    var viewHolder: MyViewHolder? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item_weather, null)
        viewHolder = MyViewHolder(view)
        return viewHolder as MyViewHolder
    }

    override fun onBindViewHolder(customViewHolder: MyViewHolder, position: Int) {
        val weatherReport: WeatherReport = listItems?.get(position)!!
        val newValue = convertTempKelvinToCelsius(weatherReport.tem!!)
        customViewHolder.txt_temp.setText("Temperature: " + String.format("%.2f", newValue) + "\u2103")
        customViewHolder.txt_humidity.setText("Humidity: " + weatherReport.humidity)
        customViewHolder.txt_weatherStatus.setText("Weather: " + weatherReport.weatherStatus)
        customViewHolder.txt_date_time.setText("Date&Time: " + weatherReport.datetime)
        customViewHolder.txt_temp.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation))
        customViewHolder.clDisplayText.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation))
        Glide.with(mContext)
                .load(R.drawable.ic_baseline_cloud_queue_24)
                .apply(RequestOptions().circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(customViewHolder.ivTitle)
    }

    fun addData(popularSpecialtiyList: ArrayList<WeatherReport>?) {
//        this.listItems.clear();
        listItems = popularSpecialtiyList
    }

    override fun getItemCount(): Int {
        return if (null != listItems) listItems!!.size else 0
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        clickListener = itemClickListener
    }

    // initializes some private fields to be used by RecyclerView.
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val clDisplayText: RelativeLayout
        val txt_temp: TextView
        val txt_humidity: TextView
        val txt_date_time: TextView
        val txt_weatherStatus: TextView
        val ivTitle: ImageView
        override fun onClick(view: View) {
            if (clickListener != null) clickListener?.onClick(view, adapterPosition)
        }

        init {
            txt_temp = itemView.findViewById(R.id.txt_temp)
            txt_humidity = itemView.findViewById(R.id.txt_humidity)
            txt_weatherStatus = itemView.findViewById(R.id.txt_weatherStatus)
            txt_date_time = itemView.findViewById(R.id.txt_date_time)
            ivTitle = itemView.findViewById(R.id.iv_title)
            clDisplayText = itemView.findViewById(R.id.clDisplayText)
            clDisplayText.setOnClickListener(this)
            itemView.tag = itemView
            clDisplayText.setOnClickListener(this)
        }
    }

    init {
        this.listItems = listItems
        mContext = context
    }

    private fun convertTempKelvinToCelsius(temp: Double): Double {
        var tempInCelsius: Double = 0.0
        if (temp > 0)
            tempInCelsius = temp - 273.15
        return tempInCelsius
    }

}
