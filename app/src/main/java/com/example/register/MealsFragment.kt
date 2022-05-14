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
 * Use the [MealsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MealsFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_meals, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MealsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MealsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var Mealsname : Array<String> = arrayOf("Chicken Meal","Spagtti Meal","Healthy Meal","Family Meal")
        var Mealsprice: Array<String> = arrayOf("50 EGP","45 EGP","70 EGP","90 EGP")
        var Mealsimg : Array<Int> = arrayOf(R.drawable.meal1,R.drawable.meal2,R.drawable.meal3,R.drawable.meal4)
        var adapter = MealsAdapter(Mealsname,Mealsprice,Mealsimg)
        var recycler = view.findViewById<RecyclerView>(R.id.recyclerMeals)
        recycler.adapter=adapter
        var manger = GridLayoutManager(activity,1)
        recycler.layoutManager=manger
    }
}