class SavedPlacesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var placesAdapter: PlacesAdapter
    private var placesList: MutableList<Place> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_places)

        recyclerView = findViewById(R.id.recycler_view_saved_places)
        recyclerView.layoutManager = LinearLayoutManager(this)

        placesAdapter = PlacesAdapter(placesList, ::onEditClick, ::onDeleteClick)
        recyclerView.adapter = placesAdapter

        findViewById<Button>(R.id.back_to_map_button).setOnClickListener {
            finish()
        }

        loadPlaces()
    }

    private fun loadPlaces() {
    }

    private fun onEditClick(place: Place) {
    }

    private fun onDeleteClick(place: Place) {
    }
}