package com.example.blackcoffers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blackcoffers.databinding.FragmentExploreBinding
import com.example.blackcoffers.databinding.FragmentHomeBinding




class ExploreFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<Adapter.ViewHolder>? = null

    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                val transaction = requireActivity().supportFragmentManager
                    .beginTransaction()
                transaction.replace(
                    R.id.nav_host_fragment,
                    HomeFragment()
                )
                transaction.commit()

            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            FragmentExploreBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        layoutManager = LinearLayoutManager(activity)
        // set the custom adapter to the RecyclerView
        adapter = Adapter()


        return binding.root
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        binding.recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = Adapter()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}