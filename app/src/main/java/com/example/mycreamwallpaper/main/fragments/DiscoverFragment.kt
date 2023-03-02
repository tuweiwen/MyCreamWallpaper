package com.example.mycreamwallpaper.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.mycreamwallpaper.R
import com.example.mycreamwallpaper.adapters.DiscoverRvAdapter
import com.example.mycreamwallpaper.utils.LinearLayoutManagerWithScrollTop
import com.google.android.material.tabs.TabLayout


// Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DiscoverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DiscoverFragment : Fragment() {
    // Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discover, container, false)
    }

    override fun onStart() {
        super.onStart()

        val recyclerView: RecyclerView = requireView().findViewById(R.id.frag_discover_rv)
        val swipeRefreshLayout: SwipeRefreshLayout = requireView().findViewById(R.id.frag_discover_swipeRefresh)
        val tabLayout: TabLayout = requireView().findViewById(R.id.frag_discover_tab)

        recyclerView.adapter = DiscoverRvAdapter()
        recyclerView.layoutManager = LinearLayoutManagerWithScrollTop(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.setOnScrollChangeListener { _, _, _, _, _ ->
            val firstPosition = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            if (firstPosition % 2 == 0) {
                tabLayout.setScrollPosition((firstPosition / 2), 0F, true)
            }
        }

        swipeRefreshLayout.setOnRefreshListener {
            if (swipeRefreshLayout.isRefreshing) {
                swipeRefreshLayout.isRefreshing = false
            }
        }

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                recyclerView.smoothScrollToPosition(tab?.position?.times(2) ?: 0)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DiscoverFragment.
         */
        // Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DiscoverFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}