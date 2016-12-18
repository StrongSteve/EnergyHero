package com.energyhero.controller;

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

import com.energyhero.domain.Household;
import com.energyhero.service.household.HouseholdService;
import com.energyhero.transfer.CurrentUser;
import com.energyhero.transfer.HouseholdCreateForm;

@Controller
public class HouseholdController {

	private HouseholdService householdService;

	@Autowired
	public void setHouseholdService(HouseholdService householdService) {
		this.householdService = householdService;
	}
	
	
	@RequestMapping(value = "/households", method = RequestMethod.GET)
    public String list(Model model, @AuthenticationPrincipal CurrentUser user){
        model.addAttribute("households", householdService.getAllAvailableHouseholds(user));
        return "households";
    }

	@RequestMapping("/household/remove/{id}")
    public String remove(@PathVariable Long id, Model model){
		householdService.deleteHousehold(id);
        return "redirect:/households/";
    }
	
	@RequestMapping("/household/new")
    public String newHousehold(Model model, @AuthenticationPrincipal CurrentUser user){
        HouseholdCreateForm h = new HouseholdCreateForm();
        h.setUserId(user.getId());
        model.addAttribute("household", h);
        return "householdform";
	}	
	
	@RequestMapping(value = "household", method = RequestMethod.POST)
    public String saveHousehold(@Valid @ModelAttribute(value = "household") HouseholdCreateForm household, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "householdform";
        }

        Household h = new Household();
        h.setName(household.getName());
        h.setSize(household.getSize());
        h.setNumberOfInhabitants(household.getNumberOfInhabitants());
        h.setUserId(household.getUserId());
        
        h = householdService.saveHousehold(h);
        return "redirect:/households/";
    }
}
