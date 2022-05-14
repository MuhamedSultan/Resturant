package com.example.register

import SweatsAdapter
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
 * Use the [SweatsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SweatsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_sweats, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SweatsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SweatsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var Sweatsname: Array<String> = arrayOf(
            "Molton cake",
            "Ice cream",
            "Waffle",
            "Cake",
            "White chocolate",
            "Donuts ",
            "cheesecake"
        )
        var Sweatsprice: Array<String> =
            arrayOf("25 EGP", "15 EGP", "30 EGP", "25 EGP", "40 EGP", "30 EGP", "35 EGP")
        var Sweatsimg: Array<Int> = arrayOf(
            R.drawable.desert1,
            R.drawable.desert2,
            R.drawable.desert3,
            R.drawable.desert4,
            R.drawable.desert5,
            R.drawable.desert6,
            R.drawable.desert7
        )
        var adapter = SweatsAdapter(Sweatsname, Sweatsprice, Sweatsimg)
        var recycler = view.findViewById<RecyclerView>(R.id.recyclersweats)
        recycler.adapter = adapter
        var manger = GridLayoutManager(activity, 1)
        recycler.layoutManager = manger
    }
}
