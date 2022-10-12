package ni.edu.uca.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ni.edu.uca.myapplication.databinding.FragmentTablaBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Tabla.newInstance] factory method to
 * create an instance of this fragment.
 */
class Tabla : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fbinding: FragmentTablaBinding

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
        fbinding = FragmentTablaBinding.inflate(layoutInflater)
        inciar()
        return fbinding.root
    }

    private fun inciar() {
        fbinding.btnTabla.setOnClickListener {
            obtenerTabla()
        }
        fbinding.btnLimpiarTabla.setOnClickListener{
            limpiar()
        }
    }

    private fun limpiar() {
        with(fbinding){
            tvTabla.setText("")
            etNumber.setText("")
        }
    }

    private fun obtenerTabla() {
        var msn = ""
        try {
            val num = fbinding.etNumber.text.toString().toInt()

            var contador = 1
            while (contador <= 12) {
                msn += "${num} * ${contador} = ${num * contador} \n"
                contador += 1
            }
            fbinding.tvTabla.setText(msn)
        } catch (ex: Exception) {
            Toast.makeText(
                activity, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Tabla.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tabla().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}