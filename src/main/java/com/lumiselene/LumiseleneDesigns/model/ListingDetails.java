package com.lumiselene.LumiseleneDesigns.model;


import javax.persistence.*;

@Entity
@Table(name = "listing_details")
public class ListingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int inStockQuantity;

    @Column(nullable = false)
    private int toCartQuantity;

    @OneToOne(mappedBy = "listingDetails")
    private Listing listing;

    public ListingDetails(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInStockQuantity() {
        return inStockQuantity;
    }

    public void setInStockQuantity(int inStockQuantity) {
        this.inStockQuantity = inStockQuantity;
    }

    public int getToCartQuantity() {
        return toCartQuantity;
    }

    public void setToCartQuantity(int toCartQuantity) {
        this.toCartQuantity = toCartQuantity;
    }
}
