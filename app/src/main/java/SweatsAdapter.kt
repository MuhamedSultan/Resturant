import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.register.Model
import com.example.register.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SweatsAdapter() : RecyclerView.Adapter<MyViewHolderSweats>() {
    var mref   : DatabaseReference?=null

    private lateinit var Sweatsname: Array<String>
    private lateinit var  Sweatsprice: Array<String>
   private lateinit var Sweatsimg: Array<Int>
    constructor(Sweatsname: Array<String>, Sweatsprice: Array<String>, Sweatsimg: Array<Int>) :this(){
        this.Sweatsname=Sweatsname
        this.Sweatsprice=Sweatsprice
        this.Sweatsimg=Sweatsimg
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderSweats {
        var cv = LayoutInflater.from(parent.context).inflate(R.layout.cardview_layout,parent,false)
        return MyViewHolderSweats(cv)
    }

    override fun onBindViewHolder(holder: MyViewHolderSweats, position: Int) {
        holder.names.setText(Sweatsname[position])
        holder.prices.setText(Sweatsprice[position])
        holder.img.setImageResource(Sweatsimg[position])
        holder.add.setOnClickListener(View.OnClickListener {
            mref = FirebaseDatabase.getInstance().getReference("authentication")
            var name = holder.names.text.toString()
            var price = holder.prices.text.toString()
            var id = mref?.push()!!.key
            var order = Model(id, name, price)
            mref!!.child(id.toString()).setValue(order)
            Toast.makeText(it.context,"Added to Cart Successfully", Toast.LENGTH_SHORT).show()

        })
    }

    override fun getItemCount(): Int {
return Sweatsname.size
    }

}

class MyViewHolderSweats(itemView: View) : RecyclerView.ViewHolder(itemView){
    var names=itemView.findViewById<TextView>(R.id.textView2)
    var prices=itemView.findViewById<TextView>(R.id.textView3)
    var img=itemView.findViewById<ImageView>(R.id.imageView)
    var cv = itemView.findViewById<CardView>(R.id.card)
    var add = itemView.findViewById<Button>(R.id.addtocart)

}
