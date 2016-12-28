package com.energyhero.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import com.energyhero.domain.Household;
import com.energyhero.service.household.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.energyhero.domain.Measurement;
import com.energyhero.service.measurement.MeasurementService;
import com.energyhero.transfer.CurrentUser;
import com.energyhero.transfer.MeasurementCreateForm;

@Controller
public class MeasurementController {

	private MeasurementService measurementService;
    private HouseholdService householdService;

	@Autowired
	public void setMeasurementService(MeasurementService measurementService, HouseholdService householdService) {
		this.measurementService = measurementService;
        this.householdService = householdService;
	}
	
	@RequestMapping(value = "/measurements", method = RequestMethod.GET)
    public String list(Model model, @AuthenticationPrincipal CurrentUser user){
        model.addAttribute("measurements", measurementService.getAllAvailableMeasurements(user));
        return "measurements";
    }

	@RequestMapping("/measurement/remove/{id}")
    public String remove(@PathVariable Long id, Model model){
		measurementService.deleteMeasurement(id);
        return "redirect:/measurements/";
    }
	
	@RequestMapping("/measurement/new")
    public String newMeasurement(Model model, @AuthenticationPrincipal CurrentUser user){
        MeasurementCreateForm m = new MeasurementCreateForm();
		m.setUserId(user.getId());
        model.addAttribute("measurement", m);

        model.addAttribute("households", householdService.getAllAvailableHouseholds(user));

        return "measurementform";
	}	
	
	@RequestMapping(value = "measurement", method = RequestMethod.POST)
    public String saveMeasurement(@Valid @ModelAttribute(value = "measurement") MeasurementCreateForm measurement, BindingResult bindingResult, Model model, @AuthenticationPrincipal CurrentUser user){
        Date d = measurement.getMeasureTimestamp();
		if (measurement.getMeasureTimestamp() == null) {
        	d = new Date();
        } else {
        	d = measurement.getMeasureTimestamp();
        }
		
		if (bindingResult.hasErrors()) {
            model.addAttribute("households", householdService.getAllAvailableHouseholds(user));
            return "measurementform";
        }

        Measurement m = new Measurement();
        m.setMeasureTimestamp(d);
        m.setConsumer(measurement.getConsumer());
        m.setUnit(measurement.getUnit());
        m.setValue(measurement.getValue());
        Household h = new Household();
        h.setId(measurement.getHouseholdId());
        m.setHousehold(h);
        m.setUserId(measurement.getUserId());

        m = measurementService.saveMeasurement(m);
        return "redirect:/measurements/";
    }
	
}