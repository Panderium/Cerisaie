package com.panderium.cerisaie.controller;

import com.panderium.cerisaie.model.ActiviteEntity;
import com.panderium.cerisaie.model.ClientEntity;
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
        Map<ActiviteEntity, ClientEntity> clientByActivity = new HashMap<>();

        for (ActiviteEntity activite : activities)
            clientByActivity.put(activite, clientService.findByNumCli(sejourService.findByNumSej(activite.getNumSej()).getNumCli()));

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
