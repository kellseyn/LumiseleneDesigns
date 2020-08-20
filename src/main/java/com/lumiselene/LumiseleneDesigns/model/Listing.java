package com.lumiselene.LumiseleneDesigns.model;

import javax.persistence.*;

@Entity
    @Table(name = "listings")
    public class Listing{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, name = "id")
        private long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private double price;

        @Column(nullable = false)
        private String picture_URL;

        @OneToOne
        private ListingDetails listingDetails;

        public Listing(long id, String title, String description){

        }

    public Listing(long id, String title, String description, String picture_URL, double price) {
        this.title = this.title;
        this.price = this.price;
        this.picture_URL = this.picture_URL;
    }

    public Listing(long id, String title, double price, String picture_URL) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.picture_URL = picture_URL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture_URL() {
        return picture_URL;
    }

    public void setPicture_URL(String picture_URL) {
        this.picture_URL = picture_URL;
    }

    public ListingDetails getListingDetails(){
            return listingDetails;
    }

    public void setListingDetails(ListingDetails listingDetails){
            this.listingDetails = listingDetails;
    }
}

