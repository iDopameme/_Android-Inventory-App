package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeListViewModel: ShoeListViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        //Get the viewmodel
        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        // set the viewmodel for databinding, allows the bound layout access to all of the data
        // in the viewModel
        binding.shoeListViewModel = shoeListViewModel

        // Specify the current activity as the lifecycle owner of the binding. This is used so that
        // the binding can observe LiveData updates
        binding.lifecycleOwner = this

        binding.shoe = Shoe("", "", "", "")

        val saveButtonObserver = Observer<Boolean> {
            if (shoeListViewModel.navigateToListingScreen.value == true)
                findNavController().navigate(ShoeDetailFragmentDirections.detailToList())

            Timber.i("Detail Observer called")
        }

        shoeListViewModel.navigateToListingScreen.observe(viewLifecycleOwner, saveButtonObserver)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancelShoeChanges.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.detailToList())
            Timber.i("Cancel shoe click Listener called")
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)

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
                findNavController().navigate(ShoeDetailFragmentDirections.shoeDetailLOGOUT())
                true
            }
            R.id.search -> {
                findNavController().popBackStack()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

}