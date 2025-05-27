package com.example.myselfapp.ui.profile

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myselfapp.R
import com.example.myselfapp.databinding.FragmentProfileBinding
import com.example.myselfapp.utils.BitmapUtils
import com.example.myselfapp.utils.BitmapUtils.drawableToBitmap
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.annotation.annotations
import com.mapbox.maps.plugin.annotation.generated.PointAnnotationOptions
import com.mapbox.maps.plugin.annotation.generated.createPointAnnotationManager

import com.mapbox.maps.plugin.gestures.gestures

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapViewInstance = binding.mapView

        mapViewInstance.getMapboxMap().loadStyleUri(
            Style.MAPBOX_STREETS,
            object : Style.OnStyleLoaded {
                override fun onStyleLoaded(style: Style) {
                    Log.d("ProfileFragmentMap", "Map style loaded successfully.")


                    binding.mapView.gestures.pitchEnabled = true
                    binding.mapView.gestures.scrollEnabled = true
                    binding.mapView.gestures.rotateEnabled = true
                    binding.mapView.gestures.doubleTapToZoomInEnabled = true
                    binding.mapView.gestures.quickZoomEnabled = true

                    val airplaneBitmap = bitmapFromDrawableRes(R.drawable.ic_profile_location_pin)
                    val initialPoint = Point.fromLngLat(107.652503, -6.962118) // Contoh: Bandung
                    val initialCameraOptions = CameraOptions.Builder()
                        .center(initialPoint)
                        .zoom(12.0)
                        .build()
                    binding.mapView.getMapboxMap().setCamera(initialCameraOptions)

                    val annotationApi = binding.mapView.annotations
                    val pointAnnotationManager = annotationApi.createPointAnnotationManager()
                    val pointAnnotationOptions = PointAnnotationOptions()
                        .withPoint(initialPoint)
                        .withIconImage(airplaneBitmap)
                    pointAnnotationManager.create(pointAnnotationOptions)

                    Toast.makeText(requireContext(), "Peta berhasil dimuat!", Toast.LENGTH_SHORT).show()

                }
            },

        )
    }

    fun bitmapFromDrawableRes(@DrawableRes resourceId: Int): Bitmap =
        drawableToBitmap(AppCompatResources.getDrawable(requireContext(), resourceId)!!)

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}