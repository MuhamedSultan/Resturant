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
 * Use the [BurgerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BurgerFragment : Fragment(R.layout.fragment_burger) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        0
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_burger, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BurgerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BurgerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var burgername: Array<String> =
            arrayOf("Classic Burger", "Double Burger", "Chease Burger", "Family Burger")
        var burgerprice: Array<String> = arrayOf("50 EGP", "70 EGP", "80 EGP", "120 EGP")
        var burgerimg: Array<Int> =
            arrayOf(R.drawable.burger1, R.drawable.burger2, R.drawable.burger3, R.drawable.burger4)
        var BurgerAdapter = BurgerAdapter(burgername, burgerprice, burgerimg)
        var recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.adapter = BurgerAdapter
        var manger = GridLayoutManager(activity, 1)
        recyclerview.layoutManager = manger


    }
}

