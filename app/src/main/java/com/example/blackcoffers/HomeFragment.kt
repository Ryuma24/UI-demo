package com.example.blackcoffers

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.blackcoffers.databinding.FragmentHomeBinding
import com.google.android.material.navigation.NavigationBarView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var thumbView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =
            FragmentHomeBinding.inflate(inflater, container, false)

        val feelings = resources.getStringArray(R.array.menu)
        val arrayAdapter = getContext()?.let {
            ArrayAdapter(
                it,
                R.layout.drop_down,
                feelings
            )
        }
        binding.autoComplete.setAdapter(arrayAdapter)


        thumbView = LayoutInflater.from(getContext())
            .inflate(R.layout.seekbar_thumb, null, false)


        //for seekbar
        binding.seekBar.thumb = getThumb(0)
        binding.seekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                b: Boolean
            ) {
                seekBar.thumb = getThumb(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.saveExplore.setOnClickListener {
//            val secondFragment = ExploreFragment()
//            val transaction = requireActivity().supportFragmentManager
//                .beginTransaction()
//            transaction.replace(
//                R.id.nav_host_fragment,
//                secondFragment
//            )
//            transaction.commit()
            val intent = Intent (getActivity(), TabActivity::class.java)
            getActivity()?.startActivity(intent)
        }





        //button layout changes
        var c1=0
        binding.coffee.setOnClickListener {
            c1 += 1
            if(c1%2!=0){
                binding.coffee.setTextColor(Color.WHITE)
                binding.coffee.setBackgroundColor(Color.BLUE)
            }else{
                binding.coffee.setTextColor(Color.BLACK)
                binding.coffee.setBackgroundColor(Color.WHITE)
            }
            if(c1==4){
                c1=0
            }
        }
        var c2=0
        binding.business.setOnClickListener {
            c2 += 1
            if(c2%2!=0){
                binding.business.setTextColor(Color.WHITE)
                binding.business.setBackgroundColor(Color.BLUE)
            }else{
                binding.business.setTextColor(Color.BLACK)
                binding.business.setBackgroundColor(Color.WHITE)
            }
            if(c2==4){
                c2=0
            }
        }
        var c3=0
        binding.hobbies.setOnClickListener {
            c3 += 1
            if(c3%2!=0){
                binding.hobbies.setTextColor(Color.WHITE)
                binding.hobbies.setBackgroundColor(Color.BLUE)
            }else{
                binding.hobbies.setTextColor(Color.BLACK)
                binding.hobbies.setBackgroundColor(Color.WHITE)
            }
            if(c3==4){
                c3=0
            }
        }
        var c4=0
        binding.friendship.setOnClickListener {
            c4 += 1
            if(c4%2!=0){
                binding.friendship.setTextColor(Color.WHITE)
                binding.friendship.setBackgroundColor(Color.BLUE)
            }else{
                binding.friendship.setTextColor(Color.BLACK)
                binding.friendship.setBackgroundColor(Color.WHITE)
            }
            if(c4==4){
                c4=0
            }
        }
        var c5=0
        binding.movies.setOnClickListener {
            c5 += 1
            if(c5%2!=0){
                binding.movies.setTextColor(Color.WHITE)
                binding.movies.setBackgroundColor(Color.BLUE)
            }else{
                binding.movies.setTextColor(Color.BLACK)
                binding.movies.setBackgroundColor(Color.WHITE)
            }
            if(c5==4){
                c5=0
            }
        }
        var c6=0
        binding.dinning.setOnClickListener {
            c6 += 1
            if(c6%2!=0){
                binding.dinning.setTextColor(Color.WHITE)
                binding.dinning.setBackgroundColor(Color.BLUE)
            }else{
                binding.dinning.setTextColor(Color.BLACK)
                binding.dinning.setBackgroundColor(Color.WHITE)
            }
            if(c6==4){
                c6=0
            }
        }
        var c7=0
        binding.dating.setOnClickListener {
            c7 += 1
            if(c7%2!=0){
                binding.dating.setTextColor(Color.WHITE)
                binding.dating.setBackgroundColor(Color.BLUE)
            }else{
                binding.dating.setTextColor(Color.BLACK)
                binding.dating.setBackgroundColor(Color.WHITE)
            }

            if(c7==4){
                c7=0
            }
        }
        var c8=0
        binding.matrimony.setOnClickListener {
            c8 += 1
            if(c8%2!=0){
                binding.matrimony.setTextColor(Color.WHITE)
                binding.matrimony.setBackgroundColor(Color.BLUE)
            }else{
                binding.matrimony.setTextColor(Color.BLACK)
                binding.matrimony.setBackgroundColor(Color.WHITE)
            }
            if(c8==4){
                c8=0
            }
        }




        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun getThumb(progress: Int): Drawable? {
        (thumbView.findViewById(R.id.tvProgress) as TextView).text=progress.toString() + ""
        thumbView.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
        val bitMap= Bitmap.createBitmap(thumbView.measuredWidth,thumbView.measuredHeight,
            Bitmap.Config.ARGB_8888)
        val canvas= Canvas(bitMap)
        thumbView.layout(0,0,thumbView.measuredWidth,thumbView.measuredHeight)
        thumbView.draw(canvas)
        return BitmapDrawable(resources,bitMap)
    }




}