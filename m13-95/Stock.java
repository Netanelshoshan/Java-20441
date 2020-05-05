import java.util.Arrays;

/**
 * This class represent the Stock of the supermarket.*
 * <p>
 * More information and on how to use it can be found in the API documentation.
 *
 * Bugs I didn't managed to solve:
 *
 * 1. The ORDER method: if there's a difference between production dates and same exp date.
 * (two items with the same name like milk prod: 1/2/2000 and milk prod: 2/1/2000 it'll count in
 * as a product u need to order.)
 *
 * 2. The getTempOfStock method: if There's an item that his minimum tmp equal max tmp of other one
 * in the stock, It won't return Integer.MAX_VALUE.
 *
 * 3. The updateStock method: if there's more than two item that equal each other, it won't do the calculation
 * correctly.
 *
 *
 * @author Netanel Shoshan.
 * @version 28/12/2019.
 */


public class Stock {

    // Final variables.
    private final int MAX_ITEMS = 100;
    //Instance variables.
    private FoodItem[] _stock;
    private int _noOfItems;

    /**
     * Constructor for the Stock class.
     * Takes no arguments, but initializes the _stock array and limits the array length to 100 (MAX_ITEMS).
     * Sets the number of items in the array to 0.
     */
    public Stock() {
        _stock = new FoodItem[MAX_ITEMS];
        _noOfItems = 0;
    }// End of the constructor method.

    /**
     * This method returns the Number of items in the array based on their attributes.
     *
     * @return the number of items in the array.
     */
    public int getNumOfItems() {

        // Traverse the array.
        int items = 0;
        for (int i = 0; i < _noOfItems; i++) {
            // Increments the index by 1 while there are duplicates.
            while (i < _noOfItems - 1 && _stock[i].getName().equals((_stock[i + 1].getName())))
                i++;
            items++;
        }
        return items;
    }// End of getNumOfItems method.

    /**
     * This method will evaluate the newItem that you want to add into the stock based on this rules:
     * <p>
     * <p>
     * 1. If _stock[i] is null (empty), will assign the newItem into the array.
     * 2. If newItem equals (except the quantity) will add the quantity of the newItem to the item in the array.
     * 3. If newItem ("name" & "catalogueNum") are equal _stock[i] ("name" & "catalogueNum"), will check if the
     * production date or the expiry date are different and if there's a difference, will assign the newItem to
     * a new point before the existing item in the array.
     *
     * @param newItem The new Food item you want to add to the stock.
     * @return true if newItem was added successfully, otherwise return false.
     */
    public boolean addItem(FoodItem newItem) {
        for (int i = 0; i < _stock.length; i++) {
            // If the point in array is empty, will assign the item
            if (_stock[i] == null) {
                _stock[i] = new FoodItem(newItem);
                _noOfItems++;
                sortStock();
                return true;

                /* If the item equals another item in the stock
                (excluding the quantity) */
            } else if (_stock[i].equals(newItem)) {
                _stock[i].setQuantity(_stock[i].getQuantity() + newItem.getQuantity());
                sortStock();
                return true;

                // Will check for rule No.3
            } else if (_stock[i].getName().equals(newItem.getName()) &&
                    _stock[i].getCatalogueNumber() == newItem.getCatalogueNumber())
                if (!_stock[i].getProductionDate().equals(newItem.getProductionDate())
                        && !_stock[i].getExpiryDate().equals(newItem.getExpiryDate())) {
                    FoodItem swap = new FoodItem(_stock[i]);
                    _stock[i] = new FoodItem(newItem);
                    for (int j = i; j < _noOfItems; j++)
                        _stock[i] = _stock[j];
                    _stock[_noOfItems++] = new FoodItem(swap);
                    _stock[i] = new FoodItem(newItem);
                    sortStock();
                    return true;
                }
        }
        return false;
    }// End of addItem method.


    /**
     * This method will traverse through the stock and sort it in ascending order by catalog number.
     * If there's an item in the stock with quantity of 0, will remove him from the array.
     */
    private void sortStock() {

        for (int i = 0; i < _noOfItems; i++) {
            for (int j = i + 1; j < _noOfItems; j++) {
                if (_stock[i].getCatalogueNumber() > _stock[j].getCatalogueNumber()) {
                    FoodItem bigger = new FoodItem(_stock[i]);
                    _stock[i] = bigger;
                    _stock[i] = _stock[j];
                    _stock[j] = bigger;
                }
            }
        }
         /* Will check for item with quantity of 0, if found, will remove him and
        sort the array */
        for (int i = 0; i < _noOfItems; i++) {
            if (_stock[i].getQuantity() == 0) {
                for (int j = i; j < _noOfItems - 1; j++)
                    _stock[j] = _stock[j + 1];
                _stock[_noOfItems - 1] = null;
                _noOfItems--;
            }
        }


    }// End of sortStock method.

