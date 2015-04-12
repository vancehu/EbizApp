package my.ebizapp.model;

import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
public class CartBasic {

    private Product product;

    private Supplier supplier;

    private float priceSnapshot;

    private long quantity;

    private Date time = new Date();
}
