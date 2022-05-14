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
 * Use the [PizzaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PizzaFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_pizza, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PizzaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PizzaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var pizzaName : Array<String> = arrayOf("Chease Pizza","Bebroni Pizza","Margrita Pizza","Chicken Pizza","Fahita Pizza")
        var pizzaPrice : Array<String> = arrayOf("50 EGP","60 EGP","80 EGP","75 EGP","70 EGP")
        var pizzaimg : Array<Int> = arrayOf(R.drawable.pizza,R.drawable.pizza1,R.drawable.pizza2,R.drawable.pizza3,R.drawable.pizaa4)
        var adapter = PizzaAdapter(pizzaName,pizzaPrice,pizzaimg)
        var recyclerview = view.findViewById<RecyclerView>(R.id.recyclerviewpizza)
        recyclerview.adapter=adapter
        var manger = GridLayoutManager(activity,1)
        recyclerview.layoutManager=manger
    }
}