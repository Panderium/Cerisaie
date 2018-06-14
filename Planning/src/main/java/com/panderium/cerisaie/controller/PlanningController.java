package com.panderium.cerisaie.controller;

import com.panderium.cerisaie.model.ActiviteEntity;
import com.panderium.cerisaie.model.ClientEntity;
import com.panderium.cerisaie.model.SejourEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.panderium.cerisaie.service.IActiviteService;
import com.panderium.cerisaie.service.IClientService;
import com.panderium.cerisaie.service.ISejourService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PlanningController {

    @Autowired
    private IActiviteService activiteService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private ISejourService sejourService;


    @RequestMapping(value = "/planning", method = RequestMethod.GET)
    public String displayAllActivities(Model model) {
        List<ActiviteEntity> activities = activiteService.listAll();
        Map<ActiviteEntity, SejourEntity> clientByActivity = new HashMap<>();
        System.out.println(sejourService.findByNumSej(activities.get(0).getNumSej()));
        System.out.println(clientService.findByNumCli(sejourService.findByNumSej(activities.get(0).getNumSej()).getNumCli()));

        for (ActiviteEntity activite : activities)
            clientByActivity.put(activite, sejourService.findByNumSej(activite.getNumSej()));

        model.addAttribute("oneActivity", Boolean.FALSE);
        model.addAttribute("clientByActivity", clientByActivity);
        return "activities";
    }

    @RequestMapping(value = "/planning/{codeSport}", method = RequestMethod.GET)
    public String displayOneActivity(Model model, @PathVariable int codeSport) {
        ActiviteEntity activite = activiteService.findAllByCodeSport(codeSport);
        ClientEntity client = clientService.findByNumCli(sejourService.findByNumSej(activite.getNumSej()).getNumCli());
        model.addAttribute("oneActivity", Boolean.TRUE);
        model.addAttribute("client", client);
        model.addAttribute("activite", activite);
        return "activities";
    }
}
