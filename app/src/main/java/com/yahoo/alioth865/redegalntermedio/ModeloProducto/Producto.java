package com.yahoo.alioth865.redegalntermedio.ModeloProducto;

import java.io.Serializable;

/**
 * Created by Alioth on 24/02/2015.
 */
public class Producto implements Serializable{
    private String id;
    private String id_manufacturer;
    private String id_supplier;
    private String id_category;
    private String id_category_default;
    private String cache_default_attribute;
    private String is_virtual;
    private String on_sale;
    private String online_only;
    private String minimal_quantity;
    private String price;
    private String condition;
    private Name name;
    private Description description;
    private DescriptionShort description_short;
    private AvailableNow available_now;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_manufacturer() {
        return id_manufacturer;
    }

    public void setId_manufacturer(String id_manufacturer) {
        this.id_manufacturer = id_manufacturer;
    }

    public String getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(String id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getId_category_default() {
        return id_category_default;
    }

    public void setId_category_default(String id_category_default) {
        this.id_category_default = id_category_default;
    }

    public String getCache_default_attribute() {
        return cache_default_attribute;
    }

    public void setCache_default_attribute(String cache_default_attribute) {
        this.cache_default_attribute = cache_default_attribute;
    }

    public String getIs_virtual() {
        return is_virtual;
    }

    public void setIs_virtual(String is_virtual) {
        this.is_virtual = is_virtual;
    }

    public String getOn_sale() {
        return on_sale;
    }

    public void setOn_sale(String on_sale) {
        this.on_sale = on_sale;
    }

    public String getOnline_only() {
        return online_only;
    }

    public void setOnline_only(String online_only) {
        this.online_only = online_only;
    }

    public String getMinimal_quantity() {
        return minimal_quantity;
    }

    public void setMinimal_quantity(String minimal_quantity) {
        this.minimal_quantity = minimal_quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public DescriptionShort getDescription_short() {
        return description_short;
    }

    public void setDescription_short(DescriptionShort description_short) {
        this.description_short = description_short;
    }

    public AvailableNow getAvailable_now() {
        return available_now;
    }

    public void setAvailable_now(AvailableNow available_now) {
        this.available_now = available_now;
    }
}
