package com.udacity.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_list_fragment.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var shoeListViewModel: ShoeListViewModel
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
        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        // set the viewmodel for databinding, allows the bound layout access to all of the data in
        // the viewModel
        binding.shoeListViewModel = shoeListViewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        val shoeObserver = Observer<List<Shoe>> { newShoe ->
            Timber.i("List Observer called")
            if (!newShoe.isNullOrEmpty()) {
                newShoe.forEach { shoe ->
                    val textView = TextView(this.context)

                    val content = "Shoe Name: ${shoe.name}" +
                            "\nSize: ${shoe.size} " +
                            "\nCompany: ${shoe.company} " +
                            "\nDescription: ${shoe.description} " +
                            "\n"

                    textView.text = content
                    textView.textSize = 20f

                    binding.shoeLinearLayout.addView(textView)
                }
            }
            //shoeListViewModel.navigateToListingScreen.value = false
        }

        shoeListViewModel.shoe.observe(viewLifecycleOwner, shoeObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Navigates to fragment_shoe_detail after fabShoeList is pressed
        fabShoeList.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.listToDetail())
            shoeListViewModel.navigateToListingScreen.value = false
            Timber.i("fabShoeList click Listener called")
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        Timber.i("onPrepareOptions called")
        val itemLogout = menu.findItem(R.id.logout)
        val itemSearch = menu.findItem(R.id.search)

        // logout & search menu items are now visible upon reaching the Shoe List Fragment
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
