package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.models.database.Technology;
import org.softwire.training.bookish.models.page.AboutPageModel;
import org.softwire.training.bookish.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/SearchDatabase")
public class SearchDatabaseController {

    private final TechnologyService technologyService;

    @Autowired
    public SearchDatabaseController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @RequestMapping("")
    ModelAndView SearchDatabase() {

        List<Technology> allTechnologies = technologyService.getAllTechnologies();

        AboutPageModel aboutPageModel = new AboutPageModel();
        aboutPageModel.setTechnologies(allTechnologies);

        return new ModelAndView("about", "model", aboutPageModel);
    }
}
