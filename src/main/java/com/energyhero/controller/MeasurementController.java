package com.energyhero.controller;

import java.util.Date;

import javax.validation.Valid;

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

	@Autowired
	public void setMeasurementService(MeasurementService measurementService) {
		this.measurementService = measurementService;
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
        return "measurementform";
	}	
	
	@RequestMapping(value = "measurement", method = RequestMethod.POST)
    public String saveMeasurement(@Valid @ModelAttribute(value = "measurement") MeasurementCreateForm measurement, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "measurementform";
        }

        Measurement m = new Measurement();
        m.setMeasureTimestamp(measurement.getMeasureTimestamp());
        m.setConsumer(measurement.getConsumer());
        m.setUnit(measurement.getUnit());
        m.setValue(measurement.getValue());
        m.setHouseholdId(measurement.getHouseholdId());
        m.setUserId(measurement.getUserId());

        m = measurementService.saveMeasurement(m);
        return "redirect:/measurements/";
    }
	
}