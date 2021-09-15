package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import kotlinx.android.synthetic.main.shoe_list_fragment.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

//    val shoeExample1 = ShoeListViewModel("Jordan", 10)
//    val shoeExample2 = ShoeListViewModel("Adidas", 8)
//    val shoeExample3 = ShoeListViewModel("Nike", 7)
//    val shoeExample4 = ShoeListViewModel("Puma", 12)
//    val shoeExample5 = ShoeListViewModel("UA", 11)

    //private var _binding: ShoeListFragmentBinding? = null

    //private val binding get() = _binding!!

    private lateinit var viewModel: ShoeListViewModel

    private lateinit var binding: ShoeListFragmentBinding

    // Called to have the fragment instantiate its user interface view.
    // This is optional, and non-graphical fragments can return null. This will be called between
    // onCreate(Bundle) and onViewCreated(View, Bundle) 
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        binding = ShoeListFragmentBinding.inflate(inflater, container, false)

        //Get the viewmodel
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        // set the viewmodel for databinding, allows the bound layout access to all of the data in
        // the viewModel
        binding.shoeListViewModel = viewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this


        binding.fabShoeList.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.listToDetail())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultObserver = Observer<String> {
            result -> id_shoeView1.text = result.toString()
        }
        viewModel.getShoe().observe(viewLifecycleOwner, resultObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        Timber.i("onPrepareOptions called")
        val itemLogout = menu.findItem(R.id.logout)
        val itemSearch = menu.findItem(R.id.search)

        itemLogout.isVisible = true
        itemSearch.isVisible = true
    }

//    When the user selects one of the app bar items, the system calls your activity's
//    onOptionsItemSelected() callback method, and passes a MenuItem object to indicate which
//    item was clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(ShoeListFragmentDirections.shoeListLOGOUT())
                true
            }
            R.id.search -> {
                // Handle search icon press
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
