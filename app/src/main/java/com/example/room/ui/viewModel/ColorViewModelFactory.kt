import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.repo.Repo
import com.example.room.ui.viewModel.ColorViewModel

class ColorViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ColorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ColorViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}