    /**
     * This method checks if the amount that you specified is bigger then the quantity of each
     * object in the stock, and will return a string with the names of the items that you should order.
     *
     * @param amount the amount to check.
     * @return a string with the names of the items that you should order.
     */
    public String order(int amount) {
        String order = ""; // what should we order
        String moreThenOne = ""; // A string to append all the repeated names .

        for (int i = 0; i < _noOfItems; i++) {
            boolean moreThenOneFlag = false;
            for (int j = i + 1; j < _noOfItems; j++) {
                if (_stock[i].getName().equals((_stock[j].getName()))) {
                    moreThenOneFlag = true;
                    moreThenOne += _stock[i].getName() + ", ";
                    if (_stock[i].getQuantity() + _stock[j].getQuantity() < amount) {
                        if (!order.contains(_stock[i].getName())) {
                            order += _stock[i].getName() + ", ";
                        }
                    }
                } else {
                    //if we've reached the end of j and we have more then one item that equals and the name does not appear
                    // in moreThenOne string. then it'll check whether this item qty is less then amount.
                    if (!moreThenOneFlag && j == _noOfItems - 1 && !moreThenOne.contains(_stock[i].getName())) {
                        if (_stock[i].getQuantity() < amount) {
                            if (!order.contains(_stock[i].getName())) {
                                order += _stock[i].getName() + ", ";
                            }
                        }
                    }
                }
            }
            //if we've reached the end of i and we have more then one item that equals and the name does not appear
            // in moreThenOne string. then it'll check whether this item qty is less then amount.
            if (i == _noOfItems - 1 && !moreThenOneFlag && !moreThenOne.contains(_stock[i].getName())) {
                if (_stock[i].getQuantity() < amount) {
                    if (!order.contains(_stock[i].getName())) {
                        order += _stock[i].getName() + ", ";

                    }
                }
            }
        }

        // If the string isn't empty, it'll subtract the last two chars from the end.(", ")
        if (!order.equals("")) {
            order = order.substring(0, order.length() - 2);
        }

        return order;
    }// End of order method.

    /**
     * This method gets the amount of temperature that you specified and will run a check for every
     * item in the array and will return a result with how many items can be in the temperature.
     * (including the quantity of each one)
     *
     * @param temp the temperature to check.
     * @return how many items can be in that temperature.
     */
    public int howMany(int temp) {
        // Counter to add the items that can be stored in the temperature.
        int counter = 0;
        if (_noOfItems == 0) return 0;
        for (int i = 0; i < _noOfItems; i++) {
            if (_stock[i].getMinTemperature() <= temp && _stock[i].getMaxTemperature() >= temp) {
                counter += _stock[i].getQuantity();
            } else if (_stock[i] == null)
                return counter;
        }
        return counter;
    }// End of howMany method.

    /**
     * This method will remove items from the stock only if there's expiry date is
     * before the one in the parameter.
     * If there isn't one, will do nothing.
     *
     * @param d the expiry date that you want to check.
     */
    public void removeAfterDate(Date d) {
        int i;
        for (i = 0; i < _noOfItems; i++) {
            /* Will start iterating through the array, and if there's a match, will remove
             it from the array and move all the elements to the left. */
            while (i < _noOfItems && _stock[i].getExpiryDate().before(d)) {
                for (int j = i; j < _noOfItems; j++)
                    _stock[j] = _stock[j + 1];
                _stock[_noOfItems - 1] = null;
                _noOfItems--;
            }
        }
    }// End of removeAfterDate method.

    /**
     * This method will return the most expensive item in the stock.
     * if the stock is empty, will return null.
     *
     * @return the most expensive item in the stock. if the stock is empty, will return null.
     */
    public FoodItem mostExpensive() {
        if (_noOfItems == 0) return null; // empty array

        //Initializing Maximum element.
        FoodItem max = new FoodItem(_stock[0]);
        for (int i = 1; i < _noOfItems; i++) {
            {
                if (_stock[i].getPrice() > max.getPrice()) {
                    max = new FoodItem(_stock[i]);
                }
            }
        }
        return new FoodItem(max);
    }// End of mostExpensive method.

