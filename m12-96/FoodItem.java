
/**
 * This class represents the food items.
 * <p>
 * More information about how to use it and what it can do
 * can be found in the API documentation.
 *
 * @author Netanel Shoshan.
 * @version 11/12/2019
 */

public class FoodItem {
    // Instance variables.
    private long _catalogueNumber;
    private int _quantity;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;
    private String _name;
    private Date _productionDate;
    private Date _expiryDate;

    // Final variables.(Default ones)
    private final String DEFAULT_NAME = "item";
    private final long DEFAULT_CATALOG_NUM = 9999;
    private final int DEFAULT_QUANTITY = 0;
    private final int DEFAULT_PRICE = 1;

    /**
     * Creates a new food item object
     *
     * @param name            name of the food item.
     * @param catalogueNumber catalogue number of the food item.
     * @param quantity        quantity of food item.
     * @param productionDate  production date.
     * @param expiryDate      expiry date.
     * @param minTemperature  minimum storage temperature.
     * @param maxTemperature  maximum storage temperature.
     * @param price           unit price
     */
    public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate,
                    Date expiryDate, int minTemperature, int maxTemperature, int price) {

        /* Assigning the parameters to local vars based on conditions.
        If the conditions not met, will assign the default values as stated first in the class.*/
        if (name.equals("")) {
            _name = DEFAULT_NAME;
        } else {
            _name = name;
        }
        if (catalogueNumber >= 1000 && catalogueNumber <= 9999) {
            _catalogueNumber = catalogueNumber;
        } else {
            _catalogueNumber = DEFAULT_CATALOG_NUM;
        }
        if (quantity >= 0) {
            _quantity = quantity;
        } else {
            _quantity = DEFAULT_QUANTITY;
        }

        _productionDate = new Date(productionDate);

        if (expiryDate.before(productionDate)) {
            _expiryDate = productionDate.tomorrow();
        } else {
            _expiryDate = new Date(expiryDate);
        }

        _minTemperature = Math.min(minTemperature, maxTemperature);
        _maxTemperature = Math.max(minTemperature, maxTemperature);

        if (price >= 1) {
            _price = price;
        } else {
            _price = DEFAULT_PRICE;
        }

    } // End of FoodItem Constructor.

    /**
     * Copy constructor
     *
     * @param other the food item to be copied.
     */
    public FoodItem(FoodItem other) {
        _name = other._name;
        _catalogueNumber = other._catalogueNumber;
        _quantity = other._quantity;
        _productionDate = other._productionDate;
        _expiryDate = other._expiryDate;
        _minTemperature = other._minTemperature;
        _maxTemperature = other._maxTemperature;
        _price = other._price;

    } // End of FoodItem (copy constructor).

    /**
     * Checks if two food items are the same
     * (Excluding the quantity values)
     *
     * @param other the food item to compare this food item to.
     * @return true if the food items are the same.
     */
    public boolean equals(FoodItem other) {
        return (_name.equals(other._name) && _catalogueNumber == other._catalogueNumber &&
                _productionDate.equals(other._productionDate) && _expiryDate.equals(other._expiryDate) &&
                _minTemperature == other._minTemperature && _maxTemperature == other._maxTemperature && _price == other._price);

    } // End of Equal method.

    /**
     * Gets the catalogue number.
     *
     * @return the catalogue number.
     */
    public long getCatalogueNumber() {
        return _catalogueNumber;
    }// End of getCatalogNumber method.

    /**
     * Gets the expiry date.
     *
     * @return the expiry date.
     */
    public Date getExpiryDate() {
        return new Date(_expiryDate);
    } // End of getExpiryDate method.

    /**
     * Gets the maximum storage temperature.
     *
     * @return the maximum storage temperature.
     */
    public int getMaxTemperature() {
        return _maxTemperature;
    } // End of getMaxTemperature method.

    /**
     * Gets the minimum storage temperature.
     *
     * @return the minimum storage temperature.
     */
    public int getMinTemperature() {
        return _minTemperature;
    } // End of getMaxTemperature method.

    /**
     * Get's the name.
     *
     * @return the name.
     */
    public String getName() {
        return _name;
    } // End of getName method.

    /**
     * Gets the unit price.
     *
     * @return the unit price.
     */
    public int getPrice() {
        return _price;
    }// End of getPrice method.

    /**
     * Gets the production date.
     *
     * @return the production date.
     */
    public Date getProductionDate() {
        return new Date(_productionDate);
    }// End of getProductionDate method.

    /**
     * Gets the quantity
     *
     * @return the quantity
     */
    public int getQuantity() {
        return _quantity;
    } // End of getQuantity method.

    /**
     * Returns the number of units of products that
     * can be purchased for a given amount.
     *
     * @param amount amount to purchase.
     * @return the number of units that can be purchased.
     */
    public int howManyItems(int amount) {
        return Math.min(amount / _price, _quantity);
    } // End of howManyItems method.

    /**
     * Checks if this food item is cheaper then other food item.
     *
     * @param other food item to compare this food item to.
     * @return true if this food item is cheaper than other item.
     */
    public boolean isCheaper(FoodItem other) {
        return _price < other._price;
    } // End of isCheaper method.

    /**
     * Checks if this food item is fresh on date < d >.
     *
     * @param d date to check.
     * @return true if this food item is fresh on the date < d >.
     */
    public boolean isFresh(Date d) {
        return (!d.before(_productionDate) && !d.after(_expiryDate));
    } // End of isFresh method.

    /**
     * Checks if this food item is older than other food item.
     *
     * @param other food item to compare this food item to.
     * @return true if this food item is older than other date.
     */
    public boolean olderFoodItem(FoodItem other) {
        return (_productionDate.before(other._productionDate));
    } // End of olderFoodItem method.

    /**
     * Sets the expiry date (only if nit before production date.)
     *
     * @param d expiry date value to be set.
     */
    public void setExpiryDate(Date d) {
        if (!_productionDate.after(d)) {
            _expiryDate = new Date(d);
        }
    } // End of setExpiryDate method.

    /**
     * Sets the price.
     *
     * @param n price value to be set.
     */
    public void setPrice(int n) {
        if (n > 1)
            _price = n;
    } // End of setPrice method.

    /**
     * Sets the production date (only if not after expiry date.)
     *
     * @param d production date value to be set.
     */
    public void setProductionDate(Date d) {
        if (!d.after(_expiryDate)) {
            _productionDate = new Date(d);
        }
    } // End of setProductionDate method.

    /**
     * Sets the quantity (only if not negative.)
     *
     * @param n the quantity value to be set.
     */
    public void setQuantity(int n) {
        if (n >= 0)
            _quantity = n;
    }// End of setQuantity method.

    /**
     * Returns a String that represents this food item.
     *
     * @return String that represents this food item in the following format:
     * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3
     */
    public String toString() {
        return "FoodItem: " + _name + "\tCatalogueNumber: " + _catalogueNumber +
                "\tProductionDate: " + _productionDate + "\tExpiryDate: " + _expiryDate +
                "\tQuantity: " + _quantity;
    } // End of toString Method.
} // End of FoodItem class.
