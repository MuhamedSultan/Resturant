package com.example.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PastaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PastaFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasta, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PastaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PastaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var PastaName : Array<String> = arrayOf("WhiteSauce Pata","Spagtti Pasta","Chease Pasta","Chicken Pasta")
        var PastaPrice : Array<String> = arrayOf("50 EGP","30 EGP","40 EGP","65 EGP")
        var Pastaimg : Array<Int> = arrayOf(R.drawable.pasta1,R.drawable.pasta2,R.drawable.pasta3,R.drawable.pasta4)
        var adapter = PastaAdapter(PastaName,PastaPrice,Pastaimg)
        var recyclerview = view.findViewById<RecyclerView>(R.id.recyclerviewpasta)
        recyclerview.adapter=adapter
        var manger = GridLayoutManager(activity,1)
        recyclerview.layoutManager=manger
    }

}