    /**
     * This method will return how may items in the stock. (including the quantity of each one)
     *
     * @return how many items in the stock. if the stock empty, will return 0.
     */
    public int howManyPieces() {
        // Counter to add the items.
        int counter = 0;

        for (int i = 0; i < _noOfItems; i++)
            counter += _stock[i].getQuantity();
        return counter;
    }// End of howManyPieces method.

    /**
     * This method will update the stock based on the string array that it gets.
     * Will decrease the quantity of each item in a list by how many times the name appeared
     * in the stock. If the quantity of the item has reached to - 0 , will delete the item from the stock.
     *
     * @param itemList the array with the name of items that should be updated.
     */
    /**
     * This method will update the stock based on the string array that it gets.
     * Will decrease the quantity of each item in a list by how many times the name
     * appeared in the array. If the quantity of the item has reached to - 0 , will
     * delete the item from the array.
     *
     * @param itemList the array with the name of items that should be updated.
     */
    public void updateStock(String[] itemList) {
        for (int i = 0; i < _noOfItems; i++) {
            for (int j = 0; j < itemList.length; j++) {
                if (isMyNeighborEquals()) {
                    if (itemList[j].equals(_stock[i].getName())) {
                        _stock[i].setQuantity(_stock[i].getQuantity() - 1);
                    }
                } else {
                    if (itemList[j].equals(_stock[i].getName())) {
                        _stock[i].setQuantity(_stock[i].getQuantity() - 1);
                    }
                }
                sortStock();

                //Got stuck here and didn't managed to figure a solution.
            }
        }

    }// End of updateStock method.

    /**
     * checks if two neighbors equal.
     *
     * @return true if two are equal , otherwise return false.
     */
    private boolean isMyNeighborEquals() {
        for (int i = 0; i < _noOfItems; i++) {
            for (int j = i + 1; j < _noOfItems; j++)
                if (_stock[i].getName().equals(_stock[j].getName()))
                    return true;
        }
        return false;
    }

    /**
     * This method will return the temperature the refrigerator should be.
     * The temperature will be determined by the lowest item temperature in the stock.
     * If the array is empty or it couldn't find any a temperature that in the range of all stock items temp
     * or if the array is empty will return the Integer.MAX_VALUE.
     *
     * @return the temperature that can contain all the item in the stock.
     */
    public int getTempOfStock() {
        // Declaring local variables.
        int temp = 0; // The temperature the refrigerator can contain all the the items.
        int lowest = getMinTemp(); // Getting the lowest item temp in the stock using the getMinTemp method.
        int highest = getMaxTemp(); // Getting the highest item temp in the stock using the getMaxTemp method.
        if (_noOfItems == 0) return Integer.MAX_VALUE;
        for (int i = 0; i < _noOfItems; i++) {
            for (int j = 0; j < _noOfItems; j++) {
                if (_stock[j].getMinTemperature() > _stock[i].getMinTemperature()) {
                    if (_stock[j].getMinTemperature() > _stock[i].getMaxTemperature()) {
                        /*
                         * This if statement will be executed only if there's an item temperatures that
                         * not in the range of all the others.
                         */
                        temp = Integer.MAX_VALUE;
                    } else {
                        temp = _stock[j].getMinTemperature();
                    }
                }


            }
        }
        return temp;
    }// End of getTempOfStock method.

    /**
     * Method for getting the highest temperature in the stock.
     *
     * @return the max temperature in the stock.
     */
    private int getMaxTemp() {
        if (_noOfItems == 0) return -1;// if Stock is empty
        FoodItem maxTemp = new FoodItem(_stock[0]);
        int maxT = 0;
        for (int i = 1; i < _noOfItems; i++) {
            if (_stock[i].getMaxTemperature() > maxTemp.getMaxTemperature()) {
                maxTemp = new FoodItem(_stock[i]);
            }
        }
        maxT = maxTemp.getMaxTemperature();
        return maxT;
    }// End of getMaxTemp method.

    /**
     * Method for getting the lowest item temperature in the stock.
     * if the stock is empty will return -1.
     *
     * @return the lowest temp in the stock.
     */
    private int getMinTemp() {
        if (_noOfItems == 0) return -1; // if Stock is empty
        FoodItem minTemp = new FoodItem(_stock[0]);
        int minT = 0;
        for (int i = 1; i < _noOfItems; i++) {
            if (_stock[i].getMinTemperature() < minTemp.getMinTemperature())
                minTemp = new FoodItem(_stock[i]);
        }
        minT = minTemp.getMinTemperature();
        return minT;
    }// End of getMinTemp method.

    /**
     * Will print the items in the stock.
     *
     * @return the stock.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < _noOfItems; i++)
            str += _stock[i] + "\n";
        return str;
    }// End of toString method.

}