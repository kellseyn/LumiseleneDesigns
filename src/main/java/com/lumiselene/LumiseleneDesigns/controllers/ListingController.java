package com.lumiselene.LumiseleneDesigns.controllers;

import com.lumiselene.LumiseleneDesigns.model.Listing;
import com.lumiselene.LumiseleneDesigns.repositories.ListingRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class ListingController {
    private ListingRepository listingDao;

    public ListingController(ListingRepository listingDao) {
        this.listingDao = listingDao;

    }

    @GetMapping("/listings")
    public String listingsIndex(Model model) {
        model.addAttribute("listings", listingDao.findAll());
        return "listings/index";
    }

    @GetMapping("/listings/{id}/edit")
    public String viewEditListingForm(@PathVariable long id, Model model) {
        model.addAttribute("listing", listingDao.getOne(id));
        return "listings/edit";
    }

    @PostMapping("/listings/{id}/edit")
    public String updateListing(@PathVariable long id, @RequestParam String title, @RequestParam String description, @RequestParam String picture_URL, @RequestParam double price) {
        Listing l = new Listing(
                id,
                title,
                description,
                picture_URL,
                price
        );
        listingDao.save(l);
        return "redirect:/posts";
    }

    @PostMapping("/listings/{id}/delete")
    public String deleteListing(@PathVariable long id) {
        System.out.println("Does this run?");
        listingDao.deleteById(id);
        return "redirect:/listings";
    }

    @GetMapping("/listings/{id}")
    public String viewListing(@PathVariable long id, Model model) {
        model.addAttribute("title", listingDao.getOne(id));
        return "listings/show";
    }


    @GetMapping("/listings/create")
    public String createListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return "posts/create";
    }
    @PostMapping("/listings/create")
    public String createListing(@ModelAttribute Listing listing) {
        listingDao.save(listing);
        return "redirect:/listings";
    }

    @GetMapping("one/test")
    public String returnOneToViewOne(Model model) {
        model.addAttribute("listings", listingDao.findAll());
        return "one-to-one-test";
    }
}
