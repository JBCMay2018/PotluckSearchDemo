package me.afua.potluckdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class DishController {
    @Autowired
    PotluckRepository pledges;

    @RequestMapping("/")
    public String showIndex(Model model)
    {
        model.addAttribute("pledges",pledges.findAll());
        return "index";
    }


    @RequestMapping("/dishadd")
    public String fillDishes(Model model)
    {
        Potluck promise;
        for (int i=0; i<20; i++)
        {
            promise = new Potluck();
            promise.setDish("Dish "+i);
            promise.setName("Person "+i);
            pledges.save(promise);
        }
        model.addAttribute("pledges",pledges.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String searchPromises(Model model, HttpServletRequest request)
    {
        String searchedFor = request.getParameter("searchfor");

        model.addAttribute("searchResults",true);
        model.addAttribute("pledges",pledges.findAllByDishContainingIgnoreCase(searchedFor));
        return "index";
    }

}
