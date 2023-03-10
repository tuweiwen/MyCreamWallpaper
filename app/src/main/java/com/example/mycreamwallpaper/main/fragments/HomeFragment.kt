package com.example.mycreamwallpaper.main.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mycreamwallpaper.R
import com.example.mycreamwallpaper.activity.SearchActivity
import com.example.mycreamwallpaper.adapters.HomeRvAdapter
import com.example.mycreamwallpaper.bean.Pic
import com.example.mycreamwallpaper.utils.DeviceUtils.Companion.getScreenParam


// Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var picList: ArrayList<Pic>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        picList = arrayListOf()
        picList.let { it ->
            for (i in 0..(10..20).random()) it += Pic()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onStart() {
        super.onStart()

        val recyclerView: RecyclerView = requireView().findViewById(R.id.rv_frag_home)
        val swipeRefreshLayout: SwipeRefreshLayout =
            requireView().findViewById(R.id.swipeRefresh_frag_home)
        val edit: EditText = requireView().findViewById(R.id.search_frag_home)

        recyclerView.adapter = HomeRvAdapter(picList)

//      code below will take bug, need to consider other way to calculate col
//        var col = (getScreenParam(requireContext(),0) / 400) * 2
//        if (col > 4) col = 4
//        recyclerView.layoutManager = StaggeredGridLayoutManager(col, StaggeredGridLayoutManager.VERTICAL)

        Log.d("HomeFragment", "screenParam ${getScreenParam(requireContext(), 0) / 400}")
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        swipeRefreshLayout.setOnRefreshListener {
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false
            }
        }

        edit.setOnClickListener {
            val options = ViewCompat.getTransitionName(edit)?.let { it1 ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), edit, it1)
            }
            startActivity(Intent(context, SearchActivity::class.java), options?.toBundle())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}