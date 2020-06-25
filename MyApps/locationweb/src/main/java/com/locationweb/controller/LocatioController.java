package com.locationweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.entity.Location;
import com.locationweb.service.LocationService;

@Controller
public class LocatioController {

	@Autowired
	private LocationService locationService;

	@RequestMapping("/showCreateLocation")
	public String showCreateLocation() {
		return "createLocation";
	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap) {

		Location savedData = locationService.saveLocation(location);

		String msg = "Successfully created with ID " + savedData.getId();
		modelmap.addAttribute("msg", msg);

		return "createLocation";
	}

	@RequestMapping("/getAllLocations")
	public String getAllLocations(ModelMap modelmap) {

		List<Location> locationlists = locationService.getAllLocations();
		modelmap.addAttribute("locations", locationlists);

		return "displayAllLocations";
	}

	@RequestMapping("/deleteLocation")
	public String deleteLocationById(@RequestParam("locationid") int id, ModelMap modelmap) {

		// Delete location By id

		Location location = new Location();
		location.setId(id);
		locationService.deleteLocation(location);
		
		// Fetch all location and redirect to displayAll page
		List<Location> locationlists = locationService.getAllLocations();
		modelmap.addAttribute("locations", locationlists);
		return "displayAllLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("locationid") int id,ModelMap modelmap) {
		
		Optional<Location> location = locationService.getLocationById(id);
		
		modelmap.addAttribute("location", location.get());
		
		return "editLocation";
		
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap modelmap) {
		
		//Upadet location
		Location updatedData = locationService.saveLocation(location);
		
		if(updatedData !=null) {
			// Fetch all location and redirect to displayAll page
			List<Location> locationlists = locationService.getAllLocations();
			modelmap.addAttribute("locations", locationlists);
			return "displayAllLocations";
		}
		return "editLocation";
		
	}
	
}
