package com.example.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_layout.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChickenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChickenFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chicken, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChickenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChickenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var ChickenName : Array<String> = arrayOf("single chicken","sheesh chicken","double chicken","Rab chicken","family chicken")
        var ChickenPrice : Array<String> = arrayOf("50 EGP","60 EGP","80 EGP","75 EGP","120 EGP")
        var Chickenimg : Array<Int> = arrayOf(R.drawable.chicken1,R.drawable.chicken2,R.drawable.chicken3,R.drawable.chicken4,R.drawable.chicken5)
        var adapter = ChickenAdapter(ChickenName,ChickenPrice,Chickenimg)
        var recyclerview = view.findViewById<RecyclerView>(R.id.recyclerviewch)
        recyclerview.adapter=adapter
        var manger = GridLayoutManager(activity,1)
        recyclerview.layoutManager=manger

    }
}