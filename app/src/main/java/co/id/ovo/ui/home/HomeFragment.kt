package co.id.ovo.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.id.ovo.R
import co.id.ovo.adapter.AdapterMenuUtama
import co.id.ovo.adapter.AdapterPromo
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.menu_utama.view.*
import kotlin.random.Random

class HomeFragment : Fragment() {

    private val mAdapter by lazy { AdapterMenuUtama() }
    private val mAdapterPromo by lazy { AdapterPromo() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
        }
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val data = mutableListOf<String>()
        val menuUtama = resources.getStringArray(R.array.menu)
        for((x,i) in menuUtama.withIndex()) {
            data.add("$i")
        }

        val androidColors = resources.getIntArray(R.array.colorRandom)
        val randomAndroidColor = mutableListOf<Int>()
        for(i in 1..8) {
            randomAndroidColor.add(androidColors[Random.nextInt(androidColors.size)])
        }
        root.recyclerview_menu_utama.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity,2)
            adapter = mAdapter.also { it.setAdapter(data,data) }
        }

        root.recyclerview_promo.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL,false)
            adapter = mAdapterPromo.also { it.setAdapter(data,randomAndroidColor) }
        }

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        /*inflater.inflate(R.menu.menu,menu)*/
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_keluar){
//            showDialog()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /*private fun showDialog() {
        val alertDialog = AlertDialog.Builder(requireActivity())
        val dialogView = layoutInflater.inflate(R.layout.view_dialog_logout, coordinatorlayout_main, false)
        alertDialog.setView(dialogView)
        alertDialog.setCancelable(true)
        val buttonYes = dialogView.findViewById<Button>(R.id.button_yes)
        val buttonNo = dialogView.findViewById<Button>(R.id.button_no)
        val close = alertDialog.create()
        alertDialog.show()

        buttonYes.setOnClickListener {
            requireActivity().finish()
        }

        buttonNo.setOnClickListener {
            close.dismiss()
        }
    }*/
}
