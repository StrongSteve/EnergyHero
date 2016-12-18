package com.energyhero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.energyhero.service.household.HouseholdService;
import com.energyhero.transfer.CurrentUser;

public class HouseholdController {

	private HouseholdService householdService;

	@Autowired
	public void setHouseholdService(HouseholdService householdService) {
		this.householdService = householdService;
	}
	
	/*
	@RequestMapping(value = "/households", method = RequestMethod.GET)
    public String list(Model model, @AuthenticationPrincipal CurrentUser user){
        model.addAttribute("households", householdService.getAllAvailableHouseholds(user));
        return "households";
    }
	*/
	
	@RequestMapping(value = "/households", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("households", householdService.getAllAvailableHouseholds());
        return "households";
    }
	
	
